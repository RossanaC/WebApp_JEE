package authentication;

import java.util.ArrayList;

/**
 * @author Luis Abreu, Rossana Cammardella
 *
 */
public class Employes {

	// list of all the employees registered in the application
	private ArrayList<Employee> employesList ;
	
	/**
	 * Class constructor
	 */
	public Employes() {
		this.employesList = new ArrayList<Employee>() ;
		
		addEmployee("luis", "123") ;
		addEmployee("rossana", "123");
	}
	
	/**
	 * Adds a new Employee to the ArrayList<Employee>. The username must be unique.
	 * @param username
	 * @param password
	 * @return 0 if the user was created and added to the list. -1 if the username
	 * already exists. -2 if at least one of the arguments is a null string
	 */
	public int addEmployee(String username, String password) {
		
		if ( username.equals("") || password.equals("") )
			return -2 ;
		
		for ( Employee temp : this.employesList )
			if ( temp.getUsername().equals( username ))
				return -1 ;
		
		Employee temp = new Employee(username, password) ;
		this.employesList.add( temp ) ;
		
		return 0 ;
	}
	
	/**
	 * Verifies if an employee 'user' exists in the ArrayList<Employee> that represents the valid logins.
	 * @param user
	 * @return True if the user is exists and so its allowed to login. False otherwise.
	 */
	public boolean validate(Employee user) {
		
		for ( Employee temp : this.employesList )
		{
			if ( temp.getUsername().equals( user.getUsername() ) )
			{
				if ( temp.getPassword().equals( user.getPassword() ) )
					return true ;
				else
					return false ;
			}
		}
		
		return false ;
	}
}
