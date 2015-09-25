package com.tatvasoft.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tatvasoft.dao.UsermasterDAO;
import com.tatvasoft.mail.JavaMail;
import com.tatvasoft.model.Usermaster;
import com.tatvasoft.service.UsermasterService;

@Controller
public class UsermasterController {

	@Autowired
	private UsermasterService usermasterservice;
	
	@Autowired
	private UsermasterDAO usermasterdao1;
	
	private MailSender mailSender;
	private SimpleMailMessage mailMessage;

	
/*
	@Autowired
	private  UserValidator userValidator;
	
	@InitBinder  
    private void initBinder(WebDataBinder binder) {  
        binder.setValidator(userValidator);  
    }  
	*/
	
	@RequestMapping(value="/login")
	public String initialLoading(@ModelAttribute("usermaster")Usermaster usermaster,BindingResult result,HttpSession sessions , HttpServletRequest request) {
		
//		 sessions = request.getSession();
//		String str = (String)sessions.getAttribute("username_s");
//		
//		if(str != null)
//			return "redirect:/listpage";
//		else
			return "home";
	}
	
	
	
	
	
	@RequestMapping(value="/register")
	public String registeruser(@ModelAttribute("umaster")Usermaster umaster){
		
		return "register";
	}
	
	@RequestMapping("/forget")
	public String forgetpassword(Model model,HttpServletRequest request ) {
		
		System.out.println("Hello Nirav Came");
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("mail.xml");
	    	JavaMail mm = (JavaMail) context.getBean("javaMail");
	        mm.sendMail("nirav.dhinoja@gmail.com",
	    		   "abhi.pabari789@gmail.com",
	    		   "Nirav-Testing-Mail", 
	    		   "Nirav-Java Mail\n\n Hello Abhi Your Password is reset successfully");
		
		System.out.println("mission completed");
		return "redirect:/login";
	}
	
	@RequestMapping(value="/listpage")
	 public @ResponseBody UserResponseController listContacts(HttpServletRequest request) {
		  
			int rows = Integer.parseInt(request.getParameter("rows"));
			int page = Integer.parseInt(request.getParameter("page"));
			String sidx = request.getParameter("sidx");
			String sord = request.getParameter("sord");
			List<Usermaster>list = null;
			list = usermasterdao1.listUsers(rows,page,sidx,sord);
			UserResponseController response = new UserResponseController();
			response.setRows(list);
			int count = usermasterdao1.getNoOfRecords();
			int total = count%rows == 0 ? (int)Math.ceil(count/rows) : (int)Math.ceil(count/rows)+1;
		    response.setTotal(total);
	        response.setRecords(count);
	        response.setPage(page);
	        return response;									// response name
	    }
	
	
	@RequestMapping(value= "/edit")
	public ModelAndView doEdit(HttpServletRequest request){
		
		Integer userid = 0;
		String firstname = null;
		String lastname = null;
		String username = null;
		String password = null;
		String oper = null;
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String s = paramNames.nextElement();
			if("userid".equalsIgnoreCase(s)){
				userid = Integer.parseInt(request.getParameter("userid"));
				
			}else if("firstname".equalsIgnoreCase(s)){
				
				firstname = request.getParameter("firstname");
				
			}else if("lastname".equalsIgnoreCase(s)){
				
				lastname = request.getParameter("lastname");
				
			}else if("username".equalsIgnoreCase(s)){
				
				username = request.getParameter("username");
				
			}else if("password".equalsIgnoreCase(s)){
				
				password = request.getParameter("password");
				
			}else if("oper".equalsIgnoreCase(s)){
				oper = request.getParameter("oper");
				
			}
			
		}
		
		Map<String , String> model =new HashMap<String , String>();
		
		if("edit".equalsIgnoreCase(oper)){
			Usermaster usermaster = new Usermaster();
			System.out.println("User Id -"+userid);
			usermaster.setUserid(userid);
			usermaster.setFirstname(firstname);
			usermaster.setLastname(lastname);
			usermaster.setUsername(username);
			usermaster.setPassword(password);
			usermaster.setRoleid(2);
			usermasterdao1.updateUser1(usermaster);
			
		}else if("add".equalsIgnoreCase(oper)) {
			
		Usermaster usermaster = usermasterdao1.getUser(userid);
		if(usermaster == null){
			
			usermaster = new Usermaster();
			usermaster.setFirstname(firstname);
			usermaster.setLastname(lastname);
			usermaster.setUsername(username);
			usermaster.setPassword(password);
			usermaster.setRoleid(2);
			usermasterdao1.addUser1(usermaster);
		}
		else{
                throw new RuntimeException();
		}
			
			
		}
		else if("del".equalsIgnoreCase(oper)){
			usermasterdao1.deleteUser1(userid);
			
		}
		return new ModelAndView("mainGrid" , model);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/add", method=RequestMethod.POST)
//	public String addUser(@ModelAttribute("umaster") @Valid Usermaster umaster,BindingResult result){
//		
//		if(result.hasErrors()){
//			return "register"; // view name
//		}
//		else{
//			usermasterservice.addUser(umaster);
//			return "redirect:/login";
//		}
//	}
//
//	@RequestMapping("/editdetails")
//	public String editDetails(Model model,HttpServletRequest request){
//		
//		Usermaster umaster = usermasterservice.editUser(request);
//		model.addAttribute("updateusermodel",umaster);
//		return "update";
//	}
	
//	@RequestMapping("/updateuser/{userid}")
//	public String updateUser(@PathVariable("userid")Integer userid,Model model){
//		
//		Usermaster umaster = usermasterservice.updateUser(userid);
//		model.addAttribute("updateusermodel",umaster);
//		return "update";
//	}
	

	
	
	
	
	
	
//	@RequestMapping(value="/updateselecteduser",method = RequestMethod.POST)
//	public String updateselectedUser(@ModelAttribute("updateusermodel")Usermaster updateusermodel,BindingResult result,HttpServletRequest request){
//	System.out.println("Hello");
//		usermasterservice.updateselecteduser(updateusermodel);
//		
//		return "redirect:/listpage";
//	
//	}
//	
//	@RequestMapping("/deleteuser/{userid}")
//	public String deleteUser(@PathVariable("userid")Integer userid){
//		
//		usermasterservice.deleteUser(userid);
//	
//		return "redirect:/listpage";
//	}
//	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login" ;
	}
	
	
	@RequestMapping(value="/authenticate")
	public String authenticateUser(@ModelAttribute("usermaster")Usermaster usermaster,BindingResult result,HttpServletRequest request , HttpSession sessions){
		 sessions = request.getSession();
			String str1 = (String)sessions.getAttribute("username_s");
		
	if(str1 != null){
		
		return "mainGrid";
	}
	else	
	{
	//	Session session = sessionFactory.openSession();
		String usernamectrl = usermaster.getUsername();
		String passwordctrl = usermaster.getPassword();
		
		 sessions = request.getSession();
		String str = (String)sessions.getAttribute("username_s");
		
		
		
		int count = usermasterservice.authenticateUser(usernamectrl, passwordctrl);

		
		if(!(count == 0)){
			usermaster = usermasterservice.checkactiveuser(usernamectrl, passwordctrl);
			
			
			
			
			sessions.setAttribute("userid_s", usermaster.getUserid());
			sessions.setAttribute("username_s",usermaster.getUsername());
			
			sessions.setAttribute("role_s",usermaster.getRoleid());
			
			
			
			if(usermaster.isActive() == false ){
				return "error";
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			Usermaster.setStrtdt(dateFormat.format(date));
			//return "listpage";
			return "mainGrid";
		}
		
		else{
			
			return "redirect:/login";
		}
		
	
	}
		
	}
	
	
	
}
