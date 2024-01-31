package rvt;

import java.util.Arrays;
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

        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        Sorter.sort(numbers);

        modelAndView.addObject("result", "Result: " + Arrays.toString(numbers));
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView registerPage(){

        ModelAndView modelAndView = new ModelAndView("registration");

        return modelAndView;
    }
}
