package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class Flag extends Entity implements Interactable {
	
	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		return Sprites.FLAG;
	}
	
	@Override
	public boolean interact(Entity e) {
		if(e instanceof Player) {
			this.remove();
			GameController.setGameWin(true);
			return true;
		}
		else {
			return false;
		}
		
	}

	

}
