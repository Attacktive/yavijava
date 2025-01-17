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

import com.vmware.vim25.IpPool;
import com.vmware.vim25.IpPoolManagerIpAllocation;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 * @since 4.0
 */
public class IpPoolManager extends ManagedObject {
	public IpPoolManager(ServerConnection sc, ManagedObjectReference mor) {
		super(sc, mor);
	}

	public int createIpPool(Datacenter dc, IpPool pool) throws RuntimeFault, RemoteException {
		return getVimService().createIpPool(getMOR(), dc.getMOR(), pool);
	}

	public void destroyIpPool(Datacenter dc, int id, boolean force) throws RuntimeFault, RemoteException {
		getVimService().destroyIpPool(getMOR(), dc.getMOR(), id, force);
	}

	public IpPool[] queryIpPools(Datacenter dc) throws RuntimeFault, RemoteException {
		return getVimService().queryIpPools(getMOR(), dc.getMOR());
	}

	public void updateIpPool(Datacenter dc, IpPool pool) throws RuntimeFault, RemoteException {
		getVimService().updateIpPool(getMOR(), dc.getMOR(), pool);
	}

	/**
	 * @since SDK5.1
	 */
	public String allocateIpv4Address(Datacenter dc, int poolId, String allocationId) throws RuntimeFault, RemoteException {
		return getVimService().allocateIpv4Address(getMOR(), dc.getMOR(), poolId, allocationId);
	}

	/**
	 * @since SDK5.1
	 */
	public String allocateIpv6Address(Datacenter dc, int poolId, String allocationId) throws RuntimeFault, RemoteException {
		return getVimService().allocateIpv6Address(getMOR(), dc.getMOR(), poolId, allocationId);
	}

	/**
	 * @since SDK5.1
	 */
	public IpPoolManagerIpAllocation[] queryIPAllocations(Datacenter dc, int poolId, String extensionKey) throws RuntimeFault, RemoteException {
		return getVimService().queryIPAllocations(getMOR(), dc.getMOR(), poolId, extensionKey);
	}

	/**
	 * @since SDK5.1
	 */
	public void releaseIpAllocation(Datacenter dc, int poolId, String allocationId) throws RuntimeFault, RemoteException {
		getVimService().releaseIpAllocation(getMOR(), dc.getMOR(), poolId, allocationId);
	}
}
