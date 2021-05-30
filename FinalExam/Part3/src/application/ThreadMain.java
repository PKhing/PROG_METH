package application;

import data.Crewmate;
import javafx.application.Platform;

public class ThreadMain {

	protected void initalizeNewCrewmate(int code) {
		/*
		 * ====================FILL CODE============================ Add something on
		 * the code below to make new crewmate appear while application can be responded
		 */
		new Thread(() -> {
			updateCrewmateMovement(code);
		}).start();

		/* ======================================================== */

	}

	protected void updateCrewmateMovement(int code) {
		try {
			Crewmate b = Main.crewmateField.getCrewmateList().get(code);
			while (true) {

				/* ===================!DO NOT CHANGE THIS LINE!=========== */
				Thread.sleep(50);
				/* ======================================================== */

				/*
				 * ====================FILL CODE============================ There is JavaFX
				 * commands inside the code below Add something to the code below to make JavaFX
				 * commands can function in the thread
				 */
				// Hint : Both Crewmate and Alarm use ImageView, which is related to JavaFX.
				Platform.runLater(() -> {
					Main.crewmateField.getCrewmateList().get(code).update();
					Main.drawCrewmate(b);
				});
				/* ======================================================== */
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void initalizeAlarm() {
		/*
		 * ====================FILL CODE============================ Add something on
		 * the code below to start/stop alarm while application can be responded
		 */
		new Thread(() -> {
			Platform.runLater(() -> {
				Main.turnAlarm();
			});
		}).start();

		/* ======================================================== */
	}
}
