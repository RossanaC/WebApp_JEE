package conge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/demande")
public class VerificationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// the day entered is between 1 and 365 but the index in the array are between 0 and 364.
		// for this reason we have to subtract 1.
		int day = Integer.parseInt(request.getParameter("day"))-1;
		
		Conge conge = Conge.instance() ;
		
		request.setAttribute( "day" , day+1 );
		
		if ( conge.verifierJour( day ) ) // the day is available
		{
			conge.poserJour( day );
			request.setAttribute("result", "available") ;
		}
		else // the day is not available
			request.setAttribute("result", "notavailable") ;
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultatDemand.jsp");
		dispatcher.include(request, response);
	}

}
