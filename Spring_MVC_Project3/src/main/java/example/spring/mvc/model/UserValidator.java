package example.spring.mvc.model;

public class UserValidator {
	public static boolean isValid(User cuurentUserRef) {
		String currentUserName=cuurentUserRef.getUserId();
		String currentUserPassword=cuurentUserRef.getPassword();
		boolean success = false;
		
		if(currentUserName.equalsIgnoreCase("Admin")
				&&
		  currentUserPassword.equalsIgnoreCase("asAdmin"))
		
			success=true;
			
		return success;
		
	}
}
