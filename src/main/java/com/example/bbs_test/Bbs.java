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


// @Table(name = "users") // �N���X���ƈႤ�e�[�u����錾������������A�m�e�[�V����
@Entity
public class Bbs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String text;
	
	
	private Long replyId;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;
	
	// JPA requirement
	public Bbs() {}
	
	public Bbs(String name, String text, Long replyId) {
		this.name = name;
		this.text = text;
		this.replyId = replyId;
	}
	
	/*
	 * Insert���̎��s�O�ɌĂяo�����
	 * @PrePersist�̃A�m�e�[�V���������\�b�h�ɂ��邱�ƂŎw��\
	 */
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}
	
	// getter,setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	
	
}
