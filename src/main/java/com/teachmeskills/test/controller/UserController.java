package com.teachmeskills.test.controller;

import com.teachmeskills.test.entity.dto.UserRegistrationDto;
import com.teachmeskills.test.entity.dto.UserUpdateDto;
import com.teachmeskills.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String view(Model model){
        model.addAttribute("user_reg", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute("user_reg") UserRegistrationDto userRegistrationDto){
        userService.save(userRegistrationDto);
        return "registration";
    }

    @GetMapping("/getall")
    public String getall(Model model){
        model.addAttribute("users", userService.getAll());
        return "home";
    }

    @GetMapping("/update")
    public String update(Model model){
        model.addAttribute("user_update", new UserUpdateDto());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user_update") UserUpdateDto userUpdateDto){
        userService.merge(userUpdateDto);
        return "update";
    }

    @GetMapping("/update/address")
    public String updateAddress(){
        return "updateAddress";
    }

    @PostMapping("/update/address")
    public String updateAddress(long id, String street, int home){
        userService.mergeAddress(id, street, home);
        return "updateAddress";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        userService.delete(id);
        return "delete";
    }
}
