package org.hackathon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hackathon.domain.User;
import org.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin() {
		ModelAndView model = new ModelAndView("login/loginForm");
		User loginBean = new User();
		model.addObject("user", loginBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
		ModelAndView model = null;
		try {
			User loggedInUser = userService.getchUserDetails(user);
			if (loggedInUser!=null) {
				System.out.println("User Login Successful");
				request.setAttribute("user", loggedInUser);
				model = new ModelAndView("welcome");
			} else {
				model = new ModelAndView("login/loginForm");
				model.addObject("user", user);
				request.setAttribute("message", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

}