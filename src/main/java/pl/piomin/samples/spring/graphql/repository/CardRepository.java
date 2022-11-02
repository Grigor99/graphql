package pl.piomin.samples.spring.graphql.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.piomin.samples.spring.graphql.domain.Card;

@Repository
public interface CardRepository extends CrudRepository<Card,Integer>, JpaSpecificationExecutor<Card> {
}
