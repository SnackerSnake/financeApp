package com.example.financeapp.controller;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String viewHomePage(Model model){
        User user = new User();
        model.addAttribute("listUser", userService.getAllUsers());
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/EmployeeScreen")
    public String showEmployeeScreen(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "EmployeeScreen";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "SignUp";
    }

    @GetMapping("/showLoaneeData")
    public String showLoaneeData(Model model){
        List<User> userList = userService.getAllUsers();
        ArrayList<User> customers = new ArrayList<User>();
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getUserType().equals("customer")){
                customers.add(userList.get(i));
            }
        }
        model.addAttribute("customerList", customers);

        return "LoaneeDataView";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField,sortDir);
        List<User> listUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reserveSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsers", listUsers);

        return "index";


    }
}
