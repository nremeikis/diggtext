package com.diggtext.service;


import java.util.List;
import com.diggtext.model.Story;
import com.diggtext.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
public class StoryServiceImpl implements StoryService {
	@Resource
    private StoryRepository storyRepository;


    
    @Override
    public List<Story> findAll(){
        return storyRepository.findAll();
    }
    
}

