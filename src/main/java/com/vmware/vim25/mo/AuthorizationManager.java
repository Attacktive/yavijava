/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.
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

import com.vmware.vim25.AlreadyExists;
import com.vmware.vim25.AuthMinimumAdminPermission;
import com.vmware.vim25.AuthorizationDescription;
import com.vmware.vim25.AuthorizationPrivilege;
import com.vmware.vim25.AuthorizationRole;
import com.vmware.vim25.EntityPrivilege;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.Permission;
import com.vmware.vim25.RemoveFailed;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.UserNotFound;
import com.vmware.vim25.mo.util.MorUtil;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class AuthorizationManager extends ManagedObject {

	public AuthorizationManager(ServerConnection sc, ManagedObjectReference mor) {
		super(sc, mor);
	}

	public AuthorizationDescription getDescription() {
		return (AuthorizationDescription)getCurrentProperty("description");
	}

	public AuthorizationPrivilege[] getPrivilegeList() {
		return (AuthorizationPrivilege[])getCurrentProperty("privilegeList");
	}

	public AuthorizationRole[] getRoleList() {
		return (AuthorizationRole[])getCurrentProperty("roleList");
	}

	public int addAuthorizationRole(String name, String[] privIds) throws InvalidName, AlreadyExists, RuntimeFault, RemoteException {
		return getVimService().addAuthorizationRole(getMOR(), name, privIds);
	}

	/**
	 * @deprecated as of SDK5.5, use hasPrivilegeOnEntity instead, which fixed upper-case H typo in method name in 5.5
	 */
	public boolean[] HasPrivilegeOnEntity(ManagedEntity entity, String sessionId, String[] privId) throws RuntimeFault, RemoteException {
		return getVimService().hasPrivilegeOnEntity(getMOR(), entity.getMOR(), sessionId, privId);
	}

	/**
	 * @since SDK5.0
	 */
	public boolean[] hasPrivilegeOnEntity(ManagedEntity entity, String sessionId, String[] privId) throws RuntimeFault, RemoteException {
		return getVimService().hasPrivilegeOnEntity(getMOR(), entity.getMOR(), sessionId, privId);
	}

	/**
	 * @since SDK5.5
	 */
	public EntityPrivilege[] hasPrivilegeOnEntities(ManagedEntity[] entity, String sessionId, String[] privId) throws RuntimeFault, RemoteException {
		ManagedObjectReference[] mors = MorUtil.createMORs(entity);
		return getVimService().hasPrivilegeOnEntities(getMOR(), mors, sessionId, privId);
	}

	public void mergePermissions(int srcRoleId, int dstRoleId) throws AuthMinimumAdminPermission, NotFound, RuntimeFault, RemoteException {
		getVimService().mergePermissions(getMOR(), srcRoleId, dstRoleId);
	}

	public void removeAuthorizationRole(int roleId, boolean failIfUsed) throws RemoveFailed, NotFound, RuntimeFault, RemoteException {
		getVimService().removeAuthorizationRole(getMOR(), roleId, failIfUsed);
	}

	public void removeEntityPermission(ManagedEntity entity, String user, boolean isGroup) throws AuthMinimumAdminPermission, NotFound, RuntimeFault, RemoteException {
		if (entity == null) {
			throw new IllegalArgumentException("entity must not be null.");
		}
		getVimService().removeEntityPermission(getMOR(), entity.getMOR(), user, isGroup);
	}

	public void resetEntityPermissions(ManagedEntity entity, Permission[] permission) throws AuthMinimumAdminPermission, NotFound, UserNotFound, RuntimeFault, RemoteException {
		if (entity == null) {
			throw new IllegalArgumentException("entity must not be null.");
		}
		getVimService().resetEntityPermissions(getMOR(), entity.getMOR(), permission);
	}

	public Permission[] retrieveEntityPermissions(ManagedEntity entity, boolean inherited) throws RuntimeFault, RemoteException {
		if (entity == null) {
			throw new IllegalArgumentException("entity must not be null.");
		}
		return getVimService().retrieveEntityPermissions(getMOR(), entity.getMOR(), inherited);
	}

	public Permission[] retrieveAllPermissions() throws RuntimeFault, RemoteException {
		return getVimService().retrieveAllPermissions(getMOR());
	}

	public Permission[] retrieveRolePermissions(int roleId) throws NotFound, RuntimeFault, RemoteException {
		return getVimService().retrieveRolePermissions(getMOR(), roleId);
	}

	public void setEntityPermissions(ManagedEntity entity, Permission[] permission) throws AuthMinimumAdminPermission, NotFound, UserNotFound, RuntimeFault, RemoteException {
		if (entity == null) {
			throw new IllegalArgumentException("entity must not be null.");
		}
		getVimService().setEntityPermissions(getMOR(), entity.getMOR(), permission);
	}

	public void updateAuthorizationRole(int roleId, String newName, String[] privIds) throws InvalidName, AlreadyExists, NotFound, RuntimeFault, RemoteException {
		getVimService().updateAuthorizationRole(getMOR(), roleId, newName, privIds);
	}
}
