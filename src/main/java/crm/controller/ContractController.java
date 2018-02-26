package crm.controller;

import crm.entity.Contract;
import crm.entity.Customer;
import crm.entity.User;
import crm.service.ContractService;
import crm.service.CustomerService;
import crm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private ContractService contractService;

    private CustomerService customerService;

    private UserService userService;

    public ContractController(ContractService contractService, CustomerService customerService, UserService userService) {
        this.contractService = contractService;
        this.customerService = customerService;
        this.userService = userService;
    }

    /**
     * /contract/list
     * <p>
     * Shows all contracts
     *
     * @param model model to add attributes to
     * @return contract/list
     */
    @GetMapping("/list")
    public String showAllContracts(Model model) {
        model.addAttribute("contracts", contractService.listAllContracts());
        return "contract/list";
    }

    /**
     * /contract/add
     * <p>
     * Shows add contract form
     *
     * @param model model to add attributes to
     * @return contract/add
     */
    @GetMapping("/add")
    public String showFormAddContract(Model model) {
        Iterable<Customer> customers = customerService.findAllByEnabledTrue();
        Iterable<User> users = userService.listAllUsers();
        model.addAttribute("contract", new Contract());
        model.addAttribute("customers", customers);
        model.addAttribute("users", users);
        return "contract/add";
    }

    /**
     * /contract/add
     * <p>
     * Processes add contract request
     *
     * @param contract      variable type Contract
     * @param bindingResult variable type BindingResult
     * @return contract/success
     */
    @PostMapping("/add")
    public String processRequestAddContract(@Valid Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/contract/add";
        } else {
            contractService.saveContract(contract);
            return "contract/success";
        }
    }

    /**
     * /contract/edit/{id}
     * <p>
     * Shows edit contract form
     *
     * @param model model to add attributes to
     * @param id    variable type long contract id
     * @return contract/edit
     */
    @GetMapping("/edit/{id}")
    public String showFormEditContract(Model model, @PathVariable Long id) {
        model.addAttribute("contract", contractService.showContract(id));
        return "contract/edit";
    }

    /**
     * /contract/edit/{id}
     * <p>
     * Processes edit contract request
     *
     * @param id            variable type long contract id
     * @param contract      variable type Contract
     * @param bindingResult variable type BindingResult
     * @return redirect:/contract/list
     */
    @PostMapping("/edit/{id}")
    public String processRequestEditContract(@PathVariable Long id, @Valid Contract contract,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/contract/edit/" + id;
        } else {
            contractService.saveContract(contract);
            return "redirect:/contract/list";
        }
    }

    /**
     * /contract/name-search
     * <p>
     * Shows form to search contract by name
     *
     * @param model model to add attributes to
     * @return contract/name-search
     */
    @GetMapping("/name-search")
    public String showNameSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/name-search";
    }

    /**
     * /contract/name-search
     * <p>
     * Processes request searching by name
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show
     */
    @PostMapping("/name-search")
    public String processRequestNameSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contract", contractService.findByName(contract.getName()));
        return "contract/show-one";
    }

    /**
     * /contract/value-le-search
     * <p>
     * Shows form to search contract by value less equal than
     *
     * @param model model to add attributes to
     * @return contract/value-le-search
     */
    @GetMapping("/value-le-search")
    public String showValueLeesThanEqualSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/value-le-search";
    }

    /**
     * /contract/value-le-search
     * <p>
     * Processes request searching by value less equal than
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/value-le-search")
    public String processRequestValueLessThanEqualSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByValueLessThanEqual(contract.getValue()));
        return "contract/show-list";
    }

    /**
     * /contract/value-ge-search
     * <p>
     * Shows form to search contract by value greater equal than
     *
     * @param model model to add attributes to
     * @return contract/value-ge-search
     */
    @GetMapping("/value-ge-search")
    public String showValueGreaterThanEqualSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/value-ge-search";
    }

    /**
     * /contract/value-ge-search
     * <p>
     * Processes request searching by value greater equal than
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/value-ge-search")
    public String processRequestValueGreaterThanEqualSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByValueGreaterThanEqual(contract.getValue()));
        return "contract/show-list";
    }

    /**
     * /contract/begin-date-search
     * <p>
     * Shows form to search contract by begin date
     *
     * @param model model to add attributes to
     * @return contract/begin-date-search
     */
    @GetMapping("/begin-date-search")
    public String showBeginDateSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/begin-date-search";
    }

    /**
     * /contract/begin-date-search
     * <p>
     * Processes request searching by begin date
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/begin-date-search")
    public String processRequestBeginDateSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByBeginDate(contract.getBeginDate()));
        return "contract/show-list";
    }

    /**
     * /contract/begin-date-before-search
     * <p>
     * Shows form to search contract by begin date before
     *
     * @param model model to add attributes to
     * @return contract/begin-date-before-search
     */
    @GetMapping("/begin-date-before-search")
    public String showBeginDateBeforeSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/begin-date-before-search";
    }

    /**
     * /contract/begin-date-before-search
     * <p>
     * Processes request searching by begin date before
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/begin-date-before-search")
    public String processRequestBeginDateBeforeSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByBeginDateBefore(contract.getBeginDate()));
        return "contract/show-list";
    }

    /**
     * /contract/begin-date-after-search
     * <p>
     * Shows form to search contract by begin date after
     *
     * @param model model to add attributes to
     * @return contract/begin-date-after-search
     */
    @GetMapping("/begin-date-after-search")
    public String showBeginDateAfterSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/begin-date-after-search";
    }

    /**
     * /contract/begin-date-after-search
     * <p>
     * Processes request searching by begin date after
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/begin-date-after-search")
    public String processRequestBeginDateAfterSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByBeginDateAfter(contract.getBeginDate()));
        return "contract/show-list";
    }

    /**
     * /contract/end-date-search
     * <p>
     * Shows form to search contract by end date
     *
     * @param model model to add attributes to
     * @return contract/end-date-search
     */
    @GetMapping("/end-date-search")
    public String showEndDateSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/end-date-search";
    }

    /**
     * /contract/end-date-search
     * <p>
     * Processes request searching by end date
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/end-date-search")
    public String processRequestEndDateSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByEndDate(contract.getEndDate()));
        return "contract/show-list";
    }

    /**
     * /contract/end-date-before-search
     * <p>
     * Shows form to search contract by end date before
     *
     * @param model model to add attributes to
     * @return contract/end-date-before-search
     */
    @GetMapping("/end-date-before-search")
    public String showEndDateBeforeSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/end-date-before-search";
    }

    /**
     * /contract/end-date-before-search
     * <p>
     * Processes request searching by end date before
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/end-date-before-search")
    public String processRequestEndDateBeforeSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByEndDateBefore(contract.getEndDate()));
        return "contract/show-list";
    }

    /**
     * /contract/end-date-after-search
     * <p>
     * Shows form to search contract by end date after
     *
     * @param model model to add attributes to
     * @return contract/end-date-after-search
     */
    @GetMapping("/end-date-after-search")
    public String showEndDateAfterSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/end-date-after-search";
    }

    /**
     * /contract/end-date-after-search
     * <p>
     * Processes request searching by end date after
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/end-date-after-search")
    public String processRequestEndDateAfterSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByEndDateAfter(contract.getEndDate()));
        return "contract/show-list";
    }

    /**
     * /contract/status-search
     * <p>
     * Shows form to search contract by status
     *
     * @param model model to add attributes to
     * @return contract/status-search
     */
    @GetMapping("/status-search")
    public String showStatusSearchForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/status-search";
    }

    /**
     * /contract/status-search
     * <p>
     * Processes request searching by status
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/status-search")
    public String processRequestStatusSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByStatus(contract.getStatus()));
        return "contract/show-list";
    }

    /**
     * /contract/customer-search
     * <p>
     * Shows form to search contract by customer
     *
     * @param model model to add attributes to
     * @return contract/customer-search
     */
    @GetMapping("/customer-search")
    public String showCustomerSearchForm(Model model) {
        Iterable<Customer> customers = customerService.findAllByEnabledTrue();
        model.addAttribute("contract", new Contract());
        model.addAttribute("customers", customers);
        return "contract/customer-search";
    }

    /**
     * /contract/customer-search
     * <p>
     * Processes request searching by customer
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/customer-search")
    public String processRequestCustomerSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByCustomer(contract.getCustomer()));
        return "contract/show-list";
    }

    /**
     * /contract/customer-user-search
     * <p>
     * Shows form to search contract by customer and user
     *
     * @param model model to add attributes to
     * @return contract/customer-user-search
     */
    @GetMapping("/customer-user-search")
    public String showCustomerUserSearchForm(Model model) {
        Iterable<Customer> customers = customerService.findAllByEnabledTrue();
        Iterable<User> users = userService.listAllUsers();
        model.addAttribute("contract", new Contract());
        model.addAttribute("customers", customers);
        model.addAttribute("users", users);
        return "contract/customer-user-search";
    }

    /**
     * /contract/customer-user-search
     * <p>
     * Processes request searching by customer and user
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/customer-user-search")
    public String processRequestCustomerUserSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByCustomerAndUser(contract.getCustomer(), contract.getUser()));
        return "contract/show-list";
    }

    /**
     * /contract/user-search
     * <p>
     * Shows form to search contract by user
     *
     * @param model model to add attributes to
     * @return contract/user-search
     */
    @GetMapping("/user-search")
    public String showUserSearchForm(Model model) {
        Iterable<User> users = userService.listAllUsers();
        model.addAttribute("contract", new Contract());
        model.addAttribute("users", users);
        return "contract/user-search";
    }

    /**
     * /contract/user-search
     * <p>
     * Processes request searching by user
     *
     * @param contract variable type Contract
     * @param model    model to add attributes to
     * @return contract/show-list
     */
    @PostMapping("/user-search")
    public String processRequestUserSearch(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contracts", contractService.findAllByUser(contract.getUser()));
        return "contract/show-list";
    }

}
