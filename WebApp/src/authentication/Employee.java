package authentication;

/**
 * Bean to represent one Employee. 
 * @author Luis Abreu, Rossana Cammardella
 *
 */
public class Employee {
	
	private String username ;
	private String password ;
		
	/**
	 * Class constructor. The parameters are both strings and they represent 
	 * the username and the passord of the Employee that will be used to
	 * validate the authentication on the application
	 * 
	 * If the username is null it will be assigned the value "null_username"
	 * 
	 * If the password is null it will be assigned the value "null_password"
	 * @param username
	 * @param password
	 */
	public Employee( String username, String password ) 
	{
		if ( ! username.equals("") )
			this.username = username ;
		else
			this.username = "null_username";
		
		if ( ! password.equals("") )
			this.password = password ;
		else
			this.password = "null_password" ;
	}
	
	public Employee()
	{
		this.username = "null_username";
		this.password = "null_password" ;
	}
	
	/**
	 * Returns the string with the username of the Employee
	 * @return String
	 */
	public String getUsername() {
		return this.username ;
	}
	
	/**
	 * Returns the string with the password of the Employee
	 * @return String
	 */
	public String getPassword() {
		return this.password ;
	}
	
	/**
	 * Sets the 'username' to the value passed as parameter.
	 * If the new value is a null string this function won't have any effect.
	 * @param username
	 */
	public void setUsername(String username) {
		if ( ! username.equals("") )
			this.username = username ;
	}
	
	/**
	 * Sets the 'password' to the value passed as parameter.
	 * If the new value is a null string this function won't have any effect.
	 * @param password
	 */
	public void setPassword(String password) {
		if ( ! password.equals("") )
			this.password = password ;
	}
	
}
