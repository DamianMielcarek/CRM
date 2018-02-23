package crm.controller;

import crm.entity.Contract;
import crm.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }
    @GetMapping("/list")
    public String showAllContracts(Model model) {
        model.addAttribute("contracts", contractService.listAllContracts());
        return "contract/list";
    }

    @GetMapping("/add")
    public String showFormAddContract(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/add";
    }

    @PostMapping("/add")
    public String processRequestAddContract(@Valid Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/contract/add";
        } else {
            contractService.saveContract(contract);
            return "contract/success";
        }
    }

}
