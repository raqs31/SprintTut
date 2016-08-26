package com.mario.spring.co;

import com.mario.spring.domain.model.arena.Actor;
import com.mario.spring.domain.model.embedable.Adress;
import com.mario.spring.domain.model.embedable.PersonalData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by raqsW on 2016-08-19.
 */
@Controller
public class AsterixExampleController {

	@GetMapping("/asterix")
	public String asterixExample(Map<String, Object> model) {
		Actor fake = new Actor();
		PersonalData fakePd = new PersonalData();
		Adress fakeAdress = new Adress();

		fakeAdress.setCity("Warsaw");
		fakeAdress.setStreet("Tucholska 12");

		fakePd.setAdress(fakeAdress);
		fakePd.setBirthday(Calendar.getInstance().getTime());
		fakePd.setName("MyLittle");
		fakePd.setLastName("Friend");

		model.put("actor", fake);

		return "asterixExample";
	}
}
