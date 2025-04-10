package org.lessons.spring.spring_la_mia_pizzeria_crud.controllers;

import java.util.List;

import org.lessons.spring.spring_la_mia_pizzeria_crud.models.Pizza;
import org.lessons.spring.spring_la_mia_pizzeria_crud.repository.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/menu")
public class PizzaController {

    @Autowired
    private PizzaRepo repo;

    @GetMapping
    public String index(
            @RequestParam(name = "query", required = false) String query,
            Model model,
            HttpServletRequest request) {
        List<Pizza> pizzas;
        if (query != null && !query.isEmpty()) {
            pizzas = repo.findByNameContainingOrDescriptionContaining(query, query);
        } else {
            pizzas = repo.findAll(); // Select * from pizzas
        }

        model.addAttribute("currentUri", request.getRequestURI());
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        Pizza pizza = repo.findById(id).get();
        model.addAttribute("pizza", pizza);
        model.addAttribute("currentUri", request.getRequestURI());

        return "pizzas/details";
    }

    // @GetMapping("/searchByNameOrDescription")
    // public String findByTitleOrAuthor(@RequestParam(name = "query") String query, Model model) {

    //     List<Pizza> pizzas = repo.findByNameContainingOrDescriptionContaining(query, query);
    //     model.addAttribute("pizzas", pizzas);
    //     return "pizzas/index";
    // }

}
