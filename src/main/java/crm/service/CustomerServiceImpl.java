package crm.service;

import crm.entity.Category;
import crm.entity.Customer;
import crm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Long getMaxId() {
        return customerRepository.getMaxId();
    }

    @Override
    public Iterable<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer showCustomer(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Iterable<Customer> findAllByEnabledTrue() {
        return customerRepository.findAllByEnabled(1);
    }

    @Override
    public Iterable<Customer> findAllByEnabledFalse() {
        return customerRepository.findAllByEnabled(0);
    }

    @Override
    public Customer findOneByEnabledTrueAndName(String name) {
        return customerRepository.findOneByEnabledAndName(1, name);
    }

    @Override
    public Customer findOneByEnabledFalseAndName(String name) {
        return customerRepository.findOneByEnabledAndName(0, name);
    }

    @Override
    public Customer findOneByName(String name) {
        return customerRepository.findOneByName(name);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndEmail(String email) {
        return customerRepository.findByEnabledAndEmail(1, email);
    }

    @Override
    public Iterable<Customer> findByEnabledFalseAndEmail(String email) {
        return customerRepository.findByEnabledAndEmail(0, email);
    }

    @Override
    public Iterable<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndPhone(int phone) {
        return customerRepository.findByEnabledAndPhone(1, phone);
    }

    @Override
    public Iterable<Customer> findByEnabledFalseAndPhone(int phone) {
        return customerRepository.findByEnabledAndPhone(0, phone);
    }

    @Override
    public Iterable<Customer> findByPhone(int phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndCategories(Set<Category> category) {
        return customerRepository.findByEnabledAndCategories(1, category);
    }
//
    @Override
    public Iterable<Customer> findByEnabledFalseAndCategories(Set<Category> category) {
        return customerRepository.findByEnabledAndCategories(0, category);
    }

    @Override
    public Iterable<Customer> findByCategories(Set<Category> category) {
        return customerRepository.findByCategories(category);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndFirstName(String firstName) {
        return customerRepository.findByEnabledAndFirstName(1, firstName);
    }

    @Override
    public Iterable<Customer> findByEnabledFalseAndFirstName(String firstName) {
        return customerRepository.findByEnabledAndFirstName(0, firstName);
    }

    @Override
    public Iterable<Customer> findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndLastName(String lastName) {
        return customerRepository.findByEnabledAndLastName(1, lastName);
    }

    @Override
    public Iterable<Customer> findByEnabledFalseAndLastName(String lastName) {
        return customerRepository.findByEnabledAndLastName(0, lastName);
    }

    @Override
    public Iterable<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByEnabledAndFirstNameAndLastName(1, firstName, lastName);
    }

    @Override
    public Iterable<Customer> findByEnabledFalseAndFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByEnabledAndFirstNameAndLastName(0, firstName, lastName);
    }

    @Override
    public Iterable<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndCity(String city) {
        return customerRepository.findByEnabledAndCity(1, city);
    }

    @Override
    public Iterable<Customer> findByEnabledFalseAndCity(String city) {
        return customerRepository.findByEnabledAndCity(0, city);
    }

    @Override
    public Iterable<Customer> findByCity(String city) {
        return customerRepository.findByCity(city);
    }

    @Override
    public Iterable<Customer> findByEnabledTrueAndCityAndAddress(String city, String address) {
        return customerRepository.findByEnabledAndCityAndAddress(1, city, address);
    }

    @Override
    public Iterable<Customer> findByEnabledFalseAndCityAndAddress(String city, String address) {
        return customerRepository.findByEnabledAndCityAndAddress(0, city, address);
    }

    @Override
    public Iterable<Customer> findByCityAndAddress(String city, String address) {
        return customerRepository.findByCityAndAddress(city, address);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customer.setEnabled(1);
        customerRepository.save(customer);
    }
//
//    @Override
//    public void editCustomer(Customer customer) {
//        customerRepository.save(customer);
//    }
//
//    @Override
//    public void deleteCustomer(Customer customer) {
//        customer.setEnabled(0);
//        customerRepository.save(customer);
//    }

}
