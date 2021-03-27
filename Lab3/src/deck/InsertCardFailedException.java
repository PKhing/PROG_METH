package deck;

public class InsertCardFailedException extends Exception {
	private static final long serialVersionUID = -9139996863974615144L;

	public String message;

	public InsertCardFailedException(String message) {
		this.message = message;
	}
}
