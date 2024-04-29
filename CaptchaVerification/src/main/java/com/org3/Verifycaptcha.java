package com.org3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/enter_name")
public class Verifycaptcha extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			Random random = new Random();
			String captcha = ""+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+"";
			HttpSession session = req.getSession();
			session.setAttribute("genCaptcha", captcha);
			
			PrintWriter out = resp.getWriter();
			 resp.setContentType("text/html");
			 out.println("<h3>Hello"+name+",please Enter Captcha :"+captcha);
			 out.println("<form action='abc' method='post'><br><br>"
			 		+ "Enter the Captcha : <br><br>"
			 		+ "<input type='number' name='captcha'><br><br>"
			 		+ "<input type='submit' value='LOGIN'>"
			 		+ "</form>=");
			 
	}
}
