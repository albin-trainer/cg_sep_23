package com.cg.dto;
//dto=> data transfer object
public class ApiError {
private String msg;
private int status;
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

}
