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
public class LicenseManagerLicenseInfo extends DynamicData {
	public String licenseKey;
	public String editionKey;
	public String name;
	public int total;
	public Integer used;
	public String costUnit;
	public KeyAnyValue[] properties;
	public KeyValue[] labels;

	public String getLicenseKey() {
		return this.licenseKey;
	}

	public String getEditionKey() {
		return this.editionKey;
	}

	public String getName() {
		return this.name;
	}

	public int getTotal() {
		return this.total;
	}

	public Integer getUsed() {
		return this.used;
	}

	public String getCostUnit() {
		return this.costUnit;
	}

	public KeyAnyValue[] getProperties() {
		return this.properties;
	}

	public KeyValue[] getLabels() {
		return this.labels;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public void setEditionKey(String editionKey) {
		this.editionKey = editionKey;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public void setCostUnit(String costUnit) {
		this.costUnit = costUnit;
	}

	public void setProperties(KeyAnyValue[] properties) {
		this.properties = properties;
	}

	public void setLabels(KeyValue[] labels) {
		this.labels = labels;
	}
}
