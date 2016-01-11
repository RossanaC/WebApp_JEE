package authentication;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthentificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static Employes employesContainer;
	
	/**
     * Class constructor. 
     */
    public AuthentificationServlet() {
    	AuthentificationServlet.employesContainer = new Employes() ;
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String pageURL = "";
		
		Employee bean = new Employee(username, password) ;
		
		HttpSession session = request.getSession(true) ;
		
		// store the employee bean in the session
		session.setAttribute("employee", bean);
		session.setAttribute("employee_u", bean.getUsername());
		
		// validate the user using the cookies
		Cookie[] cookies = request.getCookies() ;		
		boolean cookieAuth = verifyAuthCookies( cookies, bean ) ;
			
		
		// if the user has no cookie to authorize, make a call to validate the credentials
		boolean requestAuth = false;
		if ( cookieAuth )
			pageURL = "/demandeConge.jsp";
		else
			requestAuth = AuthentificationServlet.employesContainer.validate(bean) ;
		
		// request auth
		if ( requestAuth )
		{	
			Cookie cookieUsername = new Cookie( "username", bean.getUsername() ) ;
			Cookie cookieHashkey = new Cookie( "key", generateHash(bean) ) ;
			
			cookieUsername.setMaxAge( 60*60*24*4 ); // 4 days
			cookieHashkey.setMaxAge( 60*60*24*4 ); // 4 days
			
			response.addCookie( cookieUsername );
			response.addCookie( cookieHashkey );
			
			pageURL = "/demandeConge.jsp";
		}
		else if ( !cookieAuth )
			pageURL = "/error.jsp";
		
		
		if ( ! pageURL.equals("/error.jsp") )
			session.setAttribute("auth", "yes");
		else
			session.setAttribute("auth", "no") ;
		
		// the session will expire after 50 seconds of inactivity
		session.setMaxInactiveInterval(50);
		

		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(pageURL);
		dispatcher.include(request, response);
	}
	
	/**
	 * Returns true if the user is authorized with the cookies. Returns false otherwise.
	 * @param cookies
	 * @param temp
	 * @return
	 */
	private boolean verifyAuthCookies( Cookie[] cookies , Employee temp ) {
		if ( cookies != null && cookies.length>1 ) {
			boolean sameUser = false ;
			String key = "" ;
			
			for ( int i=0 ; i<cookies.length ; i++ )
			{
				if ( cookies[i].getName().equals("username") )
					if ( temp.getUsername().equals( cookies[i].getValue()) )
						sameUser = true ;
				
				if ( cookies[i].getName().equals("key") )
					key = cookies[i].getValue() ;
			}
			
			if ( sameUser && key.equals( generateHash(temp) ) )
				return true ;
			else
				return false ;
		}
		
		return false ;
	}
	
	/**
	 * Generates a key to represent the user
	 * @param employee
	 * @return
	 */
	private String generateHash( Employee employee ) {
		
		MessageDigest message;
		try {
			message = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			
			String planB = employee.getUsername() + employee.getPassword() ;			
			return Integer.toHexString(planB.hashCode());
		}
		
        byte[] dataBytes = (employee.getUsername() + employee.getPassword()).getBytes() ;

        message.update( dataBytes, 0 , dataBytes.length );
        byte[] mdbytes = message.digest();
        
		StringBuffer hexString = new StringBuffer() ;
		
		for (int i=0;i<mdbytes.length;i++) {
			hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
		}
		
		return hexString.toString() ;	
	}

}
