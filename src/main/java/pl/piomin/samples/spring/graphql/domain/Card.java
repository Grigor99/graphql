package pl.piomin.samples.spring.graphql.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String number;
    @Column(name = "full_name")
    private String fullName;

    private String cvv;
    @Column(name = "valid_through")
    private Date validThrough;

    public Card(CardInput cardInput) {
        this.fullName = cardInput.getFullName();
        this.number = cardInput.getNumber();
        this.cvv = cardInput.getCvv();
        this.validThrough = cardInput.getValidThrough();
    }
}
