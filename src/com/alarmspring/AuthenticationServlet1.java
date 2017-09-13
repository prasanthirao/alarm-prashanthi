package com.alarmspring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

//import com.google.appengine.repackaged.com.google.gson.JsonObject;


@SuppressWarnings("serial")
@Controller
public class AuthenticationServlet1 {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping(value = "/AuthenticationServlet", method = RequestMethod.POST)

	public ModelAndView Register(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/plain");
		System.out.println("into authenticate servlet");
	    PrintWriter out = response.getWriter();
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
		HttpSession session = request.getSession();
		// session.setAttribute("useremail",email);	
		PersistenceManager pm = PMF.get().getPersistenceManager();
		AuthenticationJDO authenticationJdoObject = new AuthenticationJDO();
		authenticationJdoObject.setfirstName(firstName);
		authenticationJdoObject.setlastName(lastName);
		authenticationJdoObject.setemail(email);
		authenticationJdoObject.setpassword(password);
		//pm.makePersistent(authenticationJdoObject);
	//	session.setAttribute("id", authenticationJdoObject);
		try {
			Query dataquery = pm.newQuery(AuthenticationJDO.class);
			// dataquery.declareParameters("String email1");
			try {
				List<AuthenticationJDO> results = (List<AuthenticationJDO>) dataquery.execute();
				boolean valid = true;
				for (AuthenticationJDO obj : results) {
					if (obj.getemail().equals(email)) {
						//out.println("already exists");
						valid = false;
						break;
						// return new ModelAndView("index");
					}
				}
				if (valid){
					pm.makePersistent(authenticationJdoObject);
					session.setAttribute("id", authenticationJdoObject);
			return new ModelAndView("success","userName",firstName);
				}
			
			else {  
				return new ModelAndView("index");
			
			}
			}
		
			/*
			 * if (results.isEmpty()) {
			 * pm.makePersistent(authenticationJdoObject);
			 * session.setAttribute("id", authenticationJdoObject); //
			 * response.sendRedirect("success.jsp"); return new
			 * ModelAndView("success");
			 * 
			 *} else { // return new ModelAndView("index");
			 * 
			 * response.sendRedirect("index.jsp"); out.println(
			 * "email already exists..");
			 * 
			 * return new ModelAndView("index"); } }
			 */

			catch (NullPointerException nullexception) {
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Exception occurs");
		} finally {
		} 
		return null;
		// ModelAndView modelObject=new ModelAndView("success");
		// return modelObject;	
	}
	@RequestMapping(value = "/LoginServlet",method = RequestMethod.POST)
	//@ResponseBody
	public ModelAndView Login(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
		response.setContentType("text/plain");
	    //System.out.println("into spring");
		PrintWriter out = response.getWriter();
        //String str=Util.getPostData(request);
      // String str1=str.replace("null", "");
       //System.out.println(str1);
       //JSONObject jsonObject = new JSONObject(str1);
       //String username=jsonObject.getString("username");
       //String email = jsonObject.getString("email");
       //String password = jsonObject.getString("password");
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
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
						// out.println("please enter registered mail... and
						// password....");
						return new ModelAndView("index");
					} else {
						// out.println("welcome " + email);
						// resp.sendRedirect("success.jsp");
						/*List<Data> results1 = null;
						try {
							Query query = pm.newQuery(Data.class, ("email == email1"));
							q.declareParameters("String email1");
							try {
								results1 = (List<Data>) q.execute(email);
								System.out.println("dfdf");
								if (results.isEmpty() || results.equals(null)) {
								} else {
									for (Data d : results1) {
										System.out.println(d.getaddTime());
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						} finally {
						}*/
						session.setAttribute("id", results.get(0));
					String userName   =	results.get(0).getfirstName();
						return new ModelAndView("success","userName",userName);
						/*
						 * HttpSession session = request.getSession();
						 * 
						 * session.setAttribute("email",
						 * results.get(0).getemail());
						 * session.setAttribute("name",
						 * results.get(0).getfirstName());
						 * System.out.print(results.get(0).getfirstName());
						 * System.out.print(results.get(0).getemail());
						 */
					}
				} catch (NullPointerException e) {

				}
			} finally {

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurs");

		}
		return null;

		
	}
	
	
	
	
	@ResponseBody @RequestMapping(value = "/ListOfTimersOfUser", method = RequestMethod.POST)
	public String displayListOfTimersOfUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//PrintWriter out = response.getWriter();
	//	String email = request.getParameter("email");
		HttpSession session = request.getSession();
		HashMap<String, Object> responseMap = new HashMap<>();
		
		AuthenticationJDO registerobj = (AuthenticationJDO) session.getAttribute("id");
		Long Id = registerobj.getId();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Data> results1 = null;
		List<String> listStrings = new ArrayList<String>();
		try {
			Query query = pm.newQuery(Data.class, ("Idvalues == id1 && isDeleted == false"));
			query.declareParameters("String id1");
			try {

				results1 = (List<Data>) query.execute(Id);
				
				//System.out.println("dfdf");
				if (results1.isEmpty() || results1.equals(null)) {
				} else {
					for (Data d : results1) {
					//out.println(d.getaddTime());
					//response.getWriter().write("dfgh");
					listStrings.add(d.getaddTime());

					}
					//System.out.println(((Data) results1).getaddTime());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} finally {

			pm.close();
		}
		responseMap.put("listOfStrings", listStrings);
		ObjectMapper obj = new ObjectMapper();
		String response1 = obj.writeValueAsString(responseMap);
		
		return response1;
		
		
	}

	@RequestMapping(value = "/Timer", method = RequestMethod.POST)
	public void addTime(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();
		// String giveTime = request.getParameter("giveTime");

		String str = Util.getPostData(request);
		String str1 = str.replace("null", "");
		JSONObject data = new JSONObject(str1);
		System.out.println(data);
		String time = data.getString("givenTime");
		System.out.println(time);
		HttpSession session = request.getSession();
		AuthenticationJDO registerobj = (AuthenticationJDO) session.getAttribute("id");
		Long ids = registerobj.getId();
		System.out.println(ids);
		String email = registerobj.getemail();
		Data date = new Data();
		date.setaddTime(time);
		date.getIdvalues().add(ids);
		date.setEmail(email);
		PersistenceManager pmf = PMF.get().getPersistenceManager();
        
		pmf.makePersistent(date);
		

		/*
		 * List<Data> results = null; try {
		 * 
		 * Query q = pmf.newQuery(Data.class, ("email == email1"));
		 * q.declareParameters("String email1");
		 * 
		 * try {
		 * 
		 * results = (List<Data>) q.execute(email); System.out.println("dfdf");
		 * if (results.isEmpty() || results.equals(null)) { } else { for(Data
		 * d:results){ System.out.println(d.getaddTime());
		 * 
		 * 
		 * }
		 * 
		 * } } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * } finally {
		 * 
		 * }
		 */
	}
	/*@RequestMapping("/afterlogin")
	public String afterLogin()
	{
		return "success";
	}*/
	/*@RequestMapping("/Signout")
	public String signOut(HttpServletRequest req) throws JSONException{
	   String sss = Util.getPostData(req);
	   JSONObject json = new JSONObject(sss);
	   //System.out.println(str);
	   String email = json.getString("email");
	   System.out.println(email);
	   return "index";
	}*/
	/*@RequestMapping("/aftersignout")
	public String after()
	{
		return "index";
	}
*/
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void Delete(HttpServletRequest req, HttpServletResponse res) throws JSONException{
	System.out.println("in delete function");
	String str = Util.getPostData(req);
	String str1 = str.replace("null", "");
	//JSONObject jsonobject = new JSONObject(str1);
	JSONObject jsonObject = new JSONObject(str1);
	String deltime = jsonObject.getString("deltime");
	System.out.println(deltime+"pkj");
	HttpSession session = req.getSession();
	PersistenceManager pm = PMF.get().getPersistenceManager();

	//AuthenticationJDO registerobj1 = (AuthenticationJDO) session.getAttribute("timerId");
	Data dataobj=new Data();
	List<Data> results11 = null;
	try {

	Query query = pm.newQuery(Data.class, ("addTime == time"));
	query.declareParameters("String time");


	try {

	results11 = (List<Data>) query.execute(deltime);

	if (results11.isEmpty() || results11.equals(null)) {
	} else {
	for(Data dd: results11){
	//signOut(req)
	System.out.println(dd.getaddTime());
	dd.getIsDeleted();
	dd.setIsDeleted(true);

	}
	}
	}catch(Exception e){
	System.out.println(e);
	}


	}finally{

	}
	}
	}

