package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Customer;
import com.springapp.mvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssvh on 3/4/16.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String ListCustomers(Model model)
    {
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomer", this.customerRepository.findAll());
        return "customer";
    }

    @RequestMapping(value= "/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer){

        if(customer.getId() == 0){
            //new customer, add it
            this.customerRepository.save(customer);
        }else{
            //existing customer, call update
            this.customerRepository.save(customer);
        }

        return "redirect:/customers";

    }

    @RequestMapping("/customer/remove/{id}")
    public String removeCustomer(@PathVariable("id") Long id){

        this.customerRepository.delete(id);
        return "redirect:/customers";
    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model){
       // model.addAttribute("customer", this.customerRepository.getCustomer(id));
        //model.addAttribute("listCustomer", this.customerRepository.listCustomer());
        return "customer";
    }


}
