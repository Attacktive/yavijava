package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.GuestAliases;
import com.vmware.vim25.GuestAuthAliasInfo;
import com.vmware.vim25.GuestAuthSubject;
import com.vmware.vim25.GuestAuthentication;
import com.vmware.vim25.GuestComponentsOutOfDate;
import com.vmware.vim25.GuestMappedAliases;
import com.vmware.vim25.GuestMultipleMappings;
import com.vmware.vim25.GuestOperationsFault;
import com.vmware.vim25.GuestOperationsUnavailable;
import com.vmware.vim25.GuestPermissionDenied;
import com.vmware.vim25.InvalidArgument;
import com.vmware.vim25.InvalidGuestLogin;
import com.vmware.vim25.InvalidPowerState;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.OperationDisabledByGuest;
import com.vmware.vim25.OperationNotSupportedByGuest;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;

/**
 * Copyright 2015 Michael Rice &lt;michael@michaelrice.org&gt;
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class GuestAliasManager extends ManagedObject {

	/**
	 * Constructor
	 *
	 * @param sc {@link ServerConnection ServerConnection}
	 * @param mor {@link com.vmware.vim25.ManagedObjectReference ManagedObjectReference} to a GuestAliasManager
	 */
	public GuestAliasManager(ServerConnection sc, ManagedObjectReference mor) {
		super(sc, mor);
	}

	/**
	 * Defines an alias for a guest account in a virtual machine.
	 * After the alias is defined, the ESXi Server will use the alias to authenticate guest operations requests.
	 * <p>
	 * This will add the given VMWare SSO Server's certificate and a subject to the alias store of the specified
	 * user in the guest. In order to add an alias to the guest, you must supply an existing valid credential.
	 * This can be any instance of GuestAuthentication, but must be valid for the specified guest username.
	 *
	 * @param virtualMachine Virtual machine to perform the operation on.
	 * @param guestAuthentication The guest authentication data for this operation. See {@link com.vmware.vim25.GuestAuthentication GuestAuthentication}. These credentials must satisfy authentication requirements for a guest account on the specified virtual machine.
	 * @param userName Username for the guest account on the virtual machine.
	 * @param mapCert Indicates whether the certificate associated with the alias should be mapped. If an alias certificate is mapped, guest operation requests that use that alias do not have to specify the guest account username in the {@link com.vmware.vim25.SAMLTokenAuthentication} object. If mapCert is false, the request must specify the username.
	 * @param base64Cert X.509 certificate from the VMware SSO Server, in base64 encoded DER format. The ESXi Server uses this certificate to authenticate guest operation requests.
	 * @param guestAuthAliasInfo Specifies the subject name for authentication. The subject name (when present) corresponds to the value of the Subject element in SAML tokens. The ESXi Server uses the subject name to authenticate guest operation requests.
	 * @throws com.vmware.vim25.GuestComponentsOutOfDate Thrown if the guest agent is too old to support the operation.
	 * @throws com.vmware.vim25.GuestMultipleMappings Thrown if the operation fails because mapCert is set and the certificate already exists in the mapping file for a different user.
	 * @throws com.vmware.vim25.GuestOperationsFault Thrown if there is an error processing a guest operation.
	 * @throws com.vmware.vim25.GuestOperationsUnavailable Thrown if the VM agent for guest operations is not running.
	 * @throws com.vmware.vim25.GuestPermissionDenied Thrown if there are insufficient permissions in the guest OS.
	 * @throws com.vmware.vim25.InvalidArgument Thrown if the operation fails because the certificate is invalid.
	 * @throws com.vmware.vim25.InvalidGuestLogin Thrown if the the guest authentication information was not accepted.
	 * @throws com.vmware.vim25.InvalidPowerState Thrown if the VM is not powered on.
	 * @throws com.vmware.vim25.InvalidState Thrown if the operation cannot be performed because of the virtual machine's current state.
	 * @throws com.vmware.vim25.OperationDisabledByGuest Thrown if the operation is not enabled due to guest agent configuration.
	 * @throws com.vmware.vim25.OperationNotSupportedByGuest Thrown if the operation is not supported by the guest OS.
	 * @throws com.vmware.vim25.RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
	 * @throws com.vmware.vim25.TaskInProgress Thrown if the virtual machine is busy.
	 * @throws java.rmi.RemoteException
	 */
	public void addGuestAlias(VirtualMachine virtualMachine, GuestAuthentication guestAuthentication,
		String userName, boolean mapCert, String base64Cert, GuestAuthAliasInfo guestAuthAliasInfo)
		throws GuestComponentsOutOfDate, GuestMultipleMappings, GuestOperationsFault, GuestOperationsUnavailable,
		GuestPermissionDenied, InvalidArgument, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest,
		OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
		getVimService().addGuestAlias(getMOR(), virtualMachine.getMOR(), guestAuthentication, userName, mapCert, base64Cert, guestAuthAliasInfo);
	}

	/**
	 * Lists the {@link com.vmware.vim25.GuestAliases GuestAliases} for a specified user in the guest that can be used for authentication of guest operations.
	 *
	 * @param vm Virtual machine to perform the operation on.
	 * @param auth The guest authentication data for this operation. See {@link com.vmware.vim25.GuestAuthentication GuestAuthentication}. These credentials must satisfy authentication requirements for a guest account on the specified virtual machine.
	 * @param userName The guest user whose Alias store is being queried.
	 * @return GuestAliases[]
	 * @throws com.vmware.vim25.GuestComponentsOutOfDate Thrown if the guest agent is too old to support the operation.
	 * @throws com.vmware.vim25.GuestOperationsFault Thrown if there is an error processing a guest operation.
	 * @throws com.vmware.vim25.GuestOperationsUnavailable Thrown if the agent for guest operations is not running.
	 * @throws com.vmware.vim25.GuestPermissionDenied Thrown if there are insufficient permissions in the guest OS.
	 * @throws com.vmware.vim25.InvalidGuestLogin Thrown if the the guest authentication information was not accepted.
	 * @throws com.vmware.vim25.InvalidPowerState Thrown if the VM is not powered on.
	 * @throws com.vmware.vim25.InvalidState Thrown if the operation cannot be performed because of the virtual machine's current state.
	 * @throws com.vmware.vim25.OperationDisabledByGuest Thrown if the operation is not enabled due to guest agent configuration.
	 * @throws com.vmware.vim25.OperationNotSupportedByGuest Thrown if the operation is not supported by the guest OS.
	 * @throws com.vmware.vim25.RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
	 * @throws com.vmware.vim25.TaskInProgress Thrown if the virtual machine is busy.
	 * @throws java.rmi.RemoteException
	 */
	public GuestAliases[] listGuestAliases(VirtualMachine vm, GuestAuthentication auth, String userName) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied,
		InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
		return getVimService().listGuestAliases(getMOR(), vm.getMOR(), auth, userName);
	}

	/**
	 * Lists the GuestMappedAliases in the guest that can be used for authentication of guest operations.
	 *
	 * @param vm {@link VirtualMachine VirtualMachine} to perform the operation on.
	 * @param auth {@link com.vmware.vim25.GuestAuthentication GuestAuthentication} The guest authentication data for this operation. These credentials must satisfy authentication requirements for a guest account on the specified virtual machine.
	 * @return GuestMappedAliases[]
	 * @throws com.vmware.vim25.GuestComponentsOutOfDate Thrown if the guest agent is too old to support the operation.
	 * @throws com.vmware.vim25.GuestOperationsFault Thrown if there is an error processing a guest operation.
	 * @throws com.vmware.vim25.GuestOperationsUnavailable Thrown if the VM agent for guest operations is not running.
	 * @throws com.vmware.vim25.GuestPermissionDenied Thrown if there are insufficient permissions in the guest OS.
	 * @throws com.vmware.vim25.InvalidGuestLogin Thrown if the the guest authentication information was not accepted.
	 * @throws com.vmware.vim25.InvalidPowerState Thrown if the VM is not powered on.
	 * @throws com.vmware.vim25.InvalidState Thrown if the operation cannot be performed because of the virtual machine's current state.
	 * @throws com.vmware.vim25.OperationDisabledByGuest Thrown if the operation is not enabled due to guest agent configuration.
	 * @throws com.vmware.vim25.OperationNotSupportedByGuest Thrown if the operation is not supported by the guest OS.
	 * @throws com.vmware.vim25.RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
	 * @throws com.vmware.vim25.TaskInProgress Thrown if the virtual machine is busy.
	 * @throws java.rmi.RemoteException
	 */
	public GuestMappedAliases[] listGuestMappedAliases(VirtualMachine vm, GuestAuthentication auth) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable,
		GuestPermissionDenied, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault,
		TaskInProgress, RemoteException {
		return getVimService().listGuestMappedAliases(getMOR(), vm.getMOR(), auth);
	}

	/**
	 * Removes an alias from the guest so it can no longer be used for authentication of guest operations.
	 * It will also be removed from the mapped credentials.
	 *
	 * @param vm Virtual machine to perform the operation on.
	 * @param auth The guest authentication data for this operation. See {@link com.vmware.vim25.GuestAuthentication GuestAuthentication}. These credentials must satisfy authentication requirements for a guest account on the specified virtual machine.
	 * @param userName Username for the guest account on the virtual machine.
	 * @param base64Cert The X.509 certificate associated with the alias to be removed, in base64 encoded DER format.
	 * @param subject The subject of the alias.
	 * @throws com.vmware.vim25.GuestComponentsOutOfDate
	 * @throws com.vmware.vim25.GuestOperationsFault
	 * @throws com.vmware.vim25.GuestOperationsUnavailable
	 * @throws com.vmware.vim25.GuestPermissionDenied
	 * @throws com.vmware.vim25.InvalidArgument
	 * @throws com.vmware.vim25.InvalidGuestLogin
	 * @throws com.vmware.vim25.InvalidPowerState
	 * @throws com.vmware.vim25.InvalidState
	 * @throws com.vmware.vim25.OperationDisabledByGuest
	 * @throws com.vmware.vim25.OperationNotSupportedByGuest
	 * @throws com.vmware.vim25.RuntimeFault
	 * @throws com.vmware.vim25.TaskInProgress
	 * @throws java.rmi.RemoteException
	 */
	public void removeGuestAlias(VirtualMachine vm, GuestAuthentication auth, String userName, String base64Cert, GuestAuthSubject subject) throws GuestComponentsOutOfDate, GuestOperationsFault,
		GuestOperationsUnavailable, GuestPermissionDenied, InvalidArgument, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest,
		RuntimeFault, TaskInProgress, RemoteException {
		getVimService().removeGuestAlias(getMOR(), vm.getMOR(), auth, userName, base64Cert, subject);
	}

	/**
	 * Removes a VMware SSO Server's certificate and all associated aliases from the guest so it can no longer be used for authentication of guest operations.
	 * It will also be removed from the global certificate-to-user mapping file in the guest.
	 *
	 * @param vm Virtual machine to perform the operation on.
	 * @param auth The guest authentication data for this operation. See {@link com.vmware.vim25.GuestAuthentication GuestAuthentication}. These credentials must satisfy authentication requirements for a guest account on the specified virtual machine.
	 * @param userName Username for the guest account on the virtual machine.
	 * @param base64Cert The X.509 certificate associated with the alias to be removed, in base64 encoded DER format.
	 * @throws com.vmware.vim25.GuestComponentsOutOfDate
	 * @throws com.vmware.vim25.GuestOperationsFault
	 * @throws com.vmware.vim25.GuestOperationsUnavailable
	 * @throws com.vmware.vim25.GuestPermissionDenied
	 * @throws com.vmware.vim25.InvalidArgument
	 * @throws com.vmware.vim25.InvalidGuestLogin
	 * @throws com.vmware.vim25.InvalidPowerState
	 * @throws com.vmware.vim25.InvalidState
	 * @throws com.vmware.vim25.OperationDisabledByGuest
	 * @throws com.vmware.vim25.OperationNotSupportedByGuest
	 * @throws com.vmware.vim25.RuntimeFault
	 * @throws com.vmware.vim25.TaskInProgress
	 * @throws java.rmi.RemoteException
	 */
	public void removeGuestAliasByCert(VirtualMachine vm, GuestAuthentication auth, String userName, String base64Cert) throws GuestComponentsOutOfDate, GuestOperationsFault,
		GuestOperationsUnavailable, GuestPermissionDenied, InvalidArgument, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest,
		RuntimeFault, TaskInProgress, RemoteException {
		getVimService().removeGuestAliasByCert(getMOR(), vm.getMOR(), auth, userName, base64Cert);
	}
}
