package com.org3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/abc")
public class verifyCaptcha2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String captcha = req.getParameter("captcha");
		
		HttpSession session = req.getSession();
		String genCaptcha = (String) session.getAttribute("genCaptcha");
		
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html");
		if (captcha.equals(genCaptcha)) {
				out.println("<h1>You are a Human</h1>");
		}
		else {
			out.println("<h1>You are not a Human</h1>");
		}
	}
}
