package pers.cierra_runis.diary;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
    private static boolean result;

    public static boolean display(String title, String msg) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label();
        label.setText(msg);
        Button btn1 = new Button("是");
        Button btn2 = new Button("否");
        btn1.setOnMouseClicked(event -> {
            result = true;
            System.out.println("确认删除");
            stage.close();
        });
        btn2.setOnMouseClicked(event -> {
            result = false;
            System.out.println("取消删除");
            stage.close();
        });
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, btn1, btn2);
        //设置居中
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 200, 200);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.showAndWait();

        return result;
    }
}
