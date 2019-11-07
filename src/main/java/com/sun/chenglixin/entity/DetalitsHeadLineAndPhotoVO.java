package com.sun.chenglixin.entity;

import java.util.List;

import com.sun.chenglixin.controller.BaseController;

public class DetalitsHeadLineAndPhotoVO extends BaseController {
	List<Photo>  list;
	DetailsHeadline deta;
	public List<Photo> getList() {
		return list;
	}
	public void setList(List<Photo> list) {
		this.list = list;
	}
	public DetailsHeadline getDeta() {
		return deta;
	}
	public void setDeta(DetailsHeadline deta) {
		this.deta = deta;
	}
	@Override
	public String toString() {
		return "DetalitsHeadLineAndPhotoVO [list=" + list + ", deta=" + deta + "]";
	}
	
}
