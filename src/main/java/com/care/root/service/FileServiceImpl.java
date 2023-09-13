package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService{

	@Autowired FileMapper mapper;
	
	@Override
	public void fileProcess(String id, String name,
						MultipartFile file) {
		
		FileDTO dto = new FileDTO();

		dto.setId(id);
		dto.setName(name);

		if( !file.isEmpty()) { // file.getSize() != 0
			
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			
			// sysFileName = 20230913102910-filename
			String sysFileName = fo.format(new Date());
			
			sysFileName += file.getOriginalFilename();
			System.out.println("sysFileName: "+ sysFileName);
			
			File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		
		try {
			mapper.saveData( dto );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FileDTO> getData() {
		List<FileDTO> list = null;
		try {
			list = mapper.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void delete(String file, String id) {
		try {
			int result = mapper.delete(id);
			if (result == 1) {
				File d = new File(IMAGE_REPO+ "/"+ file);
				System.out.println("d.exists(): "+ d.exists());
				if(d.exists()) {
					d.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public FileDTO modView(String id) {
		FileDTO dto = mapper.modView(id);
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getImgName());
		return dto;
	}

	@Override
	public void mod(String id, String name, MultipartFile file) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		System.out.println("ser=======");
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		
		
		if(file.getSize() != 0) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			
			String sysFileName = fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			
			File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		System.out.println("ser2========");
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getImgName());
		try {
			mapper.mod( dto );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
