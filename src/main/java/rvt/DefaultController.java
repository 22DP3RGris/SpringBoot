package rvt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    
    @GetMapping(value = "/")
    ModelAndView index(@RequestParam(name="name", required=false, defaultValue="null") String name) {
        Money a = new Money(3, 80);
        Money b = new Money(3, 0);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result", a.plus(b));
        return modelAndView;
    }

    @GetMapping(value = "/about")
    ModelAndView about(@RequestParam HashMap<String, String> allParams){
        ModelAndView modelAndView = new ModelAndView("about");

        System.out.println(allParams.get("id"));
        System.out.println(allParams.get("title"));
        System.out.println(allParams.get("description"));
        
        return modelAndView;
    }
}
