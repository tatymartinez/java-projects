package com.techtalentsouth.techtalentblog.blogposts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	@Autowired
	private BlogPostRepository blogPostRepository;

	
	@GetMapping(path="/")	
	public String index(Model model) {

		List<BlogPost> posts = blogPostRepository.findAll();
				
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}

	@GetMapping(path="/blogposts/new")
	public String newBlog(Model model) {
		BlogPost defaultValue = new BlogPost();
		//Model is a lot like a hashmap
		//is stores keys value pairs....but they keys
		//are always string variable names.
		model.addAttribute("blogPost", defaultValue);
		return "blogpost/new";
	}
	
	@PostMapping(path="/blogposts")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		BlogPost result = blogPostRepository.save(blogPost);	
				
		model.addAttribute("blogPost", blogPost);
		return "blogpost/result";
	}
	
	//WE are going to create an endpoint to load up a single blog entry..
	//this endpoint is going to "/blogposts/{id}" where id is the 
	//primary key for a blogpost
	
	@GetMapping(path="/blogposts/{id}")
	public String editPostWithId(@PathVariable Long id, Model model) {
		Optional<BlogPost> post=blogPostRepository.findById(id);
		
		if(post.isPresent())
		{
			BlogPost actualPost = post.get();
			model.addAttribute("blogPost", actualPost);
		}
		return "blogpost/edit";
	}
	
	@PostMapping(path="/blogposts/{id}")
	public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model) {
		Optional<BlogPost> post = blogPostRepository.findById(id);
		if(post.isPresent()) {
			BlogPost actualPost = post.get();
			actualPost.setTitle(blogPost.getTitle());
			actualPost.setAuthor(blogPost.getAuthor());
			actualPost.setBlogEntry(blogPost.getBlogEntry());
			blogPostRepository.save(actualPost); //Update the existing post
			//because actualPost has the id primary key field of a post that already
			//exists in the database.
			
			model.addAttribute("blogPost", actualPost);
		}
		return "blogpost/result";		
	}	
	
	@GetMapping(path="/blogposts/delete/{id}")
	public String deletePostById(@PathVariable Long id) {
		blogPostRepository.deleteById(id);
		return "blogpost/delete";
	}

	
	
}
