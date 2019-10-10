package com.sun.chenglixin.util;

public class Msg {
	 private int code;
	    private String msg;
	    private Object body;
	 
	    public Msg() {
	        this.code = 101;
	        this.msg = "系统未知错误！";
	    }
	 
	    public Msg(int code, String msg) {
	        this.code = code;
	        this.msg = msg;
	    }
	 
	    public Msg(int code, String msg, Object body) {
	        this.code = code;
	        this.msg = msg;
	        this.body = body;
	    }
	 
	    public int getCode() {
	        return code;
	    }
	 
	    public void setCode(int code) {
	        this.code = code;
	    }
	 
	    public String getMsg() {
	        return msg;
	    }
	 
	    public void setMsg(String msg) {
	        this.msg = msg;
	    }
	 
	    public Object getBody() {
	        return body;
	    }
	 
	    public void setBody(Object body) {
	        this.body = body;
	    }
	 
	    @Override
	    public String toString() {
	        return "Msg{" +
	                "code=" + code +
	                ", msg='" + msg + '\'' +
	                ", body=" + body +
	                '}';
	    }

}
