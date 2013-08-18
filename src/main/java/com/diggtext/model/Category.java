package com.diggtext.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Category database table.
 * 
 */
@Entity
public class Category {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="CreatedAt")
	private Timestamp createdAt;

	@Column(name="Name")
	private String name;

	@Column(name="UniqueName")
	private String uniqueName;

	//bi-directional many-to-one association to Story
	@OneToMany(mappedBy="category")
	private List<Story> stories;

	public Category() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniqueName() {
		return this.uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public List<Story> getStories() {
		return this.stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

}