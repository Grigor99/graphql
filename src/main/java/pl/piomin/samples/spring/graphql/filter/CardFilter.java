package pl.piomin.samples.spring.graphql.filter;

import lombok.Data;

@Data
public class CardFilter {
    private FilterField cvv;
    private FilterField fullName;
    private FilterField number;
    private FilterField validThrough;
}


