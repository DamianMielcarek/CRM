package crm.controller;

import crm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Export {

    private UserService userService;

    public Export(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handle request to download an Excel document
     */
    @GetMapping("/download")
    public String download(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        return "";
    }

}
