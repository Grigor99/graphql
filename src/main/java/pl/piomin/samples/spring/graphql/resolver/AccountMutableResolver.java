package pl.piomin.samples.spring.graphql.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import pl.piomin.samples.spring.graphql.domain.Account;
import pl.piomin.samples.spring.graphql.domain.AccountInput;
import pl.piomin.samples.spring.graphql.domain.Employee;
import pl.piomin.samples.spring.graphql.repository.AccountRepository;
import pl.piomin.samples.spring.graphql.repository.EmployeeRepository;

@Component
public class AccountMutableResolver implements GraphQLMutationResolver {
    AccountRepository accountRepository;
    EmployeeRepository employeeRepository;

    public AccountMutableResolver(AccountRepository accountRepository, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
    }

    public Account newAccount(AccountInput accountInput) {
        Employee employee = employeeRepository.findById(accountInput.getEmployeeId()).get();
        return accountRepository.save(new Account(null, accountInput.getNumber(), employee));
    }
}
