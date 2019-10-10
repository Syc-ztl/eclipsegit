package com.sun.chenglixin.util;



public class JsonResult <T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  state;
	private  String message;
	private  T  date;
	
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getDate() {
		return date;
	}
	public void setDate(T date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", date=" + date + "]";
	}
	
	
}
