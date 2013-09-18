package com.diggtext.service;


import java.util.List;
import com.diggtext.model.Category;
import com.diggtext.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    
    @Override
    public Category findById(String id){
        return categoryRepository.findById(id);
    }
}

