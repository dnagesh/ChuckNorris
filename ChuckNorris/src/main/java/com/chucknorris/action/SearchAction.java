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
public class SearchAction extends ActionSupport {

	private String name;
	private InputStream inputStream;

	JokeService service = (JokeService) new JokeServiceImpl();

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		
		String joke = service.getJokeWithName(null,null);
		inputStream = new ByteArrayInputStream(joke.getBytes(StandardCharsets.UTF_8));


		return SUCCESS;
	}

	/**
	 * @return Sring
	 * @throws Exception
	 */
	public String change() throws Exception {

		// validate & split name into first and secondName
		String[] names = getNames();
		// call service
		String joke = service.getJokeWithName(names[0], names[1]);
		inputStream = new ByteArrayInputStream(joke.getBytes(StandardCharsets.UTF_8));

		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		if (name == null) {
			this.addFieldError(name, "Please enter your name");
		} else {

			String[] names = name.split(" ");
			if (names.length < 2) {
				this.addFieldError(name, "Please enter first name and second name");
			}
		}
	}

	private String[] getNames() {
		String[] names = name.split(" ");
		return names;
	}
	public InputStream getInputStream() {
		return inputStream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
