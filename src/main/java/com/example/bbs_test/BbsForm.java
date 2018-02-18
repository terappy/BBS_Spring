package com.example.bbs_test;

import javax.validation.constraints.Size;

public class BbsForm {
	@Size(max=20)
	private String name;
	
	@Size(min=1, max=140)
	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
