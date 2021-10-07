package hu.big.brain.csv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(Person p) {
		this.id = p.id;
		this.firstName = p.firstName;
		this.lastName = p.lastName;
		this.age = p.age;
	}
}
