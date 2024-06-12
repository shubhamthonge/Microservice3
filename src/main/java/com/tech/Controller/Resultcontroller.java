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

import com.tech.dto.Student;


@RestController
public class Resultcontroller {
	
	public Resultcontroller() {
		System.out.println(" inside Resultcontroller constructor");
	}

	@Value("${base_url1}")
	String url1;
	
	@Value("${base_url2}")
	String url2;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/hi")
	public String add() {
		return "hi helllllo Result";
		
	}
	
	@GetMapping("/hi1")
	public String getdata1() {
		String url=url1+"/hi1";
		System.out.println(url);
		ResponseEntity<String> res=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return res.getBody();
	}

	@GetMapping("/hi2")
	public String getdata2() {
		String url=url2+"/hi2";
		System.out.println(url);
		ResponseEntity<String> res=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return res.getBody();
	}
	
	@GetMapping("/getall1")
	public List getmic1() {
		String url= url1+"/getall";
		System.out.println(url);
		ResponseEntity<List> res =restTemplate.exchange(url, HttpMethod.GET, null, List.class);
		return res.getBody();	
	}
	
	@GetMapping("/getall2")
	public String getmic2() {
		String url= url2+"/getalladdr";
		System.out.println(url);
		ResponseEntity<String> res =restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return res.getBody();
		
	}
	
	@PostMapping("/create1")
	public List<Student> poststd(@RequestBody Student student) {
		String url= url1+"/createstd";
		HttpEntity<Student> input= new HttpEntity<Student>(student);
		System.out.println(url);
		ResponseEntity<List<Student>> res =restTemplate.exchange(url, HttpMethod.POST, input, new ParameterizedTypeReference <List <Student>>() {
		});
		return res.getBody();
	}
//
//	@PostMapping("/create2")
//	public Student postadd() {
//		String url5=url2+"/createaddr";
//		System.out.println(url5);
//		ResponseEntity<Student> res =restTemplate.exchange(url5, HttpMethod.POST, null, Student.class);
//		return res.getBody();
//	}
	
	@GetMapping("/getbyid1/{id}")
	public Student findbyid(@PathVariable("id")int id) {
		String url=url1+"/findbyid/"+id;
		System.out.println(url);
		ResponseEntity<Student> res=restTemplate.exchange(url, HttpMethod.GET, null, Student.class);
		return res.getBody();
	}
	
	@GetMapping("/getname/{name}")
	public String findbyname(@PathVariable("name") String name) {
		String url=url1+"/findbyname/"+name;
		System.out.println(url);
		ResponseEntity<String> res=restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return res.getBody();
		
	}

	@PostMapping("/createone")
	public Student postadd(@RequestBody Student student) {
		String url=url1+"/createone";
		System.out.println(url);
		HttpEntity<Student> ip= new HttpEntity<Student>(student);
		ResponseEntity<Student> res =restTemplate.exchange(url, HttpMethod.POST, ip, Student.class);
		return res.getBody();
	}
	
	@DeleteMapping("/deleter/{id}")
	public int delete(@PathVariable("id") int id) {
		String url= url1+"/delete/"+id ;
		System.out.println(url);
		ResponseEntity<Void> res=restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
		return res.getStatusCodeValue();
	}
	
}