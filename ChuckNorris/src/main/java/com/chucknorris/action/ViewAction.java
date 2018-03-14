package com.chucknorris.action;

import java.util.List;

import com.chucknorris.service.JokeService;
import com.chucknorris.service.JokeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author User
 *
 */
public class ViewAction extends ActionSupport{
	
	JokeService service = (JokeService) new JokeServiceImpl();
	List<String> jokes;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
      jokes = service.getMultipleJokes(10);
      return SUCCESS;
    }
	
	
	public List<String> getJokes() {
		return jokes;
	}

	

}
