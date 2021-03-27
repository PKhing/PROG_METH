package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class Coin extends Entity implements Interactable{

	@Override
	public int getSymbol() {
		return Sprites.COIN;
	}

	@Override
	public boolean interact(Entity e) {
		this.remove();
		GameController.setCoinCount(GameController.getCoinCount()+1);
		return true;
	}

}
