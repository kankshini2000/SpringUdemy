package com.example.spring.springudemycourse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.springudemycourse.bean.Student;

@RestController
@RequestMapping("/api/std")
public class StudentController {

	@GetMapping("/get")
	public Student getStd() {
		Student std = new Student(1,"mahesh", "jogi" );
		return std;
	}
	
	@GetMapping("/getAll")
	public List<Student> getStdList(){
		List<Student> std = new ArrayList<>();
		std.add(new Student(2,"hina","singh"));
		std.add(new Student(3,"mina","ingh"));
		std.add(new Student(4,"pina","ngh"));
		return std;
		
	}
	
	/*here the main reason why do we need to create new Student() is bcoz
	 * we dont have any database so as to get the specif infomration of that std1=2
	 * hence we need to manullly do the creation for it.*/
	@GetMapping("/{id}")
	public Student studentPathVariable(@PathVariable("id") int Stdid) {
		return new Student(Stdid,"hina","singh");
	}
	
	@GetMapping("/{id}/{f-name}/{l-name}")
	public Student stdPathVaribles(@PathVariable("id") int Stdid
			,@PathVariable("f-name") String stdfname
			,@PathVariable("l-name") String stdlname
			) 
	{
		return new Student(Stdid,stdfname,stdlname);
	}
	
	
	@GetMapping("/query")
	public Student stdReqParam(@RequestParam int id) {
		return new Student(id,"ria","mina");
	}
	
	@GetMapping("/query/Mul")
	public Student stdMulReqParams(@RequestParam int id
			,@RequestParam String fname
			,@RequestParam String lname
			) {
		return new Student(id,fname,lname);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStd(@RequestBody Student std4) {
		/*here we have provided sysout stmts as we have used reuestbody 
		 * which converts json object to java object n java object needs to
		 * get printed as object in console and hence std4 object is get as an 
		 * an response*/
		System.out.println(std4.getId());
		System.out.println(std4.getFname());
		System.out.println(std4.getLname());
		return std4;
	}
}
