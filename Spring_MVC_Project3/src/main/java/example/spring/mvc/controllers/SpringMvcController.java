package example.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import example.spring.mvc.model.User;
import example.spring.mvc.model.UserValidator;

@Controller // this is class as controller
@SessionAttributes("validUser")
public class SpringMvcController {
	@RequestMapping("/greet")

	// this marks as method as req. handler method
	public String getIndexPage() {
//this method gets invoke when client rquest for the resourse with url:/greet
		return "index";
	}

	@RequestMapping("/showlogin")
	public String getLoginPage() {
		return "login";
	}

//this URL for post Request 
	@RequestMapping(
	value = "/doValidate", method = RequestMethod.POST)
	public String dovalidateUser(
			@RequestParam("user_name") String uid, 
			@RequestParam("user_password") String pwd )
	{
     User userObj= new User(uid, pwd);
    boolean valid= UserValidator.isValid(userObj);
     String resultPage="failure";
     if(valid)
    	 resultPage="success";
     return resultPage;
	}
	@RequestMapping(
			value = "/doValidateAgain", method = RequestMethod.POST)
			public String dovalidateUserAgain(
					@RequestParam("user_name") String uid, 
					@RequestParam("user_password") String pwd,
					Model datamodel 
					)
			{
		     User userObj= new User(uid, pwd);
		    boolean valid= UserValidator.isValid(userObj);
		     String resultPage="failure";
		     if(valid)
		     {
		    	 resultPage="successAgain";
		         datamodel.addAttribute("validUser", uid);
			}
		     return resultPage;
}
	}
