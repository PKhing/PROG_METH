package entity;

import entity.base.Entity;
import logic.Sprites;

public class Wall extends Entity{

	@Override
	public int getSymbol() {
		return Sprites.WALL;
	}

}
