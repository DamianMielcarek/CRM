package crm.repository;

import crm.entity.Category;
import crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * NOTICE
 * <p>
 * When some declaration
 * does NOT HAVE EnabledTrue param
 * searching works for ALL customers
 * also for NOT enabled (inactive) ones
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Iterable<Customer> findByEnabledTrue();

    Iterable<Customer> findByEnabledFalse();

    Customer findByEnabledTrueAndName(String name);
    Customer findByEnabledFalseAndName(String name);
    Customer findByName(String name);

    Iterable<Customer> findByEnabledTrueAndCategories(Set<Category> category);
    Iterable<Customer> findByEnabledFalseAndCategories(Set<Category> category);
    Iterable<Customer> findByCategories(Set<Category> category);

    @Query("select c from Customer c where c.categories.name like ?1% and c.enabled = true")
    Iterable<Customer> findByEnabledTrueAndCategoryName(String categoryName);
    @Query("select c from Customer c where c.categories.name like ?1% and c.enabled = false")
    Iterable<Customer> findByEnabledFalseAndCategoryName(String categoryName);
    @Query("select c from Customer c where c.categories.name like ?1%")
    Iterable<Customer> findByCategoryName(String categoryName);

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

}
