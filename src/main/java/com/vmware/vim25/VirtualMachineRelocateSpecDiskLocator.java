/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

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

package com.vmware.vim25;

/**
 * @author Steve Jin (http://www.doublecloud.org)
 * @version 5.1
 */

@SuppressWarnings("all")
public class VirtualMachineRelocateSpecDiskLocator extends DynamicData {
	public int diskId;
	public ManagedObjectReference datastore;
	public String diskMoveType;
	public VirtualDeviceBackingInfo diskBackingInfo;
	public VirtualMachineProfileSpec[] profile;

	public int getDiskId() {
		return this.diskId;
	}

	public ManagedObjectReference getDatastore() {
		return this.datastore;
	}

	public String getDiskMoveType() {
		return this.diskMoveType;
	}

	public VirtualDeviceBackingInfo getDiskBackingInfo() {
		return this.diskBackingInfo;
	}

	public VirtualMachineProfileSpec[] getProfile() {
		return this.profile;
	}

	public void setDiskId(int diskId) {
		this.diskId = diskId;
	}

	public void setDatastore(ManagedObjectReference datastore) {
		this.datastore = datastore;
	}

	public void setDiskMoveType(String diskMoveType) {
		this.diskMoveType = diskMoveType;
	}

	public void setDiskBackingInfo(VirtualDeviceBackingInfo diskBackingInfo) {
		this.diskBackingInfo = diskBackingInfo;
	}

	public void setProfile(VirtualMachineProfileSpec[] profile) {
		this.profile = profile;
	}
}
