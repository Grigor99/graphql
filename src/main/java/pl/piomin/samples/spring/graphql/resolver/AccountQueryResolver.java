package pl.piomin.samples.spring.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.piomin.samples.spring.graphql.domain.Account;
import pl.piomin.samples.spring.graphql.domain.Department;
import pl.piomin.samples.spring.graphql.domain.Employee;
import pl.piomin.samples.spring.graphql.repository.AccountRepository;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.NoSuchElementException;


@Component
public class AccountQueryResolver implements GraphQLQueryResolver {
    AccountRepository accountRepository;

    public AccountQueryResolver(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> accounts(DataFetchingEnvironment dataFetchingEnvironment){
        DataFetchingFieldSelectionSet s = dataFetchingEnvironment.getSelectionSet();
        if (s.contains("employee"))
           return accountRepository.findAll(fetchEmployees());
        else {
            return accountRepository.findAll();
        }
    }
    public Account account(Integer id, DataFetchingEnvironment environment) {
        Specification<Account> spec = byId(id);
        DataFetchingFieldSelectionSet selectionSet = environment.getSelectionSet();
        if (selectionSet.contains("employee"))
            spec = spec.and(fetchEmployees());

        return accountRepository.findOne(spec).orElseThrow(NoSuchElementException::new);
    }

    private Specification<Account> fetchEmployees() {
        return (Specification<Account>) (root, query, builder) -> {
            Fetch<Account, Employee> f = root.fetch("employee", JoinType.LEFT);
            Join<Account, Employee> join = (Join<Account, Employee>) f;
            return join.getOn();
        };
    }
    private Specification<Account> byId(Integer id) {
        return (Specification<Account>) (root, query, builder) -> builder.equal(root.get("id"), id);
    }

}
