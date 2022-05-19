package com.narangnorang.controller;

import com.narangnorang.dto.*;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.MiniroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MiniroomController {

	@Autowired
	MiniroomService miniroomService;

	//구매 버튼 클릭시 실행
	@PostMapping("/home/buy")
	public String buy(HttpSession session,MyItemDTO myItemDTO) throws Exception{
		System.out.println(myItemDTO);
		int num = miniroomService.insertBuy(myItemDTO);


		return "redirect:/home/buy";
	}
	//적용하기 버튼 클릭시 마이룸에 해당 아이템 번호
	@PostMapping("/home/style")
	public String style(HttpSession session,MyRoomDTO myRoomDTO) throws Exception{

//		int num = miniroomService.updateStyle(myRoomDTO);

		return "redirect:/home/style";
	}

	@PutMapping("/home/buy/{itemId}")
	public String wishupdate(@PathVariable("itemId") int itemId) throws Exception{
//		System.out.println(myItemDTO);
//		myItemDTO = miniroomService.selectByMyItemId(itemId);
//		model.addAttribute("myItem", myItemDTO);
		miniroomService.wishupdate(itemId);

		return "redirect:/home/buy";
	}

	@PutMapping("/home/style/{memberId}")
	public String applyMiniroom(@PathVariable("memberId") String memberId) throws Exception{
//		System.out.println(myItemDTO);
//		myItemDTO = miniroomService.selectByMyItemId(itemId);
//		model.addAttribute("myItem", myItemDTO);
		miniroomService.applyMiniroom(memberId);

		return "redirect:/home/style";
	}

	@GetMapping("/home/buy")
	public ModelAndView buy(HttpSession session,
							  @RequestParam(value="category",required=false,defaultValue="bed") String category

	) throws Exception {

		List<ItemDTO> list =  miniroomService.selectAllItems(category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("home_buy");


		String userId = mDto.getId();
		mav.addObject("itemList",list);
		mav.addObject("memberId",userId);
		return mav;
	}

	@GetMapping("/home/style")
	public ModelAndView style(HttpSession session,
							  @RequestParam(value="category",required=false,defaultValue="bed") String category

	) throws Exception {
		List<MyItemDTO> myItemList =  miniroomService.selectAllMyItems(category);
		List<ItemDTO> itemList =  miniroomService.selectAllItems(category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("home_style");

		System.out.println(myItemList);
		String userId = mDto.getId();
		mav.addObject("myItemList",myItemList);
		mav.addObject("itemList",itemList);

		mav.addObject("memberId",userId);
		return mav;
	}



}
