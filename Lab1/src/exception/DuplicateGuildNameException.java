package exception;

public class DuplicateGuildNameException extends Exception {

	public DuplicateGuildNameException() {
		super("Department name cannot duplicate!");
	}
}
