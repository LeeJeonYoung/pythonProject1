package com.narangnorang.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.MessageDTO;
import com.narangnorang.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/message")
	@ModelAttribute("messageList")
	public ModelAndView selectMessageList(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		ModelAndView mav = new ModelAndView();
		if (memberDTO != null) {
			String id = memberDTO.getId();
			mav.setViewName("message");
			
			List<MessageDTO> messageList = messageService.selectMessageList(id);
			Iterator<MessageDTO> iter = messageList.iterator();
			List<String> otherUsers = new ArrayList<String>();
			
			while(iter.hasNext()) {
				MessageDTO messageDTO = iter.next();
				
				if(otherUsers.contains(messageDTO.getSender()) || otherUsers.contains(messageDTO.getReciever())) {
					iter.remove();
				} else {
					if(!messageDTO.getSender().equals(id)) {
						otherUsers.add(messageDTO.getSender());
					}
					if(!messageDTO.getReciever().equals(id)) {
						otherUsers.add(messageDTO.getReciever());
					}		
				}
			}
			mav.addObject("messageList", messageList);
			mav.addObject("id", id);
		} else {
			mav.setViewName("common/sessionInvalidate");
		}
		return mav;
	}
	
	@GetMapping("/message/popup")
	public String popupMessageForm() throws Exception {
		return "message/messagePopup";
	}
}