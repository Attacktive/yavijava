/*================================================================================
Copyright (c) 2012 Steve Jin. All Rights Reserved.
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.DasConfigFault;
import com.vmware.vim25.HostCapability;
import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.HostConfigInfo;
import com.vmware.vim25.HostConfigManager;
import com.vmware.vim25.HostConnectFault;
import com.vmware.vim25.HostConnectInfo;
import com.vmware.vim25.HostConnectSpec;
import com.vmware.vim25.HostFlagInfo;
import com.vmware.vim25.HostHardwareInfo;
import com.vmware.vim25.HostIpmiInfo;
import com.vmware.vim25.HostLicensableResourceInfo;
import com.vmware.vim25.HostListSummary;
import com.vmware.vim25.HostMaintenanceSpec;
import com.vmware.vim25.HostPowerOpFailed;
import com.vmware.vim25.HostRuntimeInfo;
import com.vmware.vim25.HostServiceTicket;
import com.vmware.vim25.HostSystemReconnectSpec;
import com.vmware.vim25.HostSystemResourceInfo;
import com.vmware.vim25.HostSystemSwapConfiguration;
import com.vmware.vim25.HostTpmAttestationReport;
import com.vmware.vim25.InvalidIpmiLoginInfo;
import com.vmware.vim25.InvalidIpmiMacAddress;
import com.vmware.vim25.InvalidLogin;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotSupported;
import com.vmware.vim25.RequestCanceled;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.Timedout;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.mo.util.MorUtil;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class HostSystem extends ManagedEntity {

	private HostConfigManager configManager = null;

	public HostSystem(ServerConnection sc, ManagedObjectReference mor) {
		super(sc, mor);
	}

	public HostCapability getCapability() {
		return (HostCapability)getCurrentProperty("capability");
	}

	public HostConfigInfo getConfig() {
		return (HostConfigInfo)getCurrentProperty("config");
	}

	public Datastore[] getDatastores() throws InvalidProperty, RuntimeFault, RemoteException {
		return getDatastores("datastore");
	}

	public HostDatastoreBrowser getDatastoreBrowser() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostDatastoreBrowser)getManagedObject("datastoreBrowser");
	}

	public HostHardwareInfo getHardware() {
		return (HostHardwareInfo)getCurrentProperty("hardware");
	}

	/**
	 * @since SDK5.0
	 */
	public HostLicensableResourceInfo getLicensableResource() {
		return (HostLicensableResourceInfo)getCurrentProperty("licensableResource");
	}

	public Network[] getNetworks() throws InvalidProperty, RuntimeFault, RemoteException {
		return getNetworks("network");
	}

	public HostRuntimeInfo getRuntime() {
		return (HostRuntimeInfo)getCurrentProperty("runtime");
	}

	public HostListSummary getSummary() {
		return (HostListSummary)getCurrentProperty("summary");
	}

	public HostSystemResourceInfo getSystemResources() {
		return (HostSystemResourceInfo)getCurrentProperty("systemResources");
	}

	public VirtualMachine[] getVms() throws InvalidProperty, RuntimeFault, RemoteException {
		return getVms("vm");
	}

	public HostServiceTicket acquireCimServicesTicket() throws RuntimeFault, RemoteException {
		return getVimService().acquireCimServicesTicket(getMOR());
	}

	public Task disconnectHost() throws RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().disconnectHost_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}

	/**
	 * @since SDK4.1
	 */
	public void enterLockdownMode() throws HostConfigFault, RuntimeFault, RemoteException {
		getVimService().enterLockdownMode(getMOR());
	}

	/**
	 * keep the old signature for compatibility
	 */
	public Task enterMaintenanceMode(int timeout, boolean evacuatePoweredOffVms) throws Timedout, InvalidState, RuntimeFault, RemoteException {
		return enterMaintenanceMode(timeout, evacuatePoweredOffVms, null);
	}

	/**
	 * @since SDK5.5
	 */
	public Task enterMaintenanceMode(int timeout, boolean evacuatePoweredOffVms, HostMaintenanceSpec maintenanceSpec) throws Timedout, InvalidState, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().enterMaintenanceMode_Task(getMOR(), timeout, new Boolean(evacuatePoweredOffVms), maintenanceSpec);
		return new Task(getServerConnection(), mor);
	}

	/**
	 * @since SDK4.1
	 */
	public void exitLockdownMode() throws HostConfigFault, RuntimeFault, RemoteException {
		getVimService().exitLockdownMode(getMOR());
	}

	public Task exitMaintenanceMode(int timeout) throws Timedout, InvalidState, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().exitMaintenanceMode_Task(getMOR(), timeout);
		return new Task(getServerConnection(), mor);
	}

	public Task powerDownHostToStandBy(int timeSec, boolean evacuatePoweredOffVms) throws RequestCanceled, HostPowerOpFailed, NotSupported, Timedout, InvalidState, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().powerDownHostToStandBy_Task(getMOR(), timeSec, new Boolean(evacuatePoweredOffVms));
		return new Task(getServerConnection(), mor);
	}

	public Task powerUpHostFromStandBy(int timeSec) throws HostPowerOpFailed, NotSupported, Timedout, InvalidState, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().powerUpHostFromStandBy_Task(getMOR(), timeSec);
		return new Task(getServerConnection(), mor);
	}

	public HostConnectInfo queryHostConnectionInfo() throws RuntimeFault, RemoteException {
		return getVimService().queryHostConnectionInfo(getMOR());
	}

	/**
	 * @since SDK5.1
	 */
	public HostTpmAttestationReport queryTpmAttestationReport() throws RuntimeFault, RemoteException {
		return getVimService().queryTpmAttestationReport(getMOR());
	}

	/**
	 * @since SDK5.1
	 */
	public void updateSystemSwapConfiguration(HostSystemSwapConfiguration sysSwapConfig) throws RuntimeFault, RemoteException {
		getVimService().updateSystemSwapConfiguration(getMOR(), sysSwapConfig);
	}

	public long queryMemoryOverhead(long memorySize, int videoRamSize, int numVcpus) throws RuntimeFault, RemoteException {
		return getVimService().queryMemoryOverhead(getMOR(), memorySize, new Integer(videoRamSize), numVcpus);
	}

	public long queryMemoryOverheadEx(VirtualMachineConfigInfo vmConfigInfo) throws RuntimeFault, RemoteException {
		return getVimService().queryMemoryOverheadEx(getMOR(), vmConfigInfo);
	}

	public Task rebootHost(boolean force) throws InvalidState, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().rebootHost_Task(getMOR(), force);
		return new Task(getServerConnection(), mor);
	}

	public Task reconfigureHostForDAS() throws DasConfigFault, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().reconfigureHostForDAS_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}

	//SDK4.1 signature for back compatibility
	public Task reconnectHost_Task(HostConnectSpec hcs) throws InvalidName, InvalidLogin, InvalidState, HostConnectFault, RuntimeFault, RemoteException {
		return reconnectHost_Task(hcs, null);
	}

	//SDK5.0 signature
	public Task reconnectHost_Task(HostConnectSpec cnxSpec, HostSystemReconnectSpec reconnectSpec) throws InvalidName, InvalidLogin, InvalidState, HostConnectFault, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().reconnectHost_Task(getMOR(), cnxSpec, reconnectSpec);
		return new Task(getServerConnection(), mor);
	}

	/**
	 * @since SDK4.1
	 */
	public long retrieveHardwareUptime() throws RuntimeFault, RemoteException {
		return getVimService().retrieveHardwareUptime(getMOR());
	}

	public Task shutdownHost_Task(boolean force) throws InvalidState, NotSupported, RuntimeFault, RemoteException {
		ManagedObjectReference mor = getVimService().shutdownHost_Task(getMOR(), force);
		return new Task(getServerConnection(), mor);
	}

	public void updateFlags(HostFlagInfo hfi) throws RuntimeFault, RemoteException {
		getVimService().updateFlags(getMOR(), hfi);
	}

	public void updateSystemResources(HostSystemResourceInfo resourceInfo) throws RuntimeFault, RemoteException {
		getVimService().updateSystemResources(getMOR(), resourceInfo);
	}

	/**
	 * @since 4.0
	 */
	public void updateIpmi(HostIpmiInfo ipmiInfo) throws InvalidIpmiLoginInfo, InvalidIpmiMacAddress, RuntimeFault, RemoteException {
		getVimService().updateIpmi(getMOR(), ipmiInfo);
	}

	private HostConfigManager getConfigManager() throws InvalidProperty, RuntimeFault, RemoteException {
		if (configManager == null) {
			configManager = (HostConfigManager)getCurrentProperty("configManager");
		}
		return configManager;
	}

	public OptionManager getOptionManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return new OptionManager(getServerConnection(),
			getConfigManager().getAdvancedOption());
	}

	public HostAutoStartManager getHostAutoStartManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return new HostAutoStartManager(getServerConnection(),
			getConfigManager().getAutoStartManager());
	}

	public HostBootDeviceSystem getHostBootDeviceSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostBootDeviceSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getBootDeviceSystem());
	}

	public HostDateTimeSystem getHostDateTimeSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostDateTimeSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getDateTimeSystem());
	}

	public HostDiagnosticSystem getHostDiagnosticSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostDiagnosticSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getDiagnosticSystem());
	}

	public HostEsxAgentHostManager getHostEsxAgentHostManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostEsxAgentHostManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getEsxAgentHostManager());
	}

	public HostCacheConfigurationManager getHostCacheConfigurationManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostCacheConfigurationManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getCacheConfigurationManager());
	}

	public HostCpuSchedulerSystem getHostCpuSchedulerSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostCpuSchedulerSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getCpuScheduler());
	}

	public HostDatastoreSystem getHostDatastoreSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostDatastoreSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getDatastoreSystem());
	}

	public HostFirmwareSystem getHostFirmwareSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostFirmwareSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getFirmwareSystem());
	}

	/**
	 * @since SDK5.5
	 */
	public HostGraphicsManager getHostGraphicsManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostGraphicsManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getGraphicsManager());
	}

	/**
	 * @since SDK4.0
	 */
	public HostKernelModuleSystem getHostKernelModuleSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostKernelModuleSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getKernelModuleSystem());
	}

	/**
	 * @since SDK4.0
	 */
	public LicenseManager getLicenseManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (LicenseManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getLicenseManager());
	}

	/**
	 * @since SDK4.0
	 */
	public HostPciPassthruSystem getHostPciPassthruSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostPciPassthruSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getPciPassthruSystem());
	}

	/**
	 * @since SDK4.0
	 */
	public HostVirtualNicManager getHostVirtualNicManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostVirtualNicManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getVirtualNicManager());
	}

	public HostHealthStatusSystem getHealthStatusSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostHealthStatusSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getHealthStatusSystem());
	}

	public HostFirewallSystem getHostFirewallSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostFirewallSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getFirewallSystem());
	}

	public HostImageConfigManager getHostImageConfigManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostImageConfigManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getImageConfigManager());
	}

	public HostMemorySystem getHostMemorySystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostMemorySystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getMemoryManager());
	}

	public HostNetworkSystem getHostNetworkSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostNetworkSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getNetworkSystem());
	}

	public HostPatchManager getHostPatchManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostPatchManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getPatchManager());
	}

	public HostServiceSystem getHostServiceSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostServiceSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getServiceSystem());
	}

	public HostSnmpSystem getHostSnmpSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostSnmpSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getSnmpSystem());
	}

	public HostStorageSystem getHostStorageSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostStorageSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getStorageSystem());
	}

	/**
	 * @since SDK5.5
	 */
	public HostVFlashManager getHostVFlashManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostVFlashManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getVFlashManager());
	}

	public IscsiManager getIscsiManager() throws InvalidProperty, RuntimeFault, RemoteException {
		return (IscsiManager)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getIscsiManager());
	}

	/**
	 * @deprecated as of SDK 4.0, use getHostVirtualNicManager instead
	 */
	public HostVMotionSystem getHostVMotionSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostVMotionSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getVmotionSystem());
	}

	/**
	 * @since SDK5.5
	 */
	public HostVsanInternalSystem getHostVsanInternalSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostVsanInternalSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getVsanInternalSystem());
	}

	/**
	 * @since SDK5.5
	 */
	public HostVsanSystem getHostVsanSystem() throws InvalidProperty, RuntimeFault, RemoteException {
		return (HostVsanSystem)MorUtil.createExactManagedObject(getServerConnection(),
			getConfigManager().getVsanSystem());
	}
}
