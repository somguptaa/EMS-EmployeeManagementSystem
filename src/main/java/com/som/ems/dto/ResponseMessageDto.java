package com.som.ems.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseMessageDto {
	

	private Integer statuscode;
	private String status;
	private String message;
	private Object  data;
	private List<?> list;
	
	public ResponseMessageDto(Integer statuscode, String message, List<?> list) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.list = list;
	}

	public ResponseMessageDto(Integer statuscode, String message, Object data) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.data = data;
	}

	public ResponseMessageDto(Integer statuscode, String message) {
		super();
		this.statuscode = statuscode;
		this.message = message;
	}

	public ResponseMessageDto(Integer statuscode, String status, String message, Object data) {
		super();
		this.statuscode = statuscode;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	
	
	

}
