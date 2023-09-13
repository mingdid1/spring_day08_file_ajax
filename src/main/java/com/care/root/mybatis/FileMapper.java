package com.care.root.mybatis;

import java.util.List;

import com.care.root.dto.FileDTO;

public interface FileMapper {
	
	public void saveData(FileDTO dto);
	public List<FileDTO> getData();
	public int delete(String id);
	public FileDTO modView(String id);
	public void mod(FileDTO dto);
}
