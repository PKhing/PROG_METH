package data;

import application.Main;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class ProgressTableCell<S> extends TableCell<S, Double> {
	private double value;

	private final Button button;
	private final ProgressBar prog;
	private final Label donetext;

	public ProgressTableCell() {
		value = 0;

		/*
		 * ====================FILL CODE============================ Initialize all
		 * remaining fields. Make Clicking the "Start" Button calling the proper method.
		 */
		button = new Button("Start");
		prog = new ProgressBar();
		donetext = new Label("Finished");

		button.setOnMouseClicked((event) -> {
			startProgress();
		});
		/* ======================================================== */

	}

	public S getCurrentItem() {
		return (S) getTableView().getItems().get(getIndex());
	}

	public static <S> Callback<TableColumn<S, Double>, TableCell<S, Double>> forTableColumn() {
		return param -> new ProgressTableCell<>();
	}

	@Override
	public void updateItem(Double item, boolean empty) {
		super.updateItem(item, empty);

		if (Main.getLoadingTaskCount() > 0) {
			button.setDisable(true);
		} else {
			button.setDisable(false);
		}

		if (item == null) {
			setGraphic(null);
		} else {
			if (item < 0) {
				setGraphic(button);
			} else {
				if (item >= 1) {
					setGraphic(donetext);
				}

			}
		}

	}

	public void startProgress() {
		setGraphic(prog);
		prog.setVisible(true);

		if (Main.getProgressingTaskCount() == 0) {
			Main.disableButtonPane();
		}
		Main.addProgressingTaskCount(1);

		/*
		 * ====================FILL CODE============================ Alter this line to
		 * make UI still responsive while loading
		 */
		new Thread(() -> {
			simulateProgressIncrement(0d);
		}).start();
		/* ======================================================== */

	}

	public void simulateProgressIncrement(Double start) {
		value = start;
		while (value < 1d) {
			try {
				Thread.sleep(10);

				/*
				 * ====================FILL CODE============================ This is JavaFX
				 * commands. It will error if called in another thread. Alter this line to make
				 * it works.
				 */
				Platform.runLater(() -> {
					prog.setProgress(value);
				});
				/* ======================================================== */

				value += 0.01d;
				commitEdit(value);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Main.addProgressingTaskCount(-1);
		if (Main.getProgressingTaskCount() == 0) {
			Main.enableButtonPane();
		}

		/*
		 * ====================FILL CODE============================ This is JavaFX
		 * commands. It will error if called in another thread. Alter this line to make
		 * it works.
		 */
		Platform.runLater(() -> {
			setGraphic(donetext);
		});
		/* ======================================================== */

	}

	@Override
	public void commitEdit(Double item) {
		if (!isEditing() && !item.equals(getItem())) {
			TableView<S> table = getTableView();
			if (table != null) {
				TableColumn<S, Double> column = getTableColumn();
				CellEditEvent<S, Double> event = new CellEditEvent<>(table,
						new TablePosition<S, Double>(table, getIndex(), column), TableColumn.editCommitEvent(), item);
				Event.fireEvent(column, event);
			}
		}

		super.commitEdit(item);
	}
}