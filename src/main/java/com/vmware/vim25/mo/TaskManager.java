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

import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskDescription;
import com.vmware.vim25.TaskFilterSpec;
import com.vmware.vim25.TaskInfo;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class TaskManager extends ManagedObject {

	public TaskManager(ServerConnection serverConnection, ManagedObjectReference mor) {
		super(serverConnection, mor);
	}

	/**
	 * @deprecated the misspelled word. Use getDescription() instead
	 */
	public TaskDescription getDescriptioin() {
		return getDescription();
	}

	public TaskDescription getDescription() {
		return (TaskDescription)getCurrentProperty("description");
	}

	public int getMaxCollector() {
		return ((Integer)getCurrentProperty("maxCollector")).intValue();
	}

	public Task[] getRecentTasks() {
		return getTasks("recentTask");
	}

	public TaskHistoryCollector createCollectorForTasks(TaskFilterSpec filter) throws InvalidState, RuntimeFault, RemoteException {
		return new TaskHistoryCollector(getServerConnection(),
			getVimService().createCollectorForTasks(getMOR(), filter));
	}

	//SDK2.5 signature for back compatibility
	public TaskInfo createTask(ManagedObject obj, String taskTypeId, String initiatedBy, boolean cancelable) throws RuntimeFault, RemoteException {
		return createTask(obj, taskTypeId, initiatedBy, cancelable, null);
	}

	//SDK4.0 signature
	public TaskInfo createTask(ManagedObject obj, String taskTypeId, String initiatedBy, boolean cancelable, String parentTaskKey) throws RuntimeFault, RemoteException {
		if (obj == null) {
			throw new IllegalArgumentException("obj must not be null.");
		}
		return createTask(obj, taskTypeId, initiatedBy, cancelable, parentTaskKey, null);
	}

	// SDK 6.0
	public TaskInfo createTask(ManagedObject obj, String taskTypeId, String initiatedBy, boolean cancelable, String parentTaskKey, String activationId) throws RuntimeFault, RemoteException {
		if (obj == null) {
			throw new IllegalArgumentException("obj must not be null.");
		}
		return getVimService().createTask(getMOR(), obj.getMOR(), taskTypeId, initiatedBy, cancelable, parentTaskKey, activationId);
	}
}
