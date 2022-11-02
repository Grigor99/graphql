package pl.piomin.samples.spring.graphql.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Department {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization organization;

}
