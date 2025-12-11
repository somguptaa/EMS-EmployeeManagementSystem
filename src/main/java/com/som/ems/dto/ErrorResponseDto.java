package com.som.ems.dto;

import java.util.List;

import lombok.Data;


@Data
public class ErrorResponseDto {

	
	private Integer statuscode;
	private String status;
	private String message;
	private List<?> list;
	
	public ErrorResponseDto(Integer statuscode, String status, String message, List<?> list) {
		super();
		this.statuscode = statuscode;
		this.status = status;
		this.message = message;
		this.list = list;
	}
}
