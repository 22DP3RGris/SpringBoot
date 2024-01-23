package rvt;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    
    @GetMapping(value = "/")
    ModelAndView index(@RequestParam(name="name", required=false, defaultValue="null") String name) {

        ModelAndView modelAndView = new ModelAndView("index");
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

    @GetMapping(value = "/test")
    ModelAndView testAction(@RequestParam HashMap<String, String> allParams) {

        ModelAndView modelAndView = new ModelAndView("test");

        Money mon1 = new Money(3, (byte) 80);
        Money mon2 = new Money(2);
        Money mon3 = new Money();

        mon3 = mon3.plus(1);
        mon3 = mon3.plus((byte) 20);

        modelAndView.addObject("result", "Result: " + mon1.plus(mon2.plus(mon3)));

        return modelAndView;
    }
}
