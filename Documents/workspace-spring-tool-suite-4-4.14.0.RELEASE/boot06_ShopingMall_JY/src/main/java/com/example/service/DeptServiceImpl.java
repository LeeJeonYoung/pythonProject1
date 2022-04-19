package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.DeptDAO;
import com.example.dto.DeptDTO;


@Service("deptService")
public class DeptServiceImpl implements DeptService {

	DeptDAO dao;
	//생성자 주입
	public DeptServiceImpl(DeptDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<DeptDTO> selectAll() {
		return dao.selectAll();
	}

}
