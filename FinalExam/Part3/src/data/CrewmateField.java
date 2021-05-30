package data;

import java.util.ArrayList;
import java.util.Random;
import application.Main;

public class CrewmateField {
	private final ArrayList<Crewmate> crewmateList;	
	private int crewmateCount = 0;
	private int crewmateKillCount = 0;
	public static Random random = new Random();

	public CrewmateField(){
		crewmateList = new ArrayList<Crewmate>();
	}	
		
	public void addCrewMate() {
        
		crewmateList.add(new Crewmate(Main.width / 2, Main.height / 2));
		crewmateCount++;
	}

	public void killCrewMate() {
		if(crewmateKillCount < crewmateCount) {
			crewmateList.get(crewmateKillCount).kill();
			crewmateKillCount++;
		}

	}
	public ArrayList<Crewmate> getCrewmateList() {
		return crewmateList;
	}

	public int getCrewmateCount() {
		return crewmateCount;
	}

	public void setCrewmateCount(int ballCount) {
		this.crewmateCount = ballCount;
	}
	
}


