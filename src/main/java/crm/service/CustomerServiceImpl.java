package crm.service;

import crm.entity.Customer;
import crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer showCustomer(Long id) {
        return customerRepository.findOne(id);
    }

//    @Override
//    public Iterable<Customer> findByEnabledTrue() {
//        return customerRepository.findByEnabledTrue();
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalse() {
//        return customerRepository.findByEnabledFalse();
//    }
//
//    @Override
//    public Customer findByEnabledTrueAndName(String name) {
//        return customerRepository.findByEnabledTrueAndName(name);
//    }
//
//    @Override
//    public Customer findByEnabledFalseAndName(String name) {
//        return customerRepository.findByEnabledFalseAndName(name);
//    }
//
//    @Override
//    public Customer findByName(String name) {
//        return customerRepository.findByName(name);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledTrueAndCategories(Set<Category> category) {
//        return customerRepository.findByEnabledTrueAndCategories(category);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalseAndCategories(Set<Category> category) {
//        return customerRepository.findByEnabledFalseAndCategories(category);
//    }
//
//    @Override
//    public Iterable<Customer> findByCategories(Set<Category> category) {
//        return customerRepository.findByCategories(category);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledTrueAndCategoryName(String categoryName) {
//        return customerRepository.findByEnabledTrueAndCategoryName(categoryName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalseAndCategoryName(String categoryName) {
//        return customerRepository.findByEnabledFalseAndCategoryName(categoryName);
//    }
//
//    @Override
//    public Iterable<Customer> findByCategoryName(String categoryName) {
//        return customerRepository.findByCategoryName(categoryName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledTrueAndFirstName(String firstName) {
//        return customerRepository.findByEnabledTrueAndFirstName(firstName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalseAndFirstName(String firstName) {
//        return customerRepository.findByEnabledFalseAndFirstName(firstName);
//    }
//
//    @Override
//    public Iterable<Customer> findByFirstName(String firstName) {
//        return customerRepository.findByFirstName(firstName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledTrueAndLastName(String lastName) {
//        return customerRepository.findByEnabledTrueAndLastName(lastName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalseAndLastName(String lastName) {
//        return customerRepository.findByEnabledFalseAndLastName(lastName);
//    }
//
//    @Override
//    public Iterable<Customer> findByLastName(String lastName) {
//        return customerRepository.findByLastName(lastName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledTrueAndFirstNameAndLastName(String firstName, String lastName) {
//        return customerRepository.findByEnabledTrueAndFirstNameAndLastName(firstName, lastName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalseAndFirstNameAndLastName(String firstName, String lastName) {
//        return customerRepository.findByEnabledFalseAndFirstNameAndLastName(firstName, lastName);
//    }
//
//    @Override
//    public Iterable<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
//        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledTrueAndCity(String city) {
//        return customerRepository.findByEnabledTrueAndCity(city);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalseAndCity(String city) {
//        return customerRepository.findByEnabledFalseAndCity(city);
//    }
//
//    @Override
//    public Iterable<Customer> findByCity(String city) {
//        return customerRepository.findByCity(city);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledTrueAndCityAndAddress(String city, String address) {
//        return customerRepository.findByEnabledTrueAndCityAndAddress(city, address);
//    }
//
//    @Override
//    public Iterable<Customer> findByEnabledFalseAndCityAndAddress(String city, String address) {
//        return customerRepository.findByEnabledFalseAndCityAndAddress(city, address);
//    }
//
//    @Override
//    public Iterable<Customer> findByCityAndAddress(String city, String address) {
//        return customerRepository.findByCityAndAddress(city, address);
//    }
//
    @Override
    public void saveCustomer(Customer customer) {
        customer.setEnabled(1);
        customerRepository.save(customer);
    }
//
    @Override
    public void editCustomer(Customer customer) {
        customerRepository.save(customer);
    }
//
//    @Override
//    public void deleteCustomer(Customer customer) {
//        customer.setEnabled(0);
//        customerRepository.save(customer);
//    }

}
