package crm.service;

import crm.entity.Category;
import crm.entity.Customer;

import java.util.Set;

/**
 * NOTICE
 * <p>
 * When some declaration
 * does NOT HAVE Enabled param
 * searching works for ALL customers
 * also for NOT enabled (inactive) ones
 */

public interface CustomerService {

    Long getMaxId();

    Iterable<Customer> listAllCustomers();

    Customer showCustomer(Long id);

    Iterable<Customer> findAllByEnabledTrue();
    Iterable<Customer> findAllByEnabledFalse();

    Customer findOneByEnabledTrueAndName(String name);
    Customer findOneByEnabledFalseAndName(String name);
    Customer findOneByName(String name);

    Iterable<Customer> findByEnabledTrueAndEmail(String email);
    Iterable<Customer> findByEnabledFalseAndEmail(String email);
    Iterable<Customer> findByEmail(String email);

    Iterable<Customer> findByEnabledTrueAndPhone(int phone);
    Iterable<Customer> findByEnabledFalseAndPhone(int phone);
    Iterable<Customer> findByPhone(int phone);

    Iterable<Customer> findByEnabledTrueAndCategories(Set<Category> category);
    Iterable<Customer> findByEnabledFalseAndCategories(Set<Category> category);
    Iterable<Customer> findByCategories(Set<Category> category);

    Iterable<Customer> findByEnabledTrueAndFirstName(String firstName);
    Iterable<Customer> findByEnabledFalseAndFirstName(String firstName);
    Iterable<Customer> findByFirstName(String firstName);

    Iterable<Customer> findByEnabledTrueAndLastName(String lastName);
    Iterable<Customer> findByEnabledFalseAndLastName(String lastName);
    Iterable<Customer> findByLastName(String lastName);

    Iterable<Customer> findByEnabledTrueAndFirstNameAndLastName(String firstName, String lastName);
    Iterable<Customer> findByEnabledFalseAndFirstNameAndLastName(String firstName, String lastName);
    Iterable<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Customer> findByEnabledTrueAndCity(String city);
    Iterable<Customer> findByEnabledFalseAndCity(String city);
    Iterable<Customer> findByCity(String city);

    Iterable<Customer> findByEnabledTrueAndCityAndAddress(String city, String address);
    Iterable<Customer> findByEnabledFalseAndCityAndAddress(String city, String address);
    Iterable<Customer> findByCityAndAddress(String city, String address);

    void saveCustomer(Customer customer);
//
//    void editCustomer(Customer customer);
//
//    void deleteCustomer(Customer customer);

}
