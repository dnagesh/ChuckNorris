package com.chucknorris.action;

import com.chucknorris.service.JokeService;
import com.chucknorris.service.JokeServiceImpl;

/**
 * @author User
 *
 */
public class JokeServiceSingleton {
	
	    private static JokeService instance;
	    
	    private JokeServiceSingleton(){}
	    
	    /**
	     * @return JokeService instance
	     */
	    public static JokeService getInstance(){
	        if(instance == null){
	            instance = new JokeServiceImpl();
	        }
	        return instance;
	    }

}
