package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class ColorBox extends Entity implements Interactable {

	private boolean activeBool;

	public ColorBox(boolean activeBool) {
		this.activeBool = activeBool;
	}

	@Override
	public int getSymbol() {
		if (activeBool) {
			return Sprites.BOX_RED;
		}
		return Sprites.BOX_BLUE;
	}

	@Override
	public boolean interact(Entity e) {
		if (activeBool == GameController.getGameSwitchStatus()) {
			return this.move(e.getDirection());
		}
		return false;
	}

	public boolean isActiveBool() {
		return activeBool;
	}

	public void setActiveBool(boolean activeBool) {
		this.activeBool = activeBool;
	}

}
