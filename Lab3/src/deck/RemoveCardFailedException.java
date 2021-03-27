package deck;

public class RemoveCardFailedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3088721418238769979L;

	public String message;

	public RemoveCardFailedException(String message) {
		this.message = message;
	}
}
