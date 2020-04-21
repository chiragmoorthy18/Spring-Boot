package predicateUsage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import util.Person;
import util.PersonUtil;

public class PredicateDemonstration {

	public static void main(String[] args) {
		
		List<Person> persons = PersonUtil.populatePersons();
		
		// traversal using enhanced for 
		
		System.out.println("Traversal :: enhanced for");
		separator();
		for(Person p:persons) {
			
			System.out.println(p.toString());
		}
		separator();
		
		
		
		// traversal using stream 
		System.out.println("Traversal :: stream");
		persons.stream().forEach(p->System.out.println(p));
		separator();
		
		// filter age greater than 18 using enhanced for
		List<Person> filteredList = new ArrayList<>();
		
		for(Person p: persons) {
			
			if(p.getAge()>18) {
				filteredList.add(p);
			}
		}
		
		separator();
		// printing filtered list 
		System.out.println("filtered list after enhanced for filter");
		for(Person p:filteredList) {
			
			System.out.println(p.toString());
		}
		separator();
		
		// clearing filtered list 
		filteredList.clear();
		
		
		// filter age greater than 18 using stream and predicate
		Predicate<Person> agePredicate = p -> p.getAge()>18;
		filteredList = persons.stream().filter(agePredicate).collect(Collectors.toList());
		// printing filtered list 
		System.out.println("filtered list after stream and predicate filter");
		filteredList.stream().forEach(p->System.out.println(p));
		
	}

	private static void separator() {
		System.out.println("---------------------------------------------------------");
	}

}
