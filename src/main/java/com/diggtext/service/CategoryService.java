package com.diggtext.service;

import java.util.List;

import com.diggtext.model.*;

public interface CategoryService {
   List<Category> findAll();
   Category findById(String id);
}