package owasp.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    
    @Autowired
    private HttpSession session;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        if (session.getAttribute("name") != null) {
            model.addAttribute("username", session.getAttribute("name"));
        } else {
            return "redirect:/";
        }
        return "index";
    }
    
}
