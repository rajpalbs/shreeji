package com.finanace.shreeji.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.model.Branch;
import com.finanace.shreeji.model.Employee;
import com.finanace.shreeji.model.OldUser;
import com.finanace.shreeji.model.Role.RoleType;
import com.finanace.shreeji.repository.BranchRepository;
import com.finanace.shreeji.repository.EmployeeRepository;
import com.finanace.shreeji.repository.RoleRepository;
import com.finanace.shreeji.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BranchRepository branchRepository; 

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = new Employee();
		modelAndView.addObject("employee", employee);
		List<Branch> branches = new ArrayList<>();
		
		Branch b1 = new Branch();
		b1.setId(UUID.fromString("0aa92a4e-489a-11e8-bdd0-c0cb3804b36b"));
		b1.setName("Modasa Main");
		b1.setCity("Modasa");
		branches.add(b1);
		
		b1 = new Branch();
		b1.setId(UUID.fromString("0aaff49b-489a-11e8-bdd0-c0cb3804b36b"));
		b1.setName("Meghraj Main");
		b1.setCity("Meghraj");
		branches.add(b1); 
		
		modelAndView.addObject("branches", branches);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Employee employee, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		employee.setStatus(1);
		employee.setRole(roleRepository.findByName(RoleType.ADMIN));
		employee.setBranch(branchRepository.findOne(employee.getBranch().getId()));
		employeeRepository.save(employee);
		/*OldUser userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new OldUser());
			modelAndView.setViewName("registration");

		}*/
		
		employee = new Employee();
		modelAndView.addObject("employee", employee);
		List<Branch> branches = new ArrayList<>();
		
		Branch b1 = new Branch();
		b1.setId(UUID.randomUUID());
		b1.setName("Modasa Main");
		b1.setCity("Modasa");
		branches.add(b1);
		
		b1 = new Branch();
		b1.setId(UUID.randomUUID());
		b1.setName("Meghraj Main");
		b1.setCity("Meghraj");
		branches.add(b1); 
		
		modelAndView.addObject("branches", branches);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		OldUser user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

}
