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

import com.vmware.vim25.Event;
import com.vmware.vim25.EventArgDesc;
import com.vmware.vim25.EventDescription;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.InvalidEvent;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInfo;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class EventManager extends ManagedObject {

	public EventManager(ServerConnection serverConnection, ManagedObjectReference mor) {
		super(serverConnection, mor);
	}

	public EventDescription getDescription() {
		return (EventDescription)getCurrentProperty("description");
	}

	public Event getLatestEvent() {
		return (Event)getCurrentProperty("latestEvent");
	}

	public int getMaxCollector() {
		return ((Integer)getCurrentProperty("maxCollector")).intValue();
	}

	public EventHistoryCollector createCollectorForEvents(EventFilterSpec filter) throws InvalidState, RuntimeFault, RemoteException {
		return new EventHistoryCollector(getServerConnection(),
			getVimService().createCollectorForEvents(getMOR(), filter));
	}

	public void logUserEvent(ManagedEntity entity, String msg) throws RuntimeFault, RemoteException {
		if (entity == null) {
			throw new IllegalArgumentException("entity must not be null.");
		}
		getVimService().logUserEvent(getMOR(), entity.getMOR(), msg);
	}

	public void postEvent(Event eventToPost, TaskInfo taskInfo) throws InvalidEvent, RuntimeFault, RemoteException {
		getVimService().postEvent(getMOR(), eventToPost, taskInfo);
	}

	public Event[] queryEvents(EventFilterSpec filter) throws RuntimeFault, RemoteException {
		return getVimService().queryEvents(getMOR(), filter);
	}

	public EventArgDesc[] retrieveArgumentDescription(String eventTypeId) throws RuntimeFault, RemoteException {
		return getVimService().retrieveArgumentDescription(getMOR(), eventTypeId);
	}
}
