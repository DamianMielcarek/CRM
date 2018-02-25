package crm.service;

import crm.entity.Contract;
import crm.entity.Customer;
import crm.entity.Status;
import crm.entity.User;
import crm.repository.ContractRepository;
import crm.repository.CustomerRepository;
import crm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;
    private CustomerRepository customerRepository;
    private UserRepository userRepository;

    public ContractServiceImpl(ContractRepository contractRepository, CustomerRepository customerRepository, UserRepository userRepository) {
        this.contractRepository = contractRepository;
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Contract findByName(String contractName) {
        return contractRepository.findByName(contractName);
    }

    @Override
    public Iterable<Contract> listAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract showContract(Long id) {
        return contractRepository.findOne(id);
    }

    @Override
    public Iterable<Contract> findAllByValueLessThanEqual(BigDecimal value) {
        return contractRepository.findAllByValueLessThanEqual(value);
    }

    @Override
    public Iterable<Contract> findAllByValueGreaterThanEqual(BigDecimal value) {
        return contractRepository.findAllByValueGreaterThanEqual(value);
    }

    @Override
    public Iterable<Contract> findAllByBeginDate(LocalDate beginDate) {
        return contractRepository.findAllByBeginDate(beginDate);
    }

    @Override
    public Iterable<Contract> findAllByBeginDateBefore(LocalDate beforeBeginDate) {
        return contractRepository.findAllByBeginDateBefore(beforeBeginDate);
    }

    @Override
    public Iterable<Contract> findAllByBeginDateAfter(LocalDate afterBeginDate) {
        return contractRepository.findAllByBeginDateAfter(afterBeginDate);
    }

    @Override
    public Iterable<Contract> findAllByEndDate(LocalDate endDate) {
        return contractRepository.findAllByEndDate(endDate);
    }

    @Override
    public Iterable<Contract> findAllByEndDateBefore(LocalDate beforeEndDate) {
        return contractRepository.findAllByEndDateBefore(beforeEndDate);
    }

    @Override
    public Iterable<Contract> findAllByEndDateAfter(LocalDate afterEndDate) {
        return contractRepository.findAllByEndDateAfter(afterEndDate);
    }

    @Override
    public Iterable<Contract> findAllByStatus(Status status) {
        return contractRepository.findAllByStatus(status);
    }

    @Override
    public Iterable<Contract> findAllByCustomer(Customer customer) {
        return contractRepository.findAllByCustomer(customer);
    }

    @Override
    public Iterable<Contract> findAllByCustomerAndUser(Customer customer, User user) {
        return contractRepository.findAllByCustomerAndUser(customer, user);
    }

    @Override
    public Iterable<Contract> findAllByUser(User user) {
        return contractRepository.findAllByUser(user);
    }

    @Override
    public void saveContract(Contract contract) {
        customerRepository.save(customerRepository.findAll());
        userRepository.save(userRepository.findAll());
        contractRepository.save(contract);
    }

}
