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
public class AutoStartDefaults extends DynamicData {
	public Boolean enabled;
	public Integer startDelay;
	public Integer stopDelay;
	public Boolean waitForHeartbeat;
	public String stopAction;

	public Boolean getEnabled() {
		return this.enabled;
	}

	public Integer getStartDelay() {
		return this.startDelay;
	}

	public Integer getStopDelay() {
		return this.stopDelay;
	}

	public Boolean getWaitForHeartbeat() {
		return this.waitForHeartbeat;
	}

	public String getStopAction() {
		return this.stopAction;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setStartDelay(Integer startDelay) {
		this.startDelay = startDelay;
	}

	public void setStopDelay(Integer stopDelay) {
		this.stopDelay = stopDelay;
	}

	public void setWaitForHeartbeat(Boolean waitForHeartbeat) {
		this.waitForHeartbeat = waitForHeartbeat;
	}

	public void setStopAction(String stopAction) {
		this.stopAction = stopAction;
	}
}
