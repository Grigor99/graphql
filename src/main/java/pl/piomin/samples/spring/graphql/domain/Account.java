package pl.piomin.samples.spring.graphql.domain;


import lombok.*;
import org.apache.commons.lang3.StringUtils;
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
    //during accounts request if you want to get employee's info besides id then fetch should be Eager


    @PrePersist
    @PreUpdate
    public void persisteBeforeSave() {
        if (StringUtils.isEmpty(number)) {
            number = "ddddd";
        }
    }

}
