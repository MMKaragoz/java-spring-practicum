package com.mert.orderapp.client.dto.response;

import java.util.Date;
import java.util.Objects;

public class BaseEntityDto {

	private Date createdAt;
	
	private Date updatedAt;
	
	public BaseEntityDto() {
		
	}

	public BaseEntityDto(Date createdAt, Date updatedAt) {
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, updatedAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntityDto other = (BaseEntityDto) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(updatedAt, other.updatedAt);
	}

	@Override
	public String toString() {
		return "BaseEntityDto [createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
