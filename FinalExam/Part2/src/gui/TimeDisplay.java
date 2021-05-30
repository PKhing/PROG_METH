package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class TimeDisplay extends Pane{
	
	private Label timeLabel;
	private int timeValue;
	
	public TimeDisplay(int number) {
		super();
		timeLabel = new Label();
		setTimeLabel(number);
		this.getChildren().add(timeLabel);
	}
	
	public void addTime(int number) {
		this.setTimeValue(getTimeValue()+number);
		timeLabel.setText("Times: " + getTimeValue());
	}
	
	public void setTimeLabel(int number) {
		this.setTimeValue(number);
		timeLabel.setText("Times: " + getTimeValue());
	}
	
	public int getTimeValue() {
		return timeValue;
	}
	public void setTimeValue(int timeValue) {
		this.timeValue = timeValue>=0? timeValue : 0;
	}

}
