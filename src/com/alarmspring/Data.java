package com.alarmspring;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Data {

	@Persistent
	private String email;
	@Persistent
	private Boolean isDeleted = false;

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Persistent
	private Set<Long> Idvalues = new HashSet<Long>();

	public Set<Long> getIdvalues() {
		return Idvalues;
	}

	public void setIdvalues(Set<Long> idvalues) {
		this.Idvalues = idvalues;
	}

	@Persistent
	private String addTime;

	public String getaddTime() {
		return addTime;
	}

	public void setaddTime(String addTime) {
		this.addTime = addTime;
	}

}
