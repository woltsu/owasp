package owasp.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import owasp.dao.AccountDao;
import owasp.domain.Account;

@Controller
public class DefaultController {

    @Autowired
    private HttpSession session;

    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefault() {
        return "redirect:/news";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password) {
        Account a = accountDao.getAccountByUsername(username);
        if (a != null && a.getPassword().equals(password)) {
            session.setAttribute("name", a.getUsername());
            return "redirect:/index";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        session.removeAttribute("name");
        return "redirect:/login";
    }

}
