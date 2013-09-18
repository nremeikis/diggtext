package com.diggtext.service;

import java.util.List;

import com.diggtext.model.*;

public interface StoryService {
   List<Story> findAll();
   Story findById(String id);
   void save(Story story);
}