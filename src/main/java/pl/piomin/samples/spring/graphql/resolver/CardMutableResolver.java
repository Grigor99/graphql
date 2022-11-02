package pl.piomin.samples.spring.graphql.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;
import pl.piomin.samples.spring.graphql.domain.*;
import pl.piomin.samples.spring.graphql.repository.CardRepository;

import javax.validation.Valid;


@Component
@RequiredArgsConstructor
public class CardMutableResolver implements GraphQLMutationResolver {
    private final CardRepository cardRepository;

    public Card newCard(@Valid CardInput cardInput) {
        return cardRepository.save(new Card(cardInput));
    }
}
