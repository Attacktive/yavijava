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
public class VmConfigSpec extends DynamicData {
	public VAppProductSpec[] product;
	public VAppPropertySpec[] property;
	public VAppIPAssignmentInfo ipAssignment;
	public String[] eula;
	public VAppOvfSectionSpec[] ovfSection;
	public String[] ovfEnvironmentTransport;
	public Boolean installBootRequired;
	public Integer installBootStopDelay;

	public VAppProductSpec[] getProduct() {
		return this.product;
	}

	public VAppPropertySpec[] getProperty() {
		return this.property;
	}

	public VAppIPAssignmentInfo getIpAssignment() {
		return this.ipAssignment;
	}

	public String[] getEula() {
		return this.eula;
	}

	public VAppOvfSectionSpec[] getOvfSection() {
		return this.ovfSection;
	}

	public String[] getOvfEnvironmentTransport() {
		return this.ovfEnvironmentTransport;
	}

	public Boolean getInstallBootRequired() {
		return this.installBootRequired;
	}

	public Integer getInstallBootStopDelay() {
		return this.installBootStopDelay;
	}

	public void setProduct(VAppProductSpec[] product) {
		this.product = product;
	}

	public void setProperty(VAppPropertySpec[] property) {
		this.property = property;
	}

	public void setIpAssignment(VAppIPAssignmentInfo ipAssignment) {
		this.ipAssignment = ipAssignment;
	}

	public void setEula(String[] eula) {
		this.eula = eula;
	}

	public void setOvfSection(VAppOvfSectionSpec[] ovfSection) {
		this.ovfSection = ovfSection;
	}

	public void setOvfEnvironmentTransport(String[] ovfEnvironmentTransport) {
		this.ovfEnvironmentTransport = ovfEnvironmentTransport;
	}

	public void setInstallBootRequired(Boolean installBootRequired) {
		this.installBootRequired = installBootRequired;
	}

	public void setInstallBootStopDelay(Integer installBootStopDelay) {
		this.installBootStopDelay = installBootStopDelay;
	}
}
