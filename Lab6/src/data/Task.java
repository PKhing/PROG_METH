package data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {
	
	private final SimpleStringProperty name;
	private final SimpleIntegerProperty reward;
	private final SimpleDoubleProperty progress;
	private boolean isComplete;
	
	
	
	public Task() {
		this(TaskUtil.getRandomTask(),TaskUtil.getRandomReward());
	}
	
	public Task(String name,int reward) {
		this.name = new SimpleStringProperty(name);
		this.reward = new SimpleIntegerProperty(reward);
		this.progress = new SimpleDoubleProperty(-1);
		setComplete(false);
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getName() {
		return this.name.get();
	}
	
	public void setReward(int reward) {
		this.reward.set(reward);
	}
	
	public int getReward() {
		return this.reward.get();
	}
	
	public void setProgress(double progress) {
		this.progress.set(progress);
	}
	
	public double getProgress() {
		return this.progress.get();
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

}
