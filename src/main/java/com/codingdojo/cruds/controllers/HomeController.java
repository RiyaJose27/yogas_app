package com.codingdojo.cruds.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.cruds.models.LoginUser;
import com.codingdojo.cruds.models.User;
import com.codingdojo.cruds.models.Yoga;
import com.codingdojo.cruds.services.UserService;
import com.codingdojo.cruds.services.YogaService;

@Controller
public class HomeController {
	
	
	private UserService userServ;
	
	private YogaService yogaServ;
	
	public HomeController(UserService userServ, YogaService yogaServ) {
		this.userServ = userServ;
		this.yogaServ = yogaServ;
	}
	
	
	
        @RequestMapping("/")
        public String index(Model model) {
        	model.addAttribute("newUser", new User());
          	model.addAttribute("newLogin", new LoginUser());
        	return "index.jsp";
        }

        
        
        @PostMapping("/register")
        public String register(@Valid @ModelAttribute("newUser") User newUser,
        		BindingResult result, Model model, HttpSession session) {
        	userServ.register(newUser, result);
        	
        	if(result.hasErrors()) {
        		model.addAttribute("newLogin", new LoginUser());
        		return "index.jsp";
        	}
        	
        	session.setAttribute("user-id", newUser.getId());
        		return "redirect:/";        	
        	
        }
        
        
        
        @PostMapping("/login")
        public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
                BindingResult result, Model model, HttpSession session) {
            
        	
        	User user = userServ.login(newLogin, result);
            if(result.hasErrors()) {
                model.addAttribute("newUser", new User());
                return "index.jsp";
            }
            session.setAttribute("user_id", user.getId());
            return "redirect:/dashboard";
        }
        
        
     
        @RequestMapping("/dashboard")
        public String dashboard(Model model, HttpSession session) {
        	
        	model.addAttribute("allYogas", yogaServ.allYogas());
        	model.addAttribute("user", userServ.oneUser((Long) 
        			session.getAttribute("user_id")));
        
        	return "dashboard.jsp";
        }
        
        
     
        @RequestMapping("/newYoga")
        public String newYoga(@ModelAttribute("yoga")Yoga yoga, Model model , HttpSession session) {
        	
        	
        	Long user_id = (Long)session.getAttribute("user_id");
        	
        	
        	model.addAttribute("user", user_id);
        	
        
        	return "newYoga.jsp";
        	
        }
        
      
        @RequestMapping(value="/makeYoga", method=RequestMethod.POST)
        public String CreatedBy(@Valid @ModelAttribute("yoga") Yoga yoga, 
        		BindingResult result) {
        	if(result.hasErrors()) {
        		return "newYoga.jsp";
        	} else {
        		yogaServ.create(yoga);
        		return "redirect:/dashboard";
        	}
        	
        	
        }
           
        

        
        @RequestMapping("/editYoga/{id}") 
        	public String editCar(@PathVariable("id") Long id, 
        			@ModelAttribute("yoga") Yoga yoga, 
        			Model model, HttpSession session) {
        	Yoga oneYoga = yogaServ.oneYoga(id);
        	model.addAttribute("yoga", oneYoga);
        	
           Long user_id = (Long)session.getAttribute("user_id");
        	
        	model.addAttribute("user", user_id);
        	
        		return "editYoga.jsp";
        	}
        
        
 
        
        
        @RequestMapping(value="/editingYoga/{id}", method=RequestMethod.PUT)
        public String editingYoga(@Valid @ModelAttribute("yoga") Yoga yoga, 
        	 BindingResult result, Model model){
        	if(result.hasErrors()) {
        		
        		return "editYoga.jsp";
        	} else {
        		yogaServ.update(yoga);
        		return "redirect:/dashboard";
        	}
        	
        } 

        

   
       
       @RequestMapping("/oneYoga/{id}") 
       public String oneBook(@PathVariable("id") Long id,
       		Model model,
       		HttpSession session) {
    	   
       	User user = userServ.oneUser((Long) session.getAttribute("user_id"));
       	Long user_id = (Long)session.getAttribute("user_id");
    	
    	model.addAttribute("user", user_id);
       	
       	model.addAttribute("user", user);
       	model.addAttribute("yoga", yogaServ.oneYoga(id));
       	return "oneYoga.jsp";
       }
       
        
       @RequestMapping("/logout")
       public String logout(HttpSession session) {
       	session.invalidate();
       	return "redirect:/";
       	
       }
       
       

       @RequestMapping("/destroy/{id}")
       public String Destroyable(@PathVariable("id") Long id) {
       	yogaServ.destroy(id);
       	return "redirect:/dashboard";
       }
       
       
       
}

        