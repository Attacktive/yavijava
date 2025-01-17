package com.vmware.vim25;

/**
 * Copyright 2015 Michael Rice &lt;michael@michaelrice.org&gt;
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class GatewayToHostTrustVerifyFault extends GatewayToHostConnectFault {

	public KeyValue[] propertiesToVerify;
	public String verificationToken;

	public KeyValue[] getPropertiesToVerify() {
		return propertiesToVerify;
	}

	public void setPropertiesToVerify(KeyValue[] propertiesToVerify) {
		this.propertiesToVerify = propertiesToVerify;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}
}
