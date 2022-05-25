package pers.cierra_runis.diary;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class SystemInfo {

    static Rectangle2D rectangle2D = Screen.getPrimary().getBounds();
    static double SCREEN_WIDTH = rectangle2D.getWidth();
    static double PASSWORD_WIDTH = 0.9 * SCREEN_WIDTH * 25 / 192;
    static double HOMEPAGE_WIDTH = SCREEN_WIDTH * 160 / 192;
    static double DATE_WIDTH = SCREEN_WIDTH * 25 / 192;
    static double EDITOR_WIDTH = SCREEN_WIDTH * 120 / 192;

    static double SCREEN_HEIGHT = rectangle2D.getHeight();
    static double PASSWORD_HEIGHT = 0.8 * SCREEN_HEIGHT * 5 / 108;
    static double DATE_HEIGHT = PASSWORD_HEIGHT;
    static double HOMEPAGE_HEIGHT = SCREEN_HEIGHT * 90 / 108;
    static double EDITOR_HEIGHT = HOMEPAGE_HEIGHT * 0.8;

    static String PASSWORD = "114";
    static String APP_NAME = "我的日记";

    static Image ICON = new Image("file:src/main/resources/" + "icon/Icon.png");
    static Image SETTING = new Image("file:src/main/resources/" + "icon/Setting.png");
    static Image MINIMIZE = new Image("file:src/main/resources/" + "icon/Minimize.png");
    static Image CLOSE = new Image("file:src/main/resources/" + "icon/Close.png");
    static Image TIME = new Image("file:src/main/resources/" + "icon/Time.png");
    static Image DELETE_UNPRESSED = new Image("file:src/main/resources/" + "icon/Delete_Unpressed.png");
    static Image DELETE_PRESSED = new Image("file:src/main/resources/" + "icon/Delete_Pressed.png");
    static Image ADD_UNPRESSED = new Image("file:src/main/resources/" + "icon/Add_Unpressed.png");
    static Image ADD_PRESSED = new Image("file:src/main/resources/" + "icon/Add_Pressed.png");
    static Image DATE = new Image("file:src/main/resources/" + "icon/Date.png");
    static Image CONFIRM = new Image("file:src/main/resources/" + "icon/Confirm.png");
    static Image EDIT_UNPRESSED = new Image("file:src/main/resources/" + "icon/Edit_Unpressed.png");
    static Image EDIT_PRESSED = new Image("file:src/main/resources/" + "icon/Edit_Pressed.png");

    static Font FONT_SC_BOLD = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Bold.ttf", 12);
    static Font FONT_SC_EXTRALIGHT = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-ExtraLight.ttf", 12);
    static Font FONT_SC_HEAVY = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Heavy.ttf", 12);
    static Font FONT_SC_LIGHT = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Light.ttf", 12);
    static Font FONT_SC_MEDIUM = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Medium.ttf", 12);
    static Font FONT_SC_NORMAL = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Normal.ttf", 12);
    static Font FONT_SC_REGULAR = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Regular.ttf", 12);

    static Paint PAINT_DARK = Paint.valueOf("#333333");
    static Paint PAINT_DARKER = Paint.valueOf("#21252B");
    static Paint PAINT_RED = Paint.valueOf("#E81123");
    static Paint PAINT_PINK = Paint.valueOf("#F1707A");
    static Paint PAINT_GRAY = Paint.valueOf("#DDDDDD");
    static Paint PAINT_LIGHTDARK = Paint.valueOf("#666666");

    static BackgroundFill BG_DARK_FILL = new BackgroundFill(PAINT_DARK, new CornerRadii(8), new Insets(0));
    static Background BG_DARK = new Background(BG_DARK_FILL);

    static BackgroundFill BG_DARKER_FILL = new BackgroundFill(PAINT_DARKER, new CornerRadii(8), new Insets(0));
    static Background BG_DARKER = new Background(BG_DARKER_FILL);

    static BackgroundFill BG_RED_FILL = new BackgroundFill(PAINT_RED, new CornerRadii(8), new Insets(0));
    static Background BG_RED = new Background(BG_RED_FILL);

    static BackgroundFill BG_PINK_FILL = new BackgroundFill(PAINT_PINK, new CornerRadii(8), new Insets(0));
    static Background BG_PINK = new Background(BG_PINK_FILL);

    static BackgroundFill BG_GRAY_FILL = new BackgroundFill(PAINT_GRAY, new CornerRadii(8), new Insets(0));
    static Background BG_GRAY = new Background(BG_GRAY_FILL);

    static BackgroundFill BG_LIGHTDARK_FILL = new BackgroundFill(PAINT_LIGHTDARK, new CornerRadii(8), new Insets(0));
    static Background BG_LIGHTDARK = new Background(BG_LIGHTDARK_FILL);

}
