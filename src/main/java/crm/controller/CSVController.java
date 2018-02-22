package crm.controller;

import crm.entity.Customer;
import crm.service.CustomerService;
import crm.utils.WriteCsvToResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class CSVController {

    private CustomerService customerService;

    public CSVController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customers", produces = "text/csv")
    public void findCustomers(HttpServletResponse httpServletResponse) throws IOException {
        List<Customer> customers = (List<Customer>) customerService.listAllCustomers();
        WriteCsvToResponse.writeCustomers(httpServletResponse.getWriter(), customers);
    }

    @GetMapping(value = "/customers/{id}", produces = "text/csv")
    public void findCustomer(@PathVariable Long id, HttpServletResponse httpServletResponse) throws IOException {
        Customer customer = customerService.showCustomer(id);
        WriteCsvToResponse.writeCustomer(httpServletResponse.getWriter(), customer);
    }

//    @GetMapping("/show-import")
//    public String showImportCsvSite() {
//        return "csv/import";
//    }

    /*@GetMapping("/import")
    public String processRequestImportCsv(Model model) {
        File document = ReadDataUtils.ReadFile("Select CSV file", null, "Only CSV Files", "csv");
//        System.out.println(document.getName());

            CSVReader reader;
            List<String[]> data = new ArrayList<>();
            try {
                reader = new CSVReader(new FileReader(document));
                String[] line;
                while ((line = reader.readNext()) != null) {
//                    System.out.println(line[1] + "\t" + line[2]);
                    data.add(line);
//                    if(line[1].equals("QUICK SUB")){
//                        System.out.println(line[0] + "\t" + line[1] + "\t" + line[2]);
//                    }
                }
                model.addAttribute("data", data);
            } catch (IOException e) {
                e.printStackTrace();
            }
		*//*System.out.println(data.get(0)[1] + "\t" + data.get(0)[2]);
		System.out.println(data.get(1)[1] + "\t" + data.get(1)[2]);*//*

        return "csv/show";
    }*/

//    @GetMapping("/show")
//    public String showPageWithCsvImported(@ModelAttribute List<String[]> data) {
//        data.
//        return "csv/show";
//    }

}
