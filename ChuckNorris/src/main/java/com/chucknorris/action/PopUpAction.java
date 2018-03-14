package com.chucknorris.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.chucknorris.service.JokeService;
import com.chucknorris.service.JokeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author User
 *
 */
@SuppressWarnings("serial")
public class PopUpAction extends ActionSupport {
	 
  	JokeService service = JokeServiceSingleton.getInstance();
	
	private InputStream inputStream;

    public InputStream getInputStream() {
		return inputStream;
	}

	public String execute() throws Exception {
    	String randomJoke = service.getRandonJoke();
    	inputStream = new ByteArrayInputStream(
    			randomJoke.getBytes(StandardCharsets.UTF_8));
       return SUCCESS;
    }
 
}
