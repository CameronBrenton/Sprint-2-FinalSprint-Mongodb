package com.example.sprintmongo.controller;

import com.example.sprintmongo.model.Animal;
import com.example.sprintmongo.model.Search;
import com.example.sprintmongo.model.User;
import com.example.sprintmongo.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private AnimalRepo animalRepository;

    // Get Mappings
    @GetMapping(path = "/signin")
    public String getLogInPage() {

        return "logIn";
    }

    @GetMapping(path = "/signout")
    public String getLogOutPage() {
        return "logout";
    }


    // Search MongoDB
    @GetMapping(path = "/searchMongoDB")
    public String redirectToSearchFormMongo(ModelMap model) {
        Search search = new Search();
        model.addAttribute("search", search);
        model.addAttribute("attribute", "redirectToSearchFormMongo");
        //List<String> databaseList = Arrays.asList("PgAdmin(SQL)", "MongoDB(NoSQL)", "Both");
        //model.addAttribute("databaseList", databaseList);
        return "search";
    }

    @PostMapping(path = "/search")
    public String submitSearchFormMongoDB(@ModelAttribute("search")Search search, Model model) {
        List<Animal> listAnimals = new ArrayList<Animal>();
        animalRepository.findByAnimalName(search.getTopic()).forEach(listAnimals::add);
        model.addAttribute("listAnimals", listAnimals);
        System.out.println("#######" + listAnimals);
        return "search_results";
    }

    // Signup
    @GetMapping(path = "/signup")
    public String showSignupForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping(path = "/signup")
    public String submitSignupForm(@ModelAttribute("user")User user) {
        System.out.println(user);
        return "signup_success";
    }
}
