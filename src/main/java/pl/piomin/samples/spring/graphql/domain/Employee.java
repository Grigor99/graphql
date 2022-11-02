package pl.piomin.samples.spring.graphql.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
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
	@ToString.Exclude
	private Department department;
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Organization organization;

	@OneToMany(mappedBy = "employee")
	@ToString.Exclude
	private Set<Account> accounts;
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Employee employee = (Employee) o;
		return id != null && Objects.equals(id, employee.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
