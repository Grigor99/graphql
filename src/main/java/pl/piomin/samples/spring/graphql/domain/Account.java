package pl.piomin.samples.spring.graphql.domain;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer id;

    private String number;

    private Integer grade;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Employee employee;


}
