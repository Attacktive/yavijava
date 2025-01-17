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

package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.CannotCreateFile;
import com.vmware.vim25.FileAlreadyExists;
import com.vmware.vim25.FileFault;
import com.vmware.vim25.FileNotFound;
import com.vmware.vim25.InvalidDatastore;
import com.vmware.vim25.InvalidDatastorePath;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 * @since SDK5.5
 */

public class DatastoreNamespaceManager extends ManagedObject {
	public DatastoreNamespaceManager(ServerConnection serverConnection, ManagedObjectReference mor) {
		super(serverConnection, mor);
	}

	public String createDirectory(Datastore datastore, String displayName, String policy) throws CannotCreateFile, FileAlreadyExists, InvalidDatastore, RuntimeFault, RemoteException {
		return getVimService().createDirectory(this.getMOR(), datastore.getMOR(), displayName, policy);
	}

	public void deleteDirectory(Datacenter datacenter, String datastorePath) throws FileNotFound, InvalidDatastorePath, FileFault, InvalidDatastore, RuntimeFault, RemoteException {
		getVimService().deleteDirectory(this.getMOR(), datacenter == null? null: datacenter.getMOR(), datastorePath);
	}
}
