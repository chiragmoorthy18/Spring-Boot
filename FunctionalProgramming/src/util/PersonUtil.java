package util;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

	public static List<Person> populatePersons() {
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Vivek", 22, "Male"));
		persons.add(new Person("Promis", 17, "Female"));
		persons.add(new Person("Marion", 44, "Female"));
		return persons;
	}

}
