package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

//You might need to do something to the following line
public class FieldPane extends GridPane {

	private ObservableList<FieldCell> fieldCells = FXCollections.observableArrayList();

	public FieldPane() {

		this.setPrefWidth(500);
		this.setAlignment(Pos.CENTER);
		this.setVgap(8);
		this.setHgap(8);
		this.setPadding(new Insets(8));
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, null, null)));
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				FieldCell fieldCell = new FieldCell();
				fieldCells.add(fieldCell);
				GridPane.setRowIndex(fieldCell, i);
				GridPane.setColumnIndex(fieldCell, j);
				this.getChildren().add(fieldCell);
			}
		}
	}

	public int calculateIncome() {
		int sum = 0;
		for (FieldCell fieldCell : fieldCells) {
			if (fieldCell.getCrop() != null) {
				sum += fieldCell.getCrop().getIncome();
			}
		}
		return sum;
	}

}
