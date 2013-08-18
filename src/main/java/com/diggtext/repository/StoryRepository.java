package com.diggtext.repository;

import com.diggtext.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface StoryRepository extends JpaRepository<Story, Long> {

}
