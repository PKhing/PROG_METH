package entity.base;

import exception.IllegalValueException;

public interface Updatable {
	public abstract void update() throws IllegalValueException;
	
	public abstract void valueCorrection();
}
