package crm.controller;

import crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Export {

    @Autowired
    UserService userService;

    /**
     * Handle request to download an Excel document
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        return "";
    }

}
