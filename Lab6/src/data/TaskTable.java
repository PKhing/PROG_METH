package data;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TaskTable{
	private final TableView<Task> tableView;
	
	private final ObservableList<Task> data;
	
	
	public TaskTable(){
		this.data = FXCollections.observableArrayList();
		tableView = new TableView<Task>();
	}	
	
	
	public void setTableProperty() {
		tableView.setEditable(true);
		tableView.setFixedCellSize(32.0);
		
		TableColumn<Task, String> taskNameCol = new TableColumn<Task, String>("Task");
        taskNameCol.setMinWidth(250);
        taskNameCol.setCellValueFactory(
                new PropertyValueFactory<Task, String>("name"));
        taskNameCol.setReorderable(false);
        taskNameCol.setSortable(false);
        
 
        TableColumn<Task, Integer> taskRewardCol = new TableColumn<Task, Integer>("Reward");
        taskRewardCol.setMinWidth(100);
        taskRewardCol.setCellValueFactory(
                new PropertyValueFactory<Task, Integer>("reward"));
        taskRewardCol.setReorderable(false);
        taskRewardCol.setSortable(false);
 
        TableColumn<Task, Double> taskProgressCol = new TableColumn<Task, Double>("Progress");
        taskProgressCol.setMinWidth(144);
        
        taskProgressCol.setCellValueFactory(
                new PropertyValueFactory<Task, Double>("progress"));
        taskProgressCol.setCellFactory(ProgressTableCell.<Task>forTableColumn());    
        
        taskProgressCol.setOnEditCommit(
		        new EventHandler<CellEditEvent<Task, Double>>() {
		            @Override
		            public void handle(CellEditEvent<Task, Double> t) {	    
		            	//System.out.println(t);
		            	((Task) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProgress(t.getNewValue());
		            }
		        }
		    );
        taskProgressCol.setReorderable(false);
        taskProgressCol.setSortable(false);
        
 
        tableView.setItems(data);
        tableView.getColumns().addAll(taskNameCol, taskRewardCol, taskProgressCol);
	}
	
	public TableView<Task> getTableView() {
		return tableView;
	}
	
	public void addData(Task task) {
		data.add(task);
	}
	
	public void populateData() {
		Main.addLoadingTaskCount(1);
		try {
		for(int i=0;i<3;i++) {
			Thread.sleep(500);
			addData(new Task());
		}
		
		}catch(Exception e) {
			
		}
		Main.addLoadingTaskCount(-1);
	}
	
	public void printAllMember() {
		for(Task t:data) {
			System.out.println(t.getName()+" "+t.getProgress());
		}
	}
	
	public void removeAllCompletedTask() {
		data.removeIf((Task t) -> t.getProgress() > 1);
	}
	
	public int getFinishedTaskCount() {
		int result = 0;
		for(Task t:data) {
			if(t.getProgress()>1) {
				result+=1;
			}
		}
		return result;
	}
	

}
