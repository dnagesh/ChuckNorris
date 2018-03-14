package com.chucknorris.service;

import java.util.List;

/**
 * @author User
 *
 */
public interface JokeService {
	
	/**
	 * @return Joke
	 */
	public String getRandonJoke();
	
	/**
	 * @param firstName
	 * @param lastName
	 * @return Joke with changed  names
	 */
	public String getJokeWithName(String firstName, String lastName);
	
	public List<String>  getMultipleJokes(int count);

}
