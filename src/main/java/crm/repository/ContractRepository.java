package crm.repository;

import crm.entity.Contract;
import crm.entity.Customer;
import crm.entity.Status;
import crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    Contract findByName(String contractName);

    Iterable<Contract> findAllByValueLessThanEqual(BigDecimal value);

    Iterable<Contract> findAllByValueGreaterThanEqual(BigDecimal value);

    Iterable<Contract> findAllByBeginDate(LocalDate beginDate);

    Iterable<Contract> findAllByBeginDateBefore(LocalDate beforeBeginDate);

    Iterable<Contract> findAllByBeginDateAfter(LocalDate afterBeginDate);

    Iterable<Contract> findAllByEndDate(LocalDate endDate);

    Iterable<Contract> findAllByEndDateBefore(LocalDate beforeEndDate);

    Iterable<Contract> findAllByEndDateAfter(LocalDate afterEndDate);

    Iterable<Contract> findAllByStatus(Status status);

    Iterable<Contract> findAllByCustomer(Customer customer);

    Iterable<Contract> findAllByCustomerAndUser(Customer customer, User user);

    Iterable<Contract> findAllByUser(User user);

}
