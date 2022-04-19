package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DeptDTO;
import com.example.service.DeptService;

@Controller
public class MainController {

	@Autowired
	DeptService service;
	
	@GetMapping("/list")
	public @ResponseBody List<DeptDTO> selectAll(){
		return service.selectAll();
	}
	
	
	@GetMapping("/main")
	public String hello() {
		System.out.println("hello");
		return "main"; // 뷰정보
	}
	
	@GetMapping("/productlist")
	public String productlist() {
		System.out.println("productlist");
		return "productlist"; // 뷰정보
	}
	@GetMapping("/login")
	public String login() {
		System.out.println("login");
		return "loginForm"; // 뷰정보
	}
	
}