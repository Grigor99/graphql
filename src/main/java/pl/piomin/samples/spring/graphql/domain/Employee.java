package pl.piomin.samples.spring.graphql.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Integer id;
	private String firstName;
	private String lastName;
	private String position;
	private int salary;
	private int age;


	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization organization;

	@OneToMany(mappedBy = "employee")
	private Set<Account> accounts;

}
