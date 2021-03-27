package logic;

import entity.base.Consumable;
import entity.base.Entity;

public class Cell {
	private Entity myEntity;
	private boolean isEmpty;
	
	public Cell() {
		isEmpty = true;
	}
	
	public boolean IsEmpty() {
		return isEmpty;
	}
	
	public boolean setEntity(Entity e) {
		if(isEmpty) {
			myEntity = e;
			isEmpty = false;
			return true;
		}else { //The Cell is not empty
			if(myEntity instanceof Consumable) {
				Consumable d = (Consumable) myEntity;
				return d.consume(e);
			}else {
			return false;
			} 
		}
	}
	
	public Entity getEntity() {
		return myEntity;
	}
	
	public void removeEntity() {
		myEntity = null;
		isEmpty = true;
	}
	
	public int getSymbol() {
		if(isEmpty) {
			return -1;
		}
		return myEntity.getSymbol();
	}
	
	
}
