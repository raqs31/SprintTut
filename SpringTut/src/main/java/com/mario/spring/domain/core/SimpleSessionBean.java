package com.mario.spring.domain.core;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by raqsW on 2016-08-20.
 */
@Data
@Component
@SessionScope
public class SimpleSessionBean {
	private String nameOf;
	private List<String> listOfProps;

	public SimpleSessionBean() {
		nameOf = "Learn Spring + thymeleaf";
		listOfProps = new LinkedList<>();

		listOfProps.add("go1");
		listOfProps.add("go2");
		listOfProps.add("go3");
		listOfProps.add("go4");
		listOfProps.add("go5");
		listOfProps.add("go6");
		listOfProps.add("go7");
	}
}
