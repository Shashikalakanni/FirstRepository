package com.jsp.tmr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
	
	private static final long serialVersionUID=1L;
	
	private String resourcename; 
	private String fieldName; 
	private Object fieldVelue;
	
	public ResourceNotFoundException(String resourcename, String fieldName, Object fieldVelue) {
		super(resourcename+fieldName+fieldVelue);
		this.resourcename = resourcename;
		this.fieldName = fieldName;
		this.fieldVelue = fieldVelue;
	}
	
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldVelue() {
		return fieldVelue;
	}
	public void setFieldVelue(Object fieldVelue) {
		this.fieldVelue = fieldVelue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
