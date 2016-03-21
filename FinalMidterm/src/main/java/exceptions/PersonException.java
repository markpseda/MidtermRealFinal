package exceptions;
import com.cisc181.core.Person;

public class PersonException extends Exception{
	private Person person;
	
	/**
	 * Create an instance of the PersonException class, to be thrown to the caller
	 * @param the Person object that caused the exception
	 */
	public PersonException(Person person){
		super();
		this.person = person;
	}
	
	
	

}
