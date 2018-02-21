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
 * does NOT HAVE Enabled param
 * searching works for ALL customers
 * also for NOT enabled (inactive) ones
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select max(id) from crm.customer", nativeQuery = true)
    Long getMaxId();

    Iterable<Customer> findAllByEnabled(int enabled);

    Customer findOneByEnabledAndName(int enabled, String name);
    Customer findOneByName(String name);

    Iterable<Customer> findByEnabledAndEmail(int enabled, String email);
    Iterable<Customer> findByEmail(String email);

    Iterable<Customer> findByEnabledAndCity(int enabled, String city);
    Iterable<Customer> findByCity(String city);

    Iterable<Customer> findByEnabledAndCityAndAddress(int enabled, String city, String address);
    Iterable<Customer> findByCityAndAddress(String city, String address);

    Iterable<Customer> findByEnabledAndPhone(int enabled, int phone);
    Iterable<Customer> findByPhone(int phone);

    Iterable<Customer> findByEnabledAndFirstName(int enabled, String firstName);
    Iterable<Customer> findByFirstName(String firstName);

    Iterable<Customer> findByEnabledAndLastName(int enabled, String lastName);
    Iterable<Customer> findByLastName(String lastName);

    Iterable<Customer> findByEnabledAndFirstNameAndLastName(int enabled, String firstName, String lastName);
    Iterable<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Customer> findByEnabledAndCategories(int enabled, Set<Category> category);
    Iterable<Customer> findByCategories(Set<Category> category);

}
