package pl.piomin.samples.spring.graphql.domain;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;


}
