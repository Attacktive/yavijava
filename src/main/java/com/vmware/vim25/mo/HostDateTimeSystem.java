/*================================================================================
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
import java.util.Calendar;

import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.HostDateTimeConfig;
import com.vmware.vim25.HostDateTimeInfo;
import com.vmware.vim25.HostDateTimeSystemTimeZone;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class HostDateTimeSystem extends ManagedObject {

	public HostDateTimeSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
		super(serverConnection, mor);
	}

	public HostDateTimeInfo getDateTimeInfo() {
		return (HostDateTimeInfo)getCurrentProperty("dateTimeInfo");
	}

	public HostDateTimeSystemTimeZone[] queryAvailableTimeZones() throws RuntimeFault, RemoteException {
		return getVimService().queryAvailableTimeZones(getMOR());
	}

	public Calendar queryDateTime() throws RuntimeFault, RemoteException {
		return getVimService().queryDateTime(getMOR());
	}

	public void refreshDateTimeSystem() throws RuntimeFault, RemoteException {
		getVimService().refreshDateTimeSystem(getMOR());
	}

	public void updateDateTime(Calendar dateTime) throws HostConfigFault, RuntimeFault, RemoteException {
		getVimService().updateDateTime(getMOR(), dateTime);
	}

	public void updateDateTimeConfig(HostDateTimeConfig config) throws HostConfigFault, RuntimeFault, RemoteException {
		getVimService().updateDateTimeConfig(getMOR(), config);
	}
}
