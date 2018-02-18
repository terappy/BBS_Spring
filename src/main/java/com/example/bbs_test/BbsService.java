package com.example.bbs_test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BbsService {
	@Autowired
	private BbsRepository repository;
	
	public List<Comment> getRecentComment(Integer n){
		return repository.findByOrderByIdDesc(new PageRequest(0, n));
	}
	
	@Transactional
	public void save(Comment comment) {
		repository.save(comment);
	}
}
