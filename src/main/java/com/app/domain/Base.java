package com.app.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Base {
	@Id
	@GeneratedValue
	private Long id;

	private Date createDate;
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Base [id=" + id + ", createDate=" + createDate + ", updatedDate=" + updatedDate + "]";
	}
}
