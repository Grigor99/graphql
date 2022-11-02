package pl.piomin.samples.spring.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardInput {
    @NotNull
    @Size(min = 12, max = 12)
    private String number;
    @Pattern(regexp = "^[A-Z]+$")
    @NotNull
    private String fullName;
    @Size(min = 3, max = 3)
    @NotNull
    private String cvv;
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date validThrough;
}
