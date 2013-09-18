package com.diggtext.service;


import java.util.List;
import com.diggtext.model.Story;
import com.diggtext.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import javax.annotation.Resource;


@Service
public class StoryServiceImpl implements StoryService {
	@Resource
    private StoryRepository storyRepository;

    @Override
    public List<Story> findAll(){
        return storyRepository.findAll(new Sort(Direction.DESC,"CreatedAt"));
    }
    
    @Override
    public Story findById(String id){
        return storyRepository.findById(id);
    }
    
    public void save(Story story){
    	storyRepository.save(story);
    }
    
}

