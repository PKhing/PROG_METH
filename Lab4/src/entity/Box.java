package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.Sprites;

public class Box extends Entity implements Interactable {

	@Override
	public int getSymbol() {
		return Sprites.BOX;
	}

	@Override
	public boolean interact(Entity e) {
		return move(e.getDirection());
	}

}
