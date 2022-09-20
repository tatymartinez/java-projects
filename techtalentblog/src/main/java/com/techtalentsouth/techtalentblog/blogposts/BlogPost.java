package com.techtalentsouth.techtalentblog.blogposts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String blogEntry;
	
	//But in order for the JPA to do its magic, we have to have 
	//a no-argument constructor.
	public BlogPost() {
		
	}
	
	public BlogPost(String title, String author, String blogEntry) {
		super();
		this.title = title;
		this.author = author;
		this.blogEntry = blogEntry;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBlogEntry() {
		return blogEntry;
	}

	public void setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", author=" + author + ", blogEntry=" + blogEntry + "]";
	}
	
}
