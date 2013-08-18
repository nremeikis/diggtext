package com.diggtext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.diggtext.model.Story;   
import com.diggtext.service.*;
@Controller    
public class StoryController {  

	@Autowired
    private StoryService storyService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)  
	public String printWelcome(ModelMap model) {  
        model.addAttribute("stories", storyService.findAll());  
        return "home";  
    }  
}

