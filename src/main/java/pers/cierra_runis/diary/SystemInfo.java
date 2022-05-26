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

    static final Rectangle2D rectangle2D = Screen.getPrimary().getBounds();
    
    static final double SCREEN_WIDTH = rectangle2D.getWidth();
    static final double PASSWORD_WIDTH = 0.9 * SCREEN_WIDTH * 25 / 192;
    static final double HOMEPAGE_WIDTH = SCREEN_WIDTH * 160 / 192;
    static final double DATE_WIDTH = SCREEN_WIDTH * 25 / 192;
    static final double EDITOR_WIDTH = SCREEN_WIDTH * 120 / 192;

    static final double SCREEN_HEIGHT = rectangle2D.getHeight();
    static final double PASSWORD_HEIGHT = 0.8 * SCREEN_HEIGHT * 5 / 108;
    static final double DATE_HEIGHT = PASSWORD_HEIGHT;
    static final double HOMEPAGE_HEIGHT = SCREEN_HEIGHT * 90 / 108;
    static final double EDITOR_HEIGHT = HOMEPAGE_HEIGHT * 0.8;

    static final String PASSWORD = "114";
    static final String APP_NAME = "我的日记";
    static final String DEFAULT_DATE = "19000101";

    static final Image ICON = new Image("file:src/main/resources/" + "icon/Icon.png");
    static final Image SETTING = new Image("file:src/main/resources/" + "icon/Setting.png");
    static final Image MINIMIZE = new Image("file:src/main/resources/" + "icon/Minimize.png");
    static final Image CLOSE = new Image("file:src/main/resources/" + "icon/Close.png");
    static final Image TIME = new Image("file:src/main/resources/" + "icon/Time.png");
    static final Image DELETE_UNPRESSED = new Image("file:src/main/resources/" + "icon/Delete_Unpressed.png");
    static final Image DELETE_PRESSED = new Image("file:src/main/resources/" + "icon/Delete_Pressed.png");
    static final Image ADD_UNPRESSED = new Image("file:src/main/resources/" + "icon/Add_Unpressed.png");
    static final Image ADD_PRESSED = new Image("file:src/main/resources/" + "icon/Add_Pressed.png");
    static final Image DATE = new Image("file:src/main/resources/" + "icon/Date.png");
    static final Image CONFIRM = new Image("file:src/main/resources/" + "icon/Confirm.png");
    static final Image EDIT_UNPRESSED = new Image("file:src/main/resources/" + "icon/Edit_Unpressed.png");
    static final Image EDIT_PRESSED = new Image("file:src/main/resources/" + "icon/Edit_Pressed.png");

    static final Font FONT_SC_BOLD = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Bold.ttf", 12);
    static final Font FONT_SC_HEAVY = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Heavy.ttf", 12);
    static final Font FONT_SC_MEDIUM = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Medium.ttf", 12);
    static final Font FONT_SC_NORMAL = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Normal.ttf", 12);
    static final Font FONT_SC_REGULAR = Font.loadFont("file:src/main/resources/" + "font/SourceHanSansCN-Regular.ttf", 12);

    static final Paint PAINT_DARK = Paint.valueOf("#333333");
    static final Paint PAINT_DARKER = Paint.valueOf("#21252B");
    static final Paint PAINT_RED = Paint.valueOf("#E81123");
    static final Paint PAINT_PINK = Paint.valueOf("#F1707A");
    static final Paint PAINT_GRAY = Paint.valueOf("#DDDDDD");
    static final Paint PAINT_LIGHTDARK = Paint.valueOf("#666666");
    static final Paint PAINT_LIGHTBLUE = Paint.valueOf("#8AB4F8");

    static final BackgroundFill BG_DARK_FILL = new BackgroundFill(PAINT_DARK, new CornerRadii(8), new Insets(0));
    static final Background BG_DARK = new Background(BG_DARK_FILL);

    static final BackgroundFill BG_DARKER_FILL = new BackgroundFill(PAINT_DARKER, new CornerRadii(8), new Insets(0));
    static final Background BG_DARKER = new Background(BG_DARKER_FILL);

    static final BackgroundFill BG_RED_FILL = new BackgroundFill(PAINT_RED, new CornerRadii(8), new Insets(0));
    static final Background BG_RED = new Background(BG_RED_FILL);

    static final BackgroundFill BG_PINK_FILL = new BackgroundFill(PAINT_PINK, new CornerRadii(8), new Insets(0));
    static final Background BG_PINK = new Background(BG_PINK_FILL);

    static final BackgroundFill BG_GRAY_FILL = new BackgroundFill(PAINT_GRAY, new CornerRadii(8), new Insets(0));
    static final Background BG_GRAY = new Background(BG_GRAY_FILL);


}
