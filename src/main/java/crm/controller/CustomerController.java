package crm.controller;

import crm.entity.Customer;
import crm.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * /customer/list
     * <p>
     * Shows all customers
     *
     * @param model model to attributes to
     * @return customer/list
     */
    @GetMapping("/list")
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customer/list";
    }

    /**
     * /customer/add
     * <p>
     * Shows add customer form
     *
     * @param model model to attributes to
     * @return customer/add
     */
    @GetMapping("/add")
    public String showFormAddCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }

    /**
     * /customer/add
     * <p>
     * Processes add customer request
     *
     * @param customer      variable type Customer
     * @param bindingResult variable type BindingResult
     * @return customer/success
     */
    @PostMapping("/add")
    public String processRequestAddCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/customer/add";
        } else {
            customerService.saveCustomer(customer);
            return "customer/success";
        }
    }

    /**
     * /customer/edit/{id}
     * <p>
     * Shows edit customer form
     *
     * @param model model to attributes to
     * @param id    variable type long customer id
     * @return customer/edit
     */
    @GetMapping("/edit/{id}")
    public String showFormEditCustomer(Model model, @PathVariable Long id) {
        model.addAttribute("customer", customerService.showCustomer(id));
        return "customer/edit";
    }

    /**
     * /customer/edit/{id}
     * <p>
     * Processes edit customer request
     *
     * @param id            variable type long customer id
     * @param customer      variable type Customer
     * @param bindingResult variable type BindingResult
     * @return redirect:/customer/list
     */
    @PostMapping("/edit/{id}")
    public String processRequestEditCustomer(@PathVariable Long id, @Valid Customer customer,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/customer/edit/" + id;
        } else {
            customerService.saveCustomer(customer);
            return "redirect:/customer/list";
        }
    }

    /**
     * /customer/addCustomerBasedOnAnotherOne/{id}
     * <p>
     * Shows create-customer-based-on-another-one form
     *
     * @param model model to attributes to
     * @param id    variable type long reference customer id
     * @return customer/add-customer-based-on-another-one
     */
    @GetMapping("/addCustomerBasedOnAnotherOne/{id}")
    public String showFormCreateCustomerBasedOnAnotherOne(Model model, @PathVariable Long id) {
        model.addAttribute("customer", customerService.showCustomer(id));
        return "customer/add-customer-based-on-another-one";
    }

    /**
     * /customer/addCustomerBasedOnAnotherOne/{id}
     * <p>
     * Creates customer based on another one
     *
     * @param id            variable type long reference customer id
     * @param customer      variable type Customer
     * @param bindingResult variable type BindingResult
     * @return redirect:/customer/list
     */
    @PostMapping("/addCustomerBasedOnAnotherOne/{id}")
    public String createCustomerBasedOnAnotherOne(@PathVariable Long id, @Valid Customer customer,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/customer/addCustomerBasedOnAnotherOne/" + id;
        } else {
            Customer newCustomer = new Customer(
                    customerService.getMaxId() + 1L,
                    customer.getName(),
                    customer.getEmail(),
                    customer.getPhone(),
                    customer.getCategories(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getCity(),
                    customer.getAddress(),
                    customer.getEnabled());
            customerService.saveCustomer(newCustomer);
            return "redirect:/customer/list";
        }
    }

}
