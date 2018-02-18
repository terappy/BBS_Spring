package com.example.bbs_test;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Comment, Long>{
	
	List<Comment> findByOrderByIdDesc(Pageable pageable);
	
}