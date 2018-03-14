package com.chucknorris.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.chucknorris.service.JokeService;
import com.chucknorris.service.JokeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ScrollAction extends ActionSupport{
	
	JokeService service = JokeServiceSingleton.getInstance();
	List<String> jokes;
	InputStream inputStream;
	
	public InputStream getInputStream() {
			return inputStream;
	}

	public String execute() throws Exception {
		jokes = service.getMultipleJokes(10);
		StringBuilder sb = new StringBuilder();
		for (String joke : jokes) {
			sb.append("<p>");
			sb.append(joke);
			sb.append("</p>");
			 inputStream = new ByteArrayInputStream(
			 sb.toString().getBytes(StandardCharsets.UTF_8));
			
		      
		}
       return SUCCESS;
    }

}
