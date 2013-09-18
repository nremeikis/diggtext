package com.diggtext.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import org.hibernate.annotations.GenericGenerator; 
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the Story database table.
 * 
 */
@Entity
public class Story {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
	@GeneratedValue(generator = "generator")
	@Column(name = "Id" , columnDefinition="uniqueidentifier")
	private String id;

	@Column(name="ApprovedAt")
	private Timestamp approvedAt;

	@Column(name="CreatedAt")
	private Timestamp createdAt;

	@Column(name="HtmlDescription")
	private String htmlDescription;

	private String IPAddress;

	@Column(name="LastActivityAt")
	private Timestamp lastActivityAt;

	@Column(name="LastProcessedAt")
	private Timestamp lastProcessedAt;

	@Column(name="PublishedAt")
	private Timestamp publishedAt;

	@Column(name="Rank")
	private int rank;

	@Column(name="TextDescription")
	private String textDescription;

	@Column(name="Title")
	private String title;

	@Column(name="Url")
	private String url;

	@Column(name="UserId")
	private String userId;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;

	public Story() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getApprovedAt() {
		return this.approvedAt;
	}

	public void setApprovedAt(Timestamp approvedAt) {
		this.approvedAt = approvedAt;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getHtmlDescription() {
		return this.htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public String getIPAddress() {
		return this.IPAddress;
	}

	public void setIPAddress(String IPAddress) {
		this.IPAddress = IPAddress;
	}

	public Timestamp getLastActivityAt() {
		return this.lastActivityAt;
	}

	public void setLastActivityAt(Timestamp lastActivityAt) {
		this.lastActivityAt = lastActivityAt;
	}

	public Timestamp getLastProcessedAt() {
		return this.lastProcessedAt;
	}

	public void setLastProcessedAt(Timestamp lastProcessedAt) {
		this.lastProcessedAt = lastProcessedAt;
	}

	public Timestamp getPublishedAt() {
		return this.publishedAt;
	}

	public void setPublishedAt(Timestamp publishedAt) {
		this.publishedAt = publishedAt;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getTextDescription() {
		return this.textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}