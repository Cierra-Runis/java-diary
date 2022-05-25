package pers.cierra_runis.diary;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

import static pers.cierra_runis.diary.SystemInfo.*;

public class Editor {

    static String date;
    static String title;
    static String text;
    double x1;
    double y1;
    double x_stage;
    double y_stage;

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

        //标题底衬
        HBox Title = new HBox(new Label());
        Title.setPrefWidth(EDITOR_WIDTH);
        Title.setPrefHeight(36);
        Title.setBackground(BG_DARKER);
        Title.setAlignment(Pos.CENTER);
        Title.setOnMouseDragged(mouseEvent -> {
            stage.setX(x_stage + mouseEvent.getScreenX() - x1);
            stage.setY(y_stage + mouseEvent.getScreenY() - y1);
        });
        Title.setOnMousePressed(mouseEvent -> {
            x1 = mouseEvent.getScreenX();
            y1 = mouseEvent.getScreenY();
            x_stage = stage.getX();
            y_stage = stage.getY();
        });

        TextArea textArea = new TextArea();
        textArea.setLayoutX(0.1 * EDITOR_WIDTH);
        textArea.setLayoutY(40);
        textArea.setPrefWidth(0.8 * EDITOR_WIDTH);
        textArea.setPrefHeight(EDITOR_HEIGHT - 40 - 30);
        textArea.setFocusTraversable(Objects.equals(textArea.getText(), "") || textArea.getText() == null);
        textArea.setWrapText(true);
        textArea.setBackground(BG_DARK);
        textArea.setBorder(new Border(new BorderStroke(PAINT_DARK, PAINT_DARK, PAINT_LIGHTDARK, PAINT_DARK, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT, Insets.EMPTY)));
        textArea.setStyle("-fx-text-fill: white");
        textArea.setFont(new Font(FONT_SC_BOLD.getName(), 15));

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
        group.getChildren().add(Title);
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
