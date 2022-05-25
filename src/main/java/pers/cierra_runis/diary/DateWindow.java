package pers.cierra_runis.diary;


import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Calendar;
import java.util.Objects;

import static pers.cierra_runis.diary.SystemInfo.*;

public class DateWindow {
    public static String date;

    public static String display() {

        Calendar calendar = Calendar.getInstance();

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        Button autoDateFill = new Button("");
        autoDateFill.setPrefWidth(25);
        autoDateFill.setPrefHeight(25);
        autoDateFill.setAlignment(Pos.CENTER);
        autoDateFill.setBackground(new Background(new BackgroundImage(DATE, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(25, 25, false, false, false, false))));
        HBox AutoFill = new HBox(autoDateFill);
        AutoFill.setPrefWidth(25);
        AutoFill.setPrefHeight(25);
        AutoFill.setLayoutX(12.5);
        AutoFill.setLayoutY(3);
        autoDateFill.setOnMouseEntered(mouseEvent -> AutoFill.setBackground(BG_DARK));
        autoDateFill.setOnMouseExited(mouseEvent -> AutoFill.setBackground(null));

        TextField year = new TextField();
        year.setPrefWidth(48);
        year.setPrefHeight(0.8 * DATE_HEIGHT);
        year.setLayoutX(50);
        year.setLayoutY(3);
        year.setBackground(BG_DARK);
        year.setPromptText("年");
        year.setStyle("-fx-text-fill: white; -fx-alignment: center");
        year.textProperty().addListener((observableValue, s, t1) -> {
            if (t1.length() > 4) {
                year.setText(s);
            }
        });
        year.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
            //当失去焦点时
            if (!t1) {
                if (!Base.isIntNumber(year.getText(), 4) || Objects.equals(year.getText(), "") || Integer.parseInt(year.getText()) <= 1978) {
                    System.out.println("年份格式是四位,年份不能为空，不能为小数，且年份应大于 1978 年");
                    year.requestFocus();
                }
            }
        });

        TextField month = new TextField();
        month.setPrefWidth(30);
        month.setPrefHeight(0.8 * DATE_HEIGHT);
        month.setLayoutX(107);
        month.setLayoutY(3);
        month.setBackground(BG_DARK);
        month.setPromptText("月");
        month.setStyle("-fx-text-fill: white; -fx-alignment: center");
        month.textProperty().addListener((observableValue, s, t1) -> {
            if (t1.length() > 2) {
                month.setText(s);
            }
        });
        month.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
            //当失去焦点时
            if (!t1) {
                if (!(Base.isIntNumber(month.getText(), 2) || Base.isIntNumber(month.getText(), 1)) || Objects.equals(month.getText(), "") || Integer.parseInt(month.getText()) < 1 || Integer.parseInt(month.getText()) > 12) {
                    System.out.println("月份格式是两位,月份不能为空，不能为小数，且月份是 01 至 12 月");
                    month.requestFocus();
                }
                if (month.getText().length() == 1) {
                    month.setText("0" + month.getText());
                }
            }
        });

        TextField day = new TextField();
        day.setPrefWidth(30);
        day.setPrefHeight(0.8 * DATE_HEIGHT);
        day.setLayoutX(147);
        day.setLayoutY(3);
        day.setBackground(BG_DARK);
        day.setPromptText("日");
        day.setStyle("-fx-text-fill: white; -fx-alignment: center");
        day.textProperty().addListener((observableValue, s, t1) -> {
            if (t1.length() > 2) {
                day.setText(s);
            }
        });
        day.setOnMouseClicked(mouseEvent -> {
            if (year.getText() == null || Objects.equals(year.getText(), "")) {
                System.out.println("请先输入年份");
                year.requestFocus();
            } else if (month.getText() == null || Objects.equals(month.getText(), "")) {
                System.out.println("请先输入月份");
                month.requestFocus();
            }
        });
        day.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
            //当失去焦点时
            if (!t1) {
                if (!(year.getText() == null || Objects.equals(year.getText(), "") || month.getText() == null || Objects.equals(month.getText(), ""))) {
                    if (!(Base.isIntNumber(day.getText(), 2) || Base.isIntNumber(day.getText(), 1)) || Objects.equals(day.getText(), "") || (Integer.parseInt(day.getText()) < 1) || (Integer.parseInt(day.getText()) > Base.getDayOfMonth(Integer.parseInt(year.getText()), Integer.parseInt(month.getText())))) {
                        System.out.println("日份格式是两位,日份不能为空，不能为小数，且日份在 01 至 Base 类所含 getDayOfMonth() 方法返回的天数");
                        day.requestFocus();
                    }
                    if (day.getText().length() == 1) {
                        day.setText("0" + day.getText());
                    }
                }
            }
        });


        autoDateFill.setOnMouseClicked(mouseEvent -> {
            year.setText(String.valueOf(calendar.get(Calendar.YEAR)));
            month.setText(String.valueOf(calendar.get(Calendar.MONTH) + 1));
            day.setText(String.valueOf(calendar.get(Calendar.DATE)));
            if (month.getText().length() == 1) {
                month.setText("0" + month.getText());
            }
            if (day.getText().length() == 1) {
                day.setText("0" + day.getText());
            }
        });

        Button confirm = new Button("");
        confirm.setPrefWidth(25);
        confirm.setPrefHeight(25);
        confirm.setAlignment(Pos.CENTER);
        confirm.setBackground(new Background(new BackgroundImage(CONFIRM, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(20, 20, false, false, false, false))));
        HBox Confirm = new HBox(confirm);
        Confirm.setPrefWidth(20);
        Confirm.setPrefHeight(20);
        Confirm.setLayoutX(188);
        Confirm.setLayoutY(4);
        confirm.setOnMouseEntered(mouseEvent -> Confirm.setBackground(BG_DARK));
        confirm.setOnMouseExited(mouseEvent -> Confirm.setBackground(null));
        confirm.setOnMouseClicked(mouseEvent -> {

            if (year.getText() == null || Objects.equals(year.getText(), "")) {
                System.out.println("请先输入年份");
                year.requestFocus();
            } else if (month.getText() == null || Objects.equals(month.getText(), "")) {
                System.out.println("请先输入月份");
                month.requestFocus();
            } else if (day.getText() == null || Objects.equals(day.getText(), "")) {
                System.out.println("请先输入月份");
                day.requestFocus();
            } else {
                String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
                if (hour.length() == 1) {
                    hour = "0" + hour;
                }
                String minute = String.valueOf(calendar.get(Calendar.MINUTE));
                if (minute.length() == 1) {
                    minute = "0" + minute;
                }
                String second = String.valueOf(calendar.get(Calendar.SECOND));
                if (second.length() == 1) {
                    second = "0" + second;
                }

                String s = year.getText() + month.getText() + day.getText();
                String str = s + hour + minute + second;

                //保险的判断
                if (Base.isDate(str)) {
                    if (new Diary(str).isDateExisted(s)) {
                        System.out.println("日期已存在");
                    } else {
                        date = str;
                        stage.close();
                    }
                } else {
                    System.out.println("注意，程序不应进行到这里");
                }

            }
        });

        //底衬
        Label label = new Label("");
        HBox Label = new HBox(label);
        Label.setLayoutX(0);
        Label.setLayoutY(0);
        Label.setPrefWidth(DATE_WIDTH);
        Label.setPrefHeight(DATE_HEIGHT);
        Label.setBackground(BG_DARKER);
        Label.setAlignment(Pos.CENTER);


        Group group = new Group();
        group.getChildren().add(Label);
        group.getChildren().add(AutoFill);
        group.getChildren().add(year);
        group.getChildren().add(month);
        group.getChildren().add(day);
        group.getChildren().add(Confirm);


        Scene scene = new Scene(group);
        scene.setFill(null);

        //定位
        stage.setX((SCREEN_WIDTH - DATE_WIDTH) / 2);
        stage.setY((SCREEN_HEIGHT - DATE_HEIGHT) / 2);

        //配置
        stage.setTitle("输入日期");
        stage.getIcons().add(ICON);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setWidth(DATE_WIDTH);
        stage.setHeight(DATE_HEIGHT);
        stage.setOpacity(0.9);

        //布局
        stage.setScene(scene);

        //显示
        stage.showAndWait();

        return date;
    }

}
