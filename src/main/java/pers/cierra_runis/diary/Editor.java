package pers.cierra_runis.diary;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static pers.cierra_runis.diary.SystemInfo.*;

public class Editor {
    static String date;
    static String title;
    static String text;

    public Editor(String inputDate) {
        date = inputDate;
        title = new Diary(inputDate).title;
        text = new Diary(inputDate).text;
    }

    public void display() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        HBox save = new HBox();
        Text textInSaveButton = new Text("保存");
        textInSaveButton.setTextAlignment(TextAlignment.CENTER);
        textInSaveButton.setSmooth(true);
        textInSaveButton.setFont(new Font(FONT_SC_HEAVY.getName(), 15));
        textInSaveButton.setFill(PAINT_LIGHTDARK);
        save.setPrefWidth(60);
        save.setPrefHeight(30);
        save.setLayoutX(EDITOR_WIDTH - 60 - 3);
        save.setLayoutY(3);
        save.setBackground(BG_GRAY);
        save.setAlignment(Pos.CENTER);
        save.getChildren().add(textInSaveButton);

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Diary newDiary = new Diary(date);
                newDiary.saveDiary(title, textArea.getText());
                stage.close();
            }
        });

        HBox Body = new HBox();
        Body.setPrefWidth(EDITOR_WIDTH);
        Body.setPrefHeight(EDITOR_HEIGHT);
        Body.setBackground(BG_DARK);

        Group group = new Group();
        group.getChildren().add(Body);
        group.getChildren().add(textArea);
        group.getChildren().add(save);

        Scene scene = new Scene(group);
        scene.getStylesheets().add("file:src/main/resources/" + "pers/cierra_runis/diary/textarea.css");
        textArea.setText(text);
        scene.setFill(null);

        //定位
        stage.setX((SCREEN_WIDTH - EDITOR_WIDTH) / 2);
        stage.setY((SCREEN_HEIGHT - EDITOR_HEIGHT) / 2);

        //配置
        stage.setTitle("输入密码");
        stage.getIcons().add(ICON);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setWidth(EDITOR_WIDTH);
        stage.setHeight(EDITOR_HEIGHT);
        stage.setOpacity(0.9);

        //布局
        stage.setScene(scene);

        //显示
        stage.showAndWait();
    }

}
