package pl.piomin.samples.spring.graphql.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Organization {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "organization")
	private Set<Department> departments;
	@OneToMany(mappedBy = "organization")
	private Set<Employee> employees;


}
