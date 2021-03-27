package logic;

import java.util.ArrayList;

import entity.Box;
import entity.Coin;
import entity.ColorBox;
import entity.Door;
import entity.Flag;
import entity.Key;
import entity.Switch;
import entity.TrashCompactor;
import entity.Wall;
import entity.base.Entity;
import entity.base.Interactable;

public class GameMap {

	private Cell[][] cellmap;
	private int width;
	private int height;
	
	private ArrayList<Entity> allEntity;

	public GameMap(int column,int row) {
		
		allEntity = new ArrayList<Entity>();
		
		setWidth(column);
		setHeight(row);
		
		cellmap = new Cell[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				cellmap[i][j] = new Cell();
			}
		}
	}
	
	public GameMap(String[][] map) {
		
		allEntity = new ArrayList<Entity>();
		
		int column = map[0].length;
		int row = map.length;
		
		setWidth(column);
		setHeight(row);
		
		cellmap = new Cell[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				cellmap[i][j] = new Cell();
				switch(map[i][j]) {
				case "0":
					break;
				case "B":
					addEntity(new Box(),j,i);
					break;
				case "F":
					addEntity(new Flag(),j,i);
					break;
				case "W":
					addEntity(new Wall(),j,i);
					break;
				case "C":
					addEntity(new Coin(),j,i);
					break;
				case "D":
					addEntity(new Door(),j,i);
					break;
				case "K":
					addEntity(new Key(),j,i);
					break;
				case "S":
					addEntity(new Switch(),j,i);
					break;
				case "P":
					addEntity(new ColorBox(false),j,i);
					break;
				case "Q":
					addEntity(new ColorBox(true),j,i);
					break;
				case "T":
					addEntity(new TrashCompactor(),j,i);
					break;
				default:
					System.out.println("Error parsing at position x = "+j+" y = "+i+".\nUnknown Object with Symbol "+map[i][j]);
					break;
				
				}
				
				
			}
		}
		
	}
	
	
	public void printMap() {
		for(Cell[] row: cellmap) {
			String rowstring = "";
			for(Cell c:row) {
				rowstring+=c.getSymbol()+" ";
			}
			System.out.println(rowstring);
		}
	}
	
	public Cell[][] getMap(){
		return cellmap;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean addEntity(Entity e,int x, int y) {
		allEntity.add(e);
		
		e.setX(x);
		e.setY(y);
		boolean b = cellmap[y][x].setEntity(e);
		
		return b;
	}
	
	public Entity getEntity(int x,int y) {
		return cellmap[y][x].getEntity();
	}
	
	public void removeEntity(int x, int y) {
		
		allEntity.remove(cellmap[y][x].getEntity());
		
		cellmap[y][x].removeEntity();
	}
	
	public boolean isMovePossible(int targetx,int targety,Entity e) {
		if(targetx<0||targetx>=width||targety<0||targety>=height) {
			 //If Out of bound, cannot move
			return false;
		}
		if(cellmap[targety][targetx].IsEmpty()) { 
			//If the target cell is empty
			return true;
		}else {
			Entity target = cellmap[targety][targetx].getEntity();
			//If target is Interactable, check the result of the interaction
			if(target instanceof Interactable) {
				Interactable t = (Interactable) target;
				return t.interact(e);
			}else {
				return false;
			}
		}
	}
	
	public ArrayList<Entity> getAllEntity() {
		return allEntity;
	}
	
	
}
