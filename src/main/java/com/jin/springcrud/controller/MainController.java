package com.jin.springcrud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jin.springcrud.entity.Person;
import com.jin.springcrud.util.getIpLocation;

@Controller
public class MainController {
	@GetMapping("/hello")
	public String welcome(HttpServletRequest req, Model theModel) {
		String remoteAddr = req.getRemoteAddr();
		theModel.addAttribute("customerIp", remoteAddr);
		theModel.addAttribute("place", getIpLocation.getAddressByIP(remoteAddr));
		System.out.println(remoteAddr);
		return "hello";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/gallery")
	public String getGallery() {
		return "photogallery";
	}
	
	@GetMapping("/iqtest")
	public String getIqTestPage() {
		return "iqtest";
	}
	
	@GetMapping("/eqtest")
	public String getEwqTestPage() {
		return "eqtest";
	}
}
