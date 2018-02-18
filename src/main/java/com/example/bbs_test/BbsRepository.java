package com.example.bbs_test;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends CrudRepository<Bbs, Long>{
	
	List<Bbs> findByOrderByIdDesc(Pageable pageable);
	
}