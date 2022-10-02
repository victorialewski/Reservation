package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Blocked;
import com.example.demo.repository.BlockedRepository;

@Service
public class BlockedServiceImpl {
	
	@Autowired
	private BlockedRepository blockedRepo;
	
	public List<Blocked> findAllBlockedDates(Blocked blocked){
		return blockedRepo.findAllBlockedDates(blocked);
	} 	
	

}
