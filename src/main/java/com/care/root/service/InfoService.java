package com.care.root.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.care.root.dto.InfoDTO;

@Service
public class InfoService {
	
	Map<String, InfoDTO> DB;
	ArrayList<InfoDTO> list;
	
	
	public InfoService() {
		
		DB = new HashMap<String, InfoDTO>();
		list = new ArrayList<InfoDTO>();
		
		for(int i=0; i<5; i++) {
			InfoDTO dto = new InfoDTO();
			
			dto.setName("홍길동"+i);
			dto.setAge(i);
			
			list.add(dto);
			DB.put("홍길동"+i, dto);
		}
	}
	
	public List<InfoDTO> getList(){
		// select * from table;
		return list;
	}
	
	public InfoDTO getUser(String id) {
		// select * from table where id=id;
		return DB.get(id);
	}
	
	public int modify(InfoDTO dto) {
		// update table set name=name;
		DB.replace(dto.getName(), dto);
		return 1;
	}

	public int insert(InfoDTO dto) {
		// insert into table values('name');
		DB.put(dto.getName(), dto);
		list.add(dto);
		
		return 1;
	}
	
	public void delete(String uId) {
		DB.remove(uId);	// DB에서 삭제
		for(int i=0; i<list.size(); i++) {	// list에서 삭제
			InfoDTO dto = list.get(i);
			if (dto.getName().equals(uId)) {
				list.remove(i);
			}
		}
	}
}
