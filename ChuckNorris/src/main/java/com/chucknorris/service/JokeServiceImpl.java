package com.chucknorris.service;

import java.util.ArrayList;
import java.util.List;

import net.joningi.icndb.ICNDBClient;
import net.joningi.icndb.Joke;

/**
 * @author User
 *
 */
public class JokeServiceImpl implements JokeService{
    private final ICNDBClient client;
  
    public JokeServiceImpl() {
        this.client = new ICNDBClient();
    }

    /* (non-Javadoc)
     * @see com.chucknorris.service.JokeService#getRandonJoke()
     */
    public String getRandonJoke() {
    	Joke randomJoke = client.getRandom();
        return randomJoke.getJoke();
    }
    
    /* (non-Javadoc)
     * @see com.chucknorris.service.JokeService#getMultipleJokes(int)
     */
    public List<String> getMultipleJokes(int count) {
    	List<String> jokesList = new ArrayList<String>(count);
    	List<Joke> jokes = client.getRandom(count);
    	for (Joke joke : jokes) {
    		jokesList.add(joke.getJoke());
		}
    	return jokesList;
    }
    
    /* (non-Javadoc)
     * @see com.chucknorris.service.JokeService#getJokeWithName(java.lang.String, java.lang.String)
     */
    public String getJokeWithName(String firstName, String lastName) {
    	client.setFirstName(firstName);
    	client.setLastName(lastName);
    	Joke randomJoke = client.getRandom();
        return randomJoke.getJoke();
    }

}
