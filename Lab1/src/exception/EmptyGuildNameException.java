package exception;

public class EmptyGuildNameException extends Exception {

	public EmptyGuildNameException() {
		super("Department name cannot be blank!");
	}
}
