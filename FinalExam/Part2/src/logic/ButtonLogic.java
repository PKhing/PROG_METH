package logic;

import application.Main;
import gui.DisplayPane;
import gui.TimeDisplay;

public class ButtonLogic {
	public static void bottomControlPaneOnClick(String c) {
		TimeDisplay timeLabel = Main.getTcp().getTimeDisplay();
		timeLabel.addTime(1);
		DisplayPane dp = Main.getDp();
		switch(c) {
		case "TRAIN":
			dp.act("TRAIN");
			break;
		case "REST":
			dp.act("REST");
			break;
		case "EAT":
			dp.act("EAT");
			break;
		default:
			break;
		}	
	}
	
	public static void topControlPaneOnClick() {
		Main.getTcp().getTimeDisplay().setTimeLabel(0);
		Main.getDp().resetDisplayPane();
	}
}
