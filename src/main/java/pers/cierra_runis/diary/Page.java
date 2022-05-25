package pers.cierra_runis.diary;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.Objects;

import static pers.cierra_runis.diary.SystemInfo.*;

public class Page extends Application {

    double x1;
    double y1;
    double x_stage;
    double y_stage;

    String date;
    String[] str;

    public Page(String date) {
        this.date = date;
        this.str = new Diary(date).textToStrings();
    }

    public Page() {
        File[] files = new File("diarys/").listFiles();
        if (Objects.requireNonNull(files).length != 0) {
            for (File file : files) {
                if (file.isDirectory() && Base.isDate(file.getName())) {
                    this.date = file.getName();
                    this.str = new Diary(date).textToStrings();
                }
            }
        } else {
            this.date = "197801010600";
            this.str = new String[]{"你还没有写过日记。"};
        }

    }

    @Override
    public void start(Stage stage) {

        //标题左部
        Button setting = new Button("");
        setting.setPrefWidth(50);
        setting.setPrefHeight(30);
        setting.setAlignment(Pos.CENTER);
        setting.setBackground(new Background(new BackgroundImage(SETTING, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(20, 18, false, false, false, false))));
        HBox Title_Left = new HBox(setting);
        Title_Left.setPrefWidth(50);
        Title_Left.setPrefHeight(30);
        Title_Left.setLayoutX(0);
        Title_Left.setLayoutY(0);
        setting.setOnMouseEntered(mouseEvent -> Title_Left.setBackground(BG_DARK));
        setting.setOnMouseExited(mouseEvent -> Title_Left.setBackground(null));
        //TODO: 单击事件

        //标题右部
        Button minimize = new Button("");
        minimize.setPrefWidth(50);
        minimize.setPrefHeight(30);
        minimize.setBackground(new Background(new BackgroundImage(MINIMIZE, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(20, 20, false, false, false, false))));
        HBox Title_Right_MINIMIZE = new HBox(minimize);
        Title_Right_MINIMIZE.setPrefWidth(50);
        Title_Right_MINIMIZE.setPrefHeight(30);
        Title_Right_MINIMIZE.setLayoutX(HOMEPAGE_WIDTH - 2 * 50);
        Title_Right_MINIMIZE.setLayoutY(0);
        minimize.setOnMouseEntered(mouseEvent -> Title_Right_MINIMIZE.setBackground(BG_DARK));
        minimize.setOnMouseExited(mouseEvent -> Title_Right_MINIMIZE.setBackground(null));
        minimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));

        Button close = new Button("");
        close.setPrefWidth(50);
        close.setPrefHeight(30);
        close.setBackground(new Background(new BackgroundImage(CLOSE, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(25, 25, false, false, false, false))));
        HBox Title_Right_CLOSE = new HBox(close);
        Title_Right_CLOSE.setPrefWidth(50);
        Title_Right_CLOSE.setPrefHeight(30);
        Title_Right_CLOSE.setLayoutX(HOMEPAGE_WIDTH - 50);
        Title_Right_CLOSE.setLayoutY(0);
        close.setOnMouseEntered(mouseEvent -> Title_Right_CLOSE.setBackground(BG_RED));
        close.setOnMouseExited(mouseEvent -> Title_Right_CLOSE.setBackground(null));
        close.setOnMousePressed(mouseEvent -> Title_Right_CLOSE.setBackground(BG_PINK));
        close.setOnMouseClicked(mouseEvent -> stage.close());

        //标题底衬
        Label title = new Label(APP_NAME + " - " + date);
        title.setFont(FONT_SC_NORMAL);
        title.setTextFill(Color.LIGHTGRAY);
        HBox Title = new HBox(title);
        Title.setPrefWidth(HOMEPAGE_WIDTH);
        Title.setPrefHeight(30);
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

        //左栏
        VBox Left = new VBox();
        Left.setSpacing(8);
        Left.setPrefWidth(0.2 * HOMEPAGE_WIDTH);
        Left.setPrefHeight(HOMEPAGE_WIDTH * HOMEPAGE_HEIGHT);
        Left.setLayoutX(0);
        Left.setLayoutY(30);
        Left.setBorder(new Border(new BorderStroke(PAINT_DARK, PAINT_LIGHTDARK, PAINT_DARK, PAINT_DARK, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT, Insets.EMPTY)));
        Left.setSpacing(8);

        //左部工具栏
        Button add = new Button("");
        add.setPrefWidth(30);
        add.setPrefHeight(30);
        add.setAlignment(Pos.CENTER);
        add.setBackground(new Background(new BackgroundImage(ADD_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false))));
        add.setLayoutX(12);
        add.setLayoutY(35);
        add.setOnMousePressed(mouseEvent -> add.setBackground(new Background(new BackgroundImage(ADD_PRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false)))));
        add.setOnMouseExited(mouseEvent -> add.setBackground(new Background(new BackgroundImage(ADD_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false)))));
        add.setOnMouseClicked(mouseEvent -> {
            stage.setOpacity(0.6);
            String dateFromDateWindow = DateWindow.display();
            stage.close();
            if (dateFromDateWindow != null && !dateFromDateWindow.equals("")) {
                new Editor(dateFromDateWindow).display();
                new Page(dateFromDateWindow).start(new Stage());
            } else {
                new Page().start(new Stage());
            }
        });

        //工具底衬
        Label left_tool = new Label("");
        HBox Left_Tool = new HBox(left_tool);
        Left_Tool.setPrefWidth(0.2 * HOMEPAGE_WIDTH);
        Left_Tool.setPrefHeight(41);
        Left_Tool.setLayoutX(0);
        Left_Tool.setLayoutY(30);
        Left_Tool.setBackground(BG_DARK);
        Left_Tool.setBorder(new Border(new BorderStroke(PAINT_DARK, PAINT_LIGHTDARK, PAINT_LIGHTDARK, PAINT_DARK, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT, Insets.EMPTY)));
        Left_Tool.setAlignment(Pos.CENTER);


        //中栏
        VBox Middle = new VBox();
        Middle.setLayoutX(0.23 * HOMEPAGE_WIDTH);
        Middle.setLayoutY(30);
        Middle.setPrefWidth(0.54 * HOMEPAGE_WIDTH);
        Middle.setPrefHeight(HOMEPAGE_WIDTH * HOMEPAGE_HEIGHT);
        Middle.setSpacing(8);

        VBox UpMiddle = new VBox();
        UpMiddle.setLayoutX(0);
        UpMiddle.setLayoutY(0);
        UpMiddle.setPrefWidth(0.54 * HOMEPAGE_WIDTH);
        UpMiddle.setBorder(new Border(new BorderStroke(PAINT_DARK, PAINT_DARK, PAINT_LIGHTDARK, PAINT_DARK, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT, Insets.EMPTY)));

        Pane pane = new Pane();
        String dateformat = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);

        Text up = new Text(date.substring(0, 4) + "年，" + Integer.valueOf(date.substring(4, 6)) + "月");
        up.setFont(new Font(FONT_SC_MEDIUM.getName(), 15));
        up.setFill(PAINT_GRAY);
        up.setSmooth(true);
        up.setLayoutX((0.54 * HOMEPAGE_WIDTH - up.getBoundsInLocal().getWidth()) / 2);
        up.setLayoutY(40);

        Text middle = new Text(Integer.valueOf(date.substring(6, 8)).toString());
        middle.setFont(new Font(FONT_SC_BOLD.getName(), 50));
        middle.setFill(PAINT_GRAY);
        middle.setSmooth(true);
        middle.setLayoutX((0.54 * HOMEPAGE_WIDTH - middle.getBoundsInLocal().getWidth()) / 2);
        middle.setLayoutY(90);

        Text down = new Text(Base.dateToWeek(dateformat) + "  " + date.substring(8, 10) + ":" + date.substring(10, 12));
        down.setFont(new Font(FONT_SC_REGULAR.getName(), 15));
        down.setFill(PAINT_GRAY);
        down.setSmooth(true);
        down.setLayoutX((0.54 * HOMEPAGE_WIDTH - down.getBoundsInLocal().getWidth()) / 2);
        down.setLayoutY(120);

        pane.getChildren().add(up);
        pane.getChildren().add(middle);
        pane.getChildren().add(down);
        pane.setPrefHeight(150);
        UpMiddle.getChildren().add(pane);


        VBox DownMiddle = new VBox();
        DownMiddle.setLayoutX(50);
        DownMiddle.setLayoutY(10);
        DownMiddle.setPrefWidth(0.54 * HOMEPAGE_WIDTH);
        DownMiddle.setPrefHeight(HOMEPAGE_HEIGHT - 233);
        DownMiddle.setSpacing(8);


        for (String s : str) {
            HBox hBox = new HBox();

            if (Base.isTimeLabel(s)) {

                Pane time_part = new Pane();

                Label time_icon = new Label();
                time_icon.setPrefWidth(45);
                time_icon.setMinHeight(25);
                time_icon.setLayoutX(0);
                time_icon.setLayoutY(0);
                time_icon.setBackground(new Background(new BackgroundImage(TIME, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(20, 20, false, false, false, false))));
                time_icon.setAlignment(Pos.CENTER_LEFT);

                Text text = new Text(s + "  ");
                text.setSmooth(true);
                text.setFont(new Font(FONT_SC_BOLD.getName(), 15));
                text.setFill(PAINT_LIGHTDARK);
                text.setLayoutX(45);
                text.setLayoutY(18);
                text.prefWidth(45);
                text.setWrappingWidth(text.getBoundsInLocal().getWidth());

                time_part.setBackground(BG_GRAY);
                time_part.getChildren().add(text);
                time_part.getChildren().add(time_icon);
                time_part.setMinHeight(25);
                HBox hBox1 = new HBox(time_part);
                hBox.getChildren().add(hBox1);

            } else {
                Text text = new Text(s);
                text.setSmooth(true);
                text.setFont(new Font(FONT_SC_BOLD.getName(), 15));
                text.setFill(PAINT_GRAY);
                text.prefWidth(0.54 * HOMEPAGE_WIDTH);
                text.setWrappingWidth(0.54 * HOMEPAGE_WIDTH);
                hBox.getChildren().add(text);
            }
            DownMiddle.getChildren().add(hBox);
        }

        Middle.getChildren().add(UpMiddle);
        Middle.getChildren().add(DownMiddle);
        Middle.setOnMouseDragged(mouseEvent -> {

            if ((HOMEPAGE_HEIGHT - UpMiddle.getHeight() - DownMiddle.getHeight() - 50) >= 30) {
                System.out.println("不滑动");
            } else {
                Middle.setLayoutY(y_stage + mouseEvent.getScreenY() - y1);
                if (Middle.getLayoutY() < (HOMEPAGE_HEIGHT - UpMiddle.getHeight() - DownMiddle.getHeight() - 50)) {
                    Middle.setLayoutY(HOMEPAGE_HEIGHT - UpMiddle.getHeight() - DownMiddle.getHeight() - 50);
                }
                if (Middle.getLayoutY() > 30) {
                    Middle.setLayoutY(30);
                }
            }

        });
        Middle.setOnScroll(scrollEvent -> {

            y1 -= scrollEvent.getDeltaY();
            y_stage = Middle.getLayoutY();

            if ((HOMEPAGE_HEIGHT - UpMiddle.getHeight() - DownMiddle.getHeight() - 50) >= 30) {
                System.out.println("不滑动");
            } else {
                Middle.setLayoutY(y_stage + scrollEvent.getDeltaY() - y1);
                if (Middle.getLayoutY() < (HOMEPAGE_HEIGHT - UpMiddle.getHeight() - DownMiddle.getHeight() - 50)) {
                    Middle.setLayoutY(HOMEPAGE_HEIGHT - UpMiddle.getHeight() - DownMiddle.getHeight() - 50);
                }
                if (Middle.getLayoutY() > 30) {
                    Middle.setLayoutY(30);
                }
            }

            y1 = 0;

        });
        Middle.setOnMousePressed(mouseEvent -> {
            y1 = mouseEvent.getScreenY();
            y_stage = Middle.getLayoutY();
        });


        //底部工具栏
        Button delete = new Button("");
        delete.setPrefWidth(30);
        delete.setPrefHeight(30);
        delete.setAlignment(Pos.CENTER);
        delete.setBackground(new Background(new BackgroundImage(DELETE_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false))));
        delete.setLayoutX(0.2 * HOMEPAGE_WIDTH + 35);
        delete.setLayoutY(HOMEPAGE_HEIGHT - 35);
        delete.setOnMousePressed(mouseEvent -> {
            if (!Objects.equals(date, "197801010600")) {
                delete.setBackground(new Background(new BackgroundImage(DELETE_PRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false))));
            }
        });
        delete.setOnMouseReleased(mouseEvent -> delete.setBackground(new Background(new BackgroundImage(DELETE_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false)))));
        delete.setOnMouseExited(mouseEvent -> delete.setBackground(new Background(new BackgroundImage(DELETE_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false)))));
        delete.setOnMouseClicked(mouseEvent -> {
            if (!Objects.equals(date, "197801010600")) {
                stage.setOpacity(0.6);
                if (AlertWindow.display("删除确认", "是否删除")) {
                    if (PasswordWindow.display()) {
                        new Diary(date).deleteDiary();
                        stage.close();
                        new Page().start(new Stage());
                    }
                }
                stage.setOpacity(0.9);
            }
        });

        Button edit = new Button("");
        edit.setPrefWidth(30);
        edit.setPrefHeight(30);
        edit.setAlignment(Pos.CENTER);
        edit.setBackground(new Background(new BackgroundImage(EDIT_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false))));
        edit.setLayoutX(0.8 * HOMEPAGE_WIDTH - 65);
        edit.setLayoutY(HOMEPAGE_HEIGHT - 35);
        edit.setOnMousePressed(mouseEvent -> {
            if (!Objects.equals(date, "197801010600")) {
                edit.setBackground(new Background(new BackgroundImage(EDIT_PRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false))));
            }
        });
        edit.setOnMouseReleased(mouseEvent -> edit.setBackground(new Background(new BackgroundImage(EDIT_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false)))));
        edit.setOnMouseExited(mouseEvent -> edit.setBackground(new Background(new BackgroundImage(EDIT_UNPRESSED, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(30, 30, false, false, false, false)))));
        edit.setOnMouseClicked(mouseEvent -> {
            if (!Objects.equals(date, "197801010600")) {
                stage.close();
                new Editor(date).display();
                new Page(date).start(new Stage());
            }
        });

        //工具底衬
        Label tool = new Label("");
        HBox Tool = new HBox(tool);
        Tool.setPrefWidth(0.6 * HOMEPAGE_WIDTH);
        Tool.setPrefHeight(41);
        Tool.setLayoutX(0.2 * HOMEPAGE_WIDTH);
        Tool.setLayoutY(HOMEPAGE_HEIGHT - 40);
        Tool.setBackground(BG_DARK);
        Tool.setBorder(new Border(new BorderStroke(PAINT_LIGHTDARK, PAINT_DARK, PAINT_DARK, PAINT_DARK, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT, Insets.EMPTY)));
        Tool.setAlignment(Pos.CENTER);

        //右栏
        VBox Right = new VBox();
        Right.setSpacing(8);
        Right.setPrefWidth(0.2 * HOMEPAGE_WIDTH);
        Right.setPrefHeight(HOMEPAGE_WIDTH * HOMEPAGE_HEIGHT);
        Right.setLayoutX(0.8 * HOMEPAGE_WIDTH);
        Right.setLayoutY(30);
        Right.setBorder(new Border(new BorderStroke(PAINT_DARK, PAINT_DARK, PAINT_DARK, PAINT_LIGHTDARK, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT, Insets.EMPTY)));

        HBox Body = new HBox();
        Body.setPrefWidth(HOMEPAGE_WIDTH);
        Body.setPrefHeight(HOMEPAGE_HEIGHT);
        Body.setBackground(BG_DARK);


        Group group = new Group();
        group.getChildren().add(Body);
        group.getChildren().add(Left);
        group.getChildren().add(Middle);
        group.getChildren().add(Right);
        group.getChildren().add(Title);
        group.getChildren().add(Title_Left);
        group.getChildren().add(Title_Right_MINIMIZE);
        group.getChildren().add(Title_Right_CLOSE);
        group.getChildren().add(Tool);
        group.getChildren().add(Left_Tool);
        group.getChildren().add(delete);
        group.getChildren().add(edit);
        group.getChildren().add(add);

        Scene scene = new Scene(group);
        scene.setFill(null);

        //定位
        stage.setX((SCREEN_WIDTH - HOMEPAGE_WIDTH) / 2);
        stage.setY((SCREEN_HEIGHT - HOMEPAGE_HEIGHT) / 2);

        //配置
        stage.setTitle(APP_NAME);
        stage.getIcons().add(ICON);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setWidth(HOMEPAGE_WIDTH);
        stage.setHeight(HOMEPAGE_HEIGHT);
        stage.setOpacity(0.9);

        //布局
        stage.setScene(scene);

        //显示
        stage.show();

    }
}
