package owasp.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import owasp.dao.AccountDao;
import owasp.dao.NewsDao;
import owasp.domain.Account;

@Controller
public class NewsController {
    
    @Autowired
    private NewsDao newsDao;
    
    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private HttpSession session;
    
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getNews(Model model) {
        model.addAttribute("news", newsDao.getNews());
        return "news";
    }
    
    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public String postNews(@RequestParam String content) {
        newsDao.insert(content, accountDao.getAccountByUsername((String) session.getAttribute("name")));
        return "redirect:/index";
    }
    
}
