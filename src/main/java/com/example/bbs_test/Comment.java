package com.example.bbs_test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String comment;
	
	
	private String idPath;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;
	
	private String remoteAddr;
	
	public Comment() {}
	
	public Comment(String name, String comment, String remoteAddr) {
		this.name = name;
		this.comment = comment;
		this.remoteAddr = remoteAddr;
	}
	
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}
	
	@Override
	public String toString() {
		return String.format("Comment[id=%d, name='%s', comment='%s']", id, name, comment);	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIdPath() {
		return idPath;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	
	
	
	
}
