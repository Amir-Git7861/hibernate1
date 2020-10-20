package com.wellsfargo.fsd.swbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.swbd.model.Item;
import com.wellsfargo.fsd.swbd.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	public String showItemForm() {
		
		return "item-form-page";
		
	}
	
	@PostMapping("/item")
	public ModelAndView acceptItem(@ModelAttribute Item itemModel) {
		itemService.ComputeGSTandSellinPrice(itemModel);
		return new ModelAndView("item-output-page","item",itemModel);
	}
	
	

}
