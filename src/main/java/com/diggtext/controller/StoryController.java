package com.diggtext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.*;
import org.springframework.validation.*;
import com.diggtext.model.*;
import com.diggtext.service.*;
import com.diggtext.editors.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.examples.*;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import javax.servlet.http.*;
import javax.validation.Valid;
import java.beans.*;;
import java.util.Date;
import java.sql.Timestamp;

@Controller   
@SessionAttributes("story")
public class StoryController {  

	@Autowired
    private StoryService storyService;
	@Autowired
    private CategoryService categoryService;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)  
	public String printWelcome(ModelMap model) {  
        model.addAttribute("stories", storyService.findAll());  
        return "home";  
    }  
    
    @RequestMapping(value = "/redirectToSite", method = RequestMethod.GET)
    protected String redirect(@RequestParam("id") String id) 
    {
    	String redirectUrl = storyService.findById(id).getUrl();
        return "redirect:" + redirectUrl;
    }
    
    @RequestMapping(value = "/submitUrl", method = RequestMethod.POST)
    protected ModelAndView submit(@RequestParam("httpAddress") String httpAddress,ModelMap model)
    {
    	try
        {
    		Document doc = Jsoup.connect(httpAddress).get();
        	HtmlToPlainText formatter = new HtmlToPlainText();
            String title = doc.title();
            String textDescription = doc.body().text();
            String htmlDescription = doc.toString();
            model.addAttribute("stories", doc.toString());
            httpAddress.hashCode();
            
            ModelAndView mv = new ModelAndView("storyEdit");
            Story story = new Story();
            story.setTitle(title);
            story.setUrl(httpAddress);
            story.setTextDescription(textDescription);
            story.setHtmlDescription(htmlDescription);
            Date date = new Date();
            story.setCreatedAt(new Timestamp(date.getTime()));
            mv.addObject("categories", categoryService.findAll());
            mv.addObject("story", story);

            return mv;
        }
        catch (IOException e)
        {
            ModelAndView mv = new ModelAndView("home");
            mv.addObject("error","Can't read from URL");
            mv.addObject("stories", storyService.findAll());
            return mv;
        	
        }
        catch (IllegalArgumentException e)
        {
            ModelAndView mv = new ModelAndView("home");
            mv.addObject("error","Bad URL");
            mv.addObject("stories", storyService.findAll());
            return mv;
        }
    }
    @RequestMapping(value = "/submitStory", method = RequestMethod.POST)
    protected ModelAndView submitStory(@Valid Story story, BindingResult result){
        if(result.hasErrors()) {
        	ModelAndView mv = new ModelAndView("storyEdit"); 
          	return mv;
        }

    	storyService.save(story);
    	ModelAndView mv = new ModelAndView("home");
        mv.addObject("stories", storyService.findAll());
        return mv;
    }
}

