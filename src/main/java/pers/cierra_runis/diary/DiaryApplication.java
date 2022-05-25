package pers.cierra_runis.diary;

import javafx.application.Application;
import javafx.stage.Stage;

public class DiaryApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        if (PasswordWindow.display()) {
            new Page().start(stage);
        }

    }

}
