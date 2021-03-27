package entity;

import entity.base.Entity;
import logic.Sprites;

public class Player extends Entity{

	@Override
	public int getSymbol() {
		return Sprites.PLAYER;
	}
	
}
