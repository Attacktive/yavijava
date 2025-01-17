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
public class MetricAlarmExpression extends AlarmExpression {
	public MetricAlarmOperator operator;
	public String type;
	public PerfMetricId metric;
	public Integer yellow;
	public Integer yellowInterval;
	public Integer red;
	public Integer redInterval;

	public MetricAlarmOperator getOperator() {
		return this.operator;
	}

	public String getType() {
		return this.type;
	}

	public PerfMetricId getMetric() {
		return this.metric;
	}

	public Integer getYellow() {
		return this.yellow;
	}

	public Integer getYellowInterval() {
		return this.yellowInterval;
	}

	public Integer getRed() {
		return this.red;
	}

	public Integer getRedInterval() {
		return this.redInterval;
	}

	public void setOperator(MetricAlarmOperator operator) {
		this.operator = operator;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMetric(PerfMetricId metric) {
		this.metric = metric;
	}

	public void setYellow(Integer yellow) {
		this.yellow = yellow;
	}

	public void setYellowInterval(Integer yellowInterval) {
		this.yellowInterval = yellowInterval;
	}

	public void setRed(Integer red) {
		this.red = red;
	}

	public void setRedInterval(Integer redInterval) {
		this.redInterval = redInterval;
	}
}
