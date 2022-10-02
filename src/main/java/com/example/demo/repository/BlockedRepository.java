package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Blocked;

@Repository
public interface BlockedRepository extends JpaRepository<Blocked, Integer>{
	
	@Query(value = "SELECT b FROM Blocked b")	
	List<Blocked> findAllBlockedDates(Blocked blocked);

}