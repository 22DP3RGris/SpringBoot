package rvt;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefaultController {

    CsvManager csvManager = new CsvManager("data/user.csv", "data");
    
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

        Employees university = new Employees();
        university.add(new Person("Petrus", Education.PHD));
        university.add(new Person("Arto", Education.HS));
        university.add(new Person("Elina", Education.PHD));

        System.out.println("==");
        university.print();

        university.fire(Education.PHD);

        System.out.println("==");

        university.print();

        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView registerPage(@RequestParam HashMap<String, String> allParams){

        if (allParams.containsKey("success")) {
            ModelAndView modelAndView = new ModelAndView("registration-success");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("registration-page");
        
        User user = new User();

        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String registerForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/registration-page";
        }
        csvManager.objToCsv(user);
        return "redirect:/register?success";
    }
}
