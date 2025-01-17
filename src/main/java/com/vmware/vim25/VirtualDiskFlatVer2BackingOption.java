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
public class VirtualDiskFlatVer2BackingOption extends VirtualDeviceFileBackingOption {
	public ChoiceOption diskMode;
	public BoolOption split;
	public BoolOption writeThrough;
	public boolean growable;
	public boolean hotGrowable;
	public boolean uuid;
	public BoolOption thinProvisioned;
	public BoolOption eagerlyScrub;
	public ChoiceOption deltaDiskFormat;
	public VirtualDiskDeltaDiskFormatsSupported[] deltaDiskFormatsSupported;

	public ChoiceOption getDiskMode() {
		return this.diskMode;
	}

	public BoolOption getSplit() {
		return this.split;
	}

	public BoolOption getWriteThrough() {
		return this.writeThrough;
	}

	public boolean isGrowable() {
		return this.growable;
	}

	public boolean isHotGrowable() {
		return this.hotGrowable;
	}

	public boolean isUuid() {
		return this.uuid;
	}

	public BoolOption getThinProvisioned() {
		return this.thinProvisioned;
	}

	public BoolOption getEagerlyScrub() {
		return this.eagerlyScrub;
	}

	public ChoiceOption getDeltaDiskFormat() {
		return this.deltaDiskFormat;
	}

	public VirtualDiskDeltaDiskFormatsSupported[] getDeltaDiskFormatsSupported() {
		return this.deltaDiskFormatsSupported;
	}

	public void setDiskMode(ChoiceOption diskMode) {
		this.diskMode = diskMode;
	}

	public void setSplit(BoolOption split) {
		this.split = split;
	}

	public void setWriteThrough(BoolOption writeThrough) {
		this.writeThrough = writeThrough;
	}

	public void setGrowable(boolean growable) {
		this.growable = growable;
	}

	public void setHotGrowable(boolean hotGrowable) {
		this.hotGrowable = hotGrowable;
	}

	public void setUuid(boolean uuid) {
		this.uuid = uuid;
	}

	public void setThinProvisioned(BoolOption thinProvisioned) {
		this.thinProvisioned = thinProvisioned;
	}

	public void setEagerlyScrub(BoolOption eagerlyScrub) {
		this.eagerlyScrub = eagerlyScrub;
	}

	public void setDeltaDiskFormat(ChoiceOption deltaDiskFormat) {
		this.deltaDiskFormat = deltaDiskFormat;
	}

	public void setDeltaDiskFormatsSupported(VirtualDiskDeltaDiskFormatsSupported[] deltaDiskFormatsSupported) {
		this.deltaDiskFormatsSupported = deltaDiskFormatsSupported;
	}
}
