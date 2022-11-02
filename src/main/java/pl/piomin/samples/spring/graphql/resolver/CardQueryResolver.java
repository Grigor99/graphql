package pl.piomin.samples.spring.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.piomin.samples.spring.graphql.domain.Card;
import pl.piomin.samples.spring.graphql.domain.Department;
import pl.piomin.samples.spring.graphql.domain.Employee;
import pl.piomin.samples.spring.graphql.filter.CardFilter;
import pl.piomin.samples.spring.graphql.filter.FilterField;
import pl.piomin.samples.spring.graphql.repository.CardRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CardQueryResolver implements GraphQLQueryResolver {
    private final CardRepository cardRepository;

    public Iterable<Card> cards() {
        return cardRepository.findAll();
    }

    public Card card(Integer id) {
        return cardRepository.findById(id).get();
    }

    public Iterable<Card> cardsWithFilter(CardFilter filter) {
        Specification<Card> spec = null;
        if (filter.getCvv() != null)
            spec = byCvv(filter.getCvv());
        if (filter.getFullName() != null)
            spec = (spec == null ? byFullName(filter.getFullName()) : spec.and(byFullName(filter.getFullName())));
        if (filter.getNumber() != null)
            spec = (spec == null ? byNumber(filter.getNumber()) :
                    spec.and(byNumber(filter.getNumber())));
        if (filter.getValidThrough() != null) {
            spec = (spec == null ? byValidThrough(filter.getValidThrough()) : spec.and(byValidThrough(filter.getValidThrough())));
        }
        if (spec != null)
            return cardRepository.findAll(spec);
        else
            return cardRepository.findAll();

    }

    private Specification<Card> byCvv(FilterField filterField) {
        return (Specification<Card>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("cvv"));
    }

    private Specification<Card> byFullName(FilterField filterField) {
        return (Specification<Card>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("fullName"));
    }

    private Specification<Card> byNumber(FilterField filterField) {
        return (Specification<Card>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("number"));
    }

    private Specification<Card> byValidThrough(FilterField filterField) {
        return (Specification<Card>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("validThrough"));
    }

}
