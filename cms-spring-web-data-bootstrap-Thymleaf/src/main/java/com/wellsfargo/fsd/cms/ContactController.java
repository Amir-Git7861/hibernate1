package com.wellsfargo.fsd.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {
	
	@Autowired
	private ContactService1 service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Contact> listContacts = service.listAll(keyword);
		model.addAttribute("listContacts", listContacts);
		model.addAttribute("keyword", keyword);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewContactForm(Model model) {
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
		Contact contact = new Contact();
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGG1");
		model.addAttribute("contact", contact);
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGG2");
		
		return "new_contact";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		service.save(contact);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Contact contact = service.get(id);
		mav.addObject("contacts", contact);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Integer id) {
		service.delete(id);
		
		return "redirect:/";
	}
	
	
	
}


