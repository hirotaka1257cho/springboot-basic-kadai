package com.example.springkadaiform.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	
	@GetMapping("/form")
    public String showForm(ContactForm contactForm) {
		
		// すでにインスタンスが存在する場合は行わない
        if (!model.containsAttribute("contactForm")) {
            // ビューにフォームクラスのインスタンスを渡す
            model.addAttribute("contactForm", new ContactForm());
        }
        
        
		System.out.println("=========コントローラー 動作");
        return "contactFormView";
    }
	
	
	
	@PostMapping("/confirm")
    public String confirmForm(@Validated @ModelAttribute ContactForm contactForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "contactFormView";
        }
        model.addAttribute("contactForm", contactForm);
        return "confirmView";
    }
	
}

