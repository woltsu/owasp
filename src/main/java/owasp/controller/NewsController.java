package owasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import owasp.dao.NewsDao;

@Controller
public class NewsController {
    
    @Autowired
    private NewsDao newsDao;
    
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getNews(Model model) {
        model.addAttribute("news", newsDao.getNews());
        return "news";
    }
    
    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public String postNews(@RequestParam String content) {
        newsDao.insert(content);
        return "redirect:/index";
    }
    
}
