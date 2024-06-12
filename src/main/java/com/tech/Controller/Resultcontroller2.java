package com.tech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.ExceptionH.Addrnotfound;
import com.tech.dto.Addres;
import com.tech.dto.Student;


@RestController
public class Resultcontroller2 {
	
	public Resultcontroller2() {
		System.out.println(" inside Resultcontroller2 constructor");
	}

	@Value("${base_url1}")
	String url1;
	
	@Value("${base_url2}")
	String url2;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/hii")
	public String add() {
		return "hi helllllo Result hii";
		
	}
	
//	@GetMapping("/hi1")
//	public String getdata1() {
//		String url=url1+"/hi1";
//		System.out.println(url);
//		ResponseEntity<String> res=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//		return res.getBody();
//	}
//
//	@GetMapping("/hi2")
//	public String getdata2() {
//		String url=url2+"/hi2";
//		System.out.println(url);
//		ResponseEntity<String> res=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//		return res.getBody();
//	}
//	
//	@GetMapping("/getall1")
//	public List getmic1() {
//		String url= url1+"/getall";
//		System.out.println(url);
//		ResponseEntity<List> res =restTemplate.exchange(url, HttpMethod.GET, null, List.class);
//		return res.getBody();	
//	}
//	
//	@GetMapping("/getall2")
//	public String getmic2() {
//		String url= url2+"/getalladdr";
//		System.out.println(url);
//		ResponseEntity<String> res =restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//		return res.getBody();
//		
//	}
//	
//	@PostMapping("/create1")
//	public List<Student> poststd(@RequestBody Student student) {
//		String url= url1+"/createstd";
//		HttpEntity<Student> input= new HttpEntity<Student>(student);
//		System.out.println(url);
//		ResponseEntity<List<Student>> res =restTemplate.exchange(url, HttpMethod.POST, input, new ParameterizedTypeReference <List <Student>>() {
//		});
//		return res.getBody();
//	}
////
////	@PostMapping("/create2")
////	public Student postadd() {
////		String url5=url2+"/createaddr";
////		System.out.println(url5);
////		ResponseEntity<Student> res =restTemplate.exchange(url5, HttpMethod.POST, null, Student.class);
////		return res.getBody();
////	}
//	
//	@GetMapping("/getbyid1/{id}")
//	public Student findbyid(@PathVariable("id")int id) {
//		String url=url1+"/findbyid/"+id;
//		System.out.println(url);
//		ResponseEntity<Student> res=restTemplate.exchange(url, HttpMethod.GET, null, Student.class);
//		return res.getBody();
//	}
//	
//	@GetMapping("/getname/{name}")
//	public String findbyname(@PathVariable("name") String name) {
//		String url=url1+"/findbyname/"+name;
//		System.out.println(url);
//		ResponseEntity<String> res=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//		return res.getBody();
//		
//	}
//
//	@PostMapping("/createone")
//	public Student postadd(@RequestBody Student student) {
//		String url=url1+"/createone";
//		System.out.println(url);
//		HttpEntity<Student> ip= new HttpEntity<Student>(student);
//		ResponseEntity<Student> res =restTemplate.exchange(url, HttpMethod.POST, ip, Student.class);
//		return res.getBody();
//	}
//	
//	@DeleteMapping("/deleter/{id}")
//	public int delete(@PathVariable("id") int id) {
//		String url= url1+"/delete/"+id ;
//		System.out.println(url);
//		ResponseEntity<Void> res=restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
//		return res.getStatusCodeValue();
//	}
//	
	@GetMapping("/validate")
	public List<Addres> getaddrss()  {
		String url= url2+"/getalladdr";
		System.out.println(url);
		
		ResponseEntity<List<Addres>> res = null;
		
		try {
		 res =restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Addres>>() {
		});
		
		}catch (Exception e) {
		 System.out.println("i am in catch block "+e.getMessage());
		
		 throw new Addrnotfound("AddrnotfoundException in 9093");	 
		}
		return res.getBody();

	}
	
	@GetMapping("/getstdname/{name}")
	public String getstdname(@PathVariable ("name") String name) {
		String url= url1+"/findbyname/"+ name;
		System.out.println(url);
		ResponseEntity<String> res1=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return res1.getBody();
	}
	
	@GetMapping("/getid/{id}")                
	public String getid(@PathVariable ("id") int id) {
		String url = url1+"/findbyid/"+id;
		System.out.println(url);
		Student student;
		try {
		ResponseEntity<Student> s1=restTemplate.exchange(url, HttpMethod.GET, null, Student.class);
		student= s1.getBody();
		}catch (Exception e) {
			student = new Student();
		}
		String url3=url1+"/getname93";
		if(student.getId()==0) {
			HttpEntity<String> result=new HttpEntity<String>("");
			ResponseEntity<String> s=restTemplate.exchange(url3, HttpMethod.POST, result, String.class);
			return s.getBody();
					
		}else {
			HttpEntity<String> result= new HttpEntity<>("side is up");
			ResponseEntity<String>s2=restTemplate.exchange(url3, HttpMethod.POST, result, String.class);
			return s2.getBody();
		}
		
		
	}
}