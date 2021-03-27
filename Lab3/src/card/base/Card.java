package card.base;

//You CAN modify the first line
public abstract class Card {

	private String name;
	private String description;

	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public abstract String toString();

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isEqual(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
