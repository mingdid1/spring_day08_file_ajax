package com.care.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.dto.InfoDTO;
import com.care.root.service.InfoService;

@RestController
public class AjaxRestController {
	
	@GetMapping(value="rest",
			produces = "application/text; charset=utf-8")
	public String get() {
		return "get ������ ��û";
	}
	
	@PostMapping(value="rest",
			produces = "application/text; charset=utf-8")
	public String post() {
		return "post ������ �߰�";
	}
	
	@PutMapping(value="rest",
			produces = "application/text; charset=utf-8")
	public String put() {
		return "put ������ ����";
	}
	
	@DeleteMapping(value="rest",
			produces = "application/text; charset=utf-8")
	public String delete() {
		return "delete ������ ����";
	}
	
	
	@Autowired InfoService is;
	
	@GetMapping(value="users",
			produces = "application/json; charset=utf-8")
	public List<InfoDTO> users(){
		return is.getList();
	}

	@GetMapping(value="getUser",
			produces = "application/json; charset=utf-8")
	public InfoDTO getUser(@RequestParam String id){
		System.out.println(id);
		return is.getUser(id);
	}

	@GetMapping(value="getUser/{aa}",	// {} �ȿ� �������� �� �ۼ�
			produces = "application/json; charset=utf-8")
	public InfoDTO getUser2(@PathVariable (value="aa") String id){
		System.out.println("@PathVariable: " +id);
		return is.getUser(id);
	}

	@PutMapping(value="modify",
			produces = "application/json; charset=utf-8")
	public int modify(@RequestBody InfoDTO dto){
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		
		int result = is.modify(dto);
		return result;
	}

	@PostMapping(value="insert",
			produces = "application/json; charset=utf-8")
	public int insert(@RequestBody InfoDTO dto){ // Map map
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		
		int result = is.insert(dto);
		return result;
	}

	@DeleteMapping(value="delete/{uId}",
			produces = "application/json; charset=utf-8")
	public void delete(@PathVariable String uId){
		is.delete(uId);
	}
}