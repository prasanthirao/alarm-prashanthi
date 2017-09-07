package com.alarmspring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		AuthenticationJDO authenticationJdoObject = new AuthenticationJDO();
		authenticationJdoObject.setemail(email);
		authenticationJdoObject.setpassword(password);
		List<AuthenticationJDO> results = null;
		try {

			Query q = pm.newQuery(AuthenticationJDO.class, ("email == email1 && password==password1"));
			q.declareParameters("String email1,,String password1");

			try {
				try {
					results = (List<AuthenticationJDO>) q.execute(email, password);
					if (results.isEmpty() || results.equals(null)) {

						out.println("please enter registered mail... and password....");

					} else {
						//out.println("welcome " + email);
						resp.sendRedirect("success.jsp");
				HttpSession session=req.getSession();
	
						session.setAttribute("email",results.get(0).getemail());
						session.setAttribute("name", results.get(0).getfirstName());
						System.out.print(results.get(0).getfirstName());
						System.out.print(results.get(0).getemail());
					} 
				}catch (NullPointerException e) {

					}
				} finally {

				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception occurs");

			}
}

}
