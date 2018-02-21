package crm.controller;

import crm.entity.Customer;
import crm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * /customer/list
     * <p>
     * Shows all customers
     *
     * @param model model to add attributes to
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
     * @param model model to add attributes to
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
     * @param model model to add attributes to
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
     * @param model model to add attributes to
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

    /**
     * /customer/name-search
     * <p>
     * Shows form to search customer by name
     *
     * @param model model to add attributes to
     * @return customer/name-search
     */
    @GetMapping("/name-search")
    public String showNameSearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/name-search";
    }

    /**
     * /customer/name-search
     * <p>
     * Processes request searching by name
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-one
     */
    @PostMapping("/name-search")
    public String processRequestNameSearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customerService.findOneByEnabledTrueAndName(customer.getName()));
        return "customer/show-one";
    }

    /**
     * /customer/email-search
     * <p>
     * Shows form to search customer by email
     *
     * @param model model to add attributes to
     * @return customer/email-search
     */
    @GetMapping("/email-search")
    public String showEmailSearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/email-search";
    }

    /**
     * /customer/email-search
     * <p>
     * Processes request searching by city
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-list
     */
    @PostMapping("/email-search")
    public String processRequestEmailSearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers", customerService.findByEnabledTrueAndEmail(customer.getEmail()));
        return "customer/show-list";
    }

    /**
     * /customer/phone-search
     * <p>
     * Shows form to search customer by phone
     *
     * @param model model to add attributes to
     * @return customer/phone-search
     */
    @GetMapping("/phone-search")
    public String showPhoneSearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/phone-search";
    }

    /**
     * /customer/phone-search
     * <p>
     * Processes request searching by phone
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-list
     */
    @PostMapping("/phone-search")
    public String processRequestPhoneSearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers", customerService.findByEnabledTrueAndPhone(customer.getPhone()));
        return "customer/show-list";
    }

    /**
     * /customer/first-name-search
     * <p>
     * Shows form to search customer by first name
     *
     * @param model model to add attributes to
     * @return customer/first-name-search
     */
    @GetMapping("/first-name-search")
    public String showFirstNameSearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/first-name-search";
    }

    /**
     * /customer/first-name-search
     * <p>
     * Processes request searching by first name
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-list
     */
    @PostMapping("/first-name-search")
    public String processRequestFirstNameSearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers", customerService.findByEnabledTrueAndFirstName(customer.getFirstName()));
        return "customer/show-list";
    }

    /**
     * /customer/last-name-search
     * <p>
     * Shows form to search customer by last name
     *
     * @param model model to add attributes to
     * @return customer/last-name-search
     */
    @GetMapping("/last-name-search")
    public String showLastNameSearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/last-name-search";
    }

    /**
     * /customer/last-name-search
     * <p>
     * Processes request searching by last name
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-list
     */
    @PostMapping("/last-name-search")
    public String processRequestLastNameSearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers", customerService.findByEnabledTrueAndLastName(customer.getLastName()));
        return "customer/show-list";
    }

    /**
     * /customer/first-name-last-name-search
     * <p>
     * Shows form to search customer by first name and last name
     *
     * @param model model to add attributes to
     * @return customer/first-name-last-name-search
     */
    @GetMapping("/first-name-last-name-search")
    public String showFirstNameLastNameSearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/first-name-last-name-search";
    }

    /**
     * /customer/first-name-last-name-search
     * <p>
     * Processes request searching by first name and last name
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-list
     */
    @PostMapping("/first-name-last-name-search")
    public String processRequestFirstNameLastNameSearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers",
                customerService.findByEnabledTrueAndFirstNameAndLastName(customer.getFirstName(), customer.getLastName()));
        return "customer/show-list";
    }

    /**
     * /customer/city-search
     * <p>
     * Shows form to search customer by city
     *
     * @param model model to add attributes to
     * @return customer/city-search
     */
    @GetMapping("/city-search")
    public String showCitySearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/city-search";
    }

    /**
     * /customer/city-search
     * <p>
     * Processes request searching by city
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-list
     */
    @PostMapping("/city-search")
    public String processRequestCitySearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers", customerService.findByEnabledTrueAndCity(customer.getCity()));
        return "customer/show-list";
    }

    /**
     * /customer/city-address-search
     * <p>
     * Shows form to search customer by city and address
     *
     * @param model model to add attributes to
     * @return customer/city-address-search
     */
    @GetMapping("/city-address-search")
    public String showCityAddressSearchForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/city-address-search";
    }

    /**
     * /customer/city-address-search
     * <p>
     * Processes request searching by city and address
     *
     * @param customer variable type Customer
     * @param model    model to add attributes to
     * @return customer/show-list
     */
    @PostMapping("/city-address-search")
    public String processRequestCityAddressSearch(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customers",
                customerService.findByEnabledTrueAndCityAndAddress(customer.getCity(), customer.getAddress()));
        return "customer/show-list";
    }

}
