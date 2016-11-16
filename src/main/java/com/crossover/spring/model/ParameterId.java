package com.crossover.spring.model;
// Generated 15/11/2016 06:08:45 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ParameterId generated by hbm2java
 */
@Embeddable
public class ParameterId implements java.io.Serializable {

	@Column(name = "parameter_name", nullable = false, length = 50)
	private String parameterName;
	
	@Column(name = "parameter_id", nullable = false, length = 45)
	private String parameterId;

	public ParameterId() {
	}

	public ParameterId(String parameterName, String parameterId) {
		this.parameterName = parameterName;
		this.parameterId = parameterId;
	}

	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterId() {
		return this.parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ParameterId))
			return false;
		ParameterId castOther = (ParameterId) other;

		return ((this.getParameterName() == castOther.getParameterName())
				|| (this.getParameterName() != null && castOther.getParameterName() != null
						&& this.getParameterName().equals(castOther.getParameterName())))
				&& ((this.getParameterId() == castOther.getParameterId())
						|| (this.getParameterId() != null && castOther.getParameterId() != null
								&& this.getParameterId().equals(castOther.getParameterId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getParameterName() == null ? 0 : this.getParameterName().hashCode());
		result = 37 * result + (getParameterId() == null ? 0 : this.getParameterId().hashCode());
		return result;
	}

}