//package com.tech.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.tech.Dao.Resultdao;
//import com.tech.dto.Addres;
//
//
//
//
//@Service
//public class Addrservice {
//	
//	@Autowired
//	Resultdao addrdao;
//	
//	
//	public Addrservice() {
//		System.out.println("inside Addrservice constructor");
//	}
//	
//
//	public List<Addres> Create( List<Addres> add) {
//		
//		return addrdao.saveAll(add) ;
//		
//	}
// 
//	public List<Addres> getall(){
//	return	addrdao.findAll();
//		
//	}
//	
//	public void delete(int s) {
//		addrdao.deleteById(s);
//		
//	}
//	
//}



