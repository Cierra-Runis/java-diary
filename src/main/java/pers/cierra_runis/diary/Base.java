package pers.cierra_runis.diary;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class Base {
    public static boolean isDate(String dateStr) {
        String timeRegex = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|" +
                "((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))" +
                "([0-1][0-9]|2[0-3])([0-5][0-9])([0-5][0-9])$";
        return Pattern.matches(timeRegex, dateStr);
    }

    public static boolean isTimeLabel(String dataStr) {
        String timeLabelRegex = "^.*\\[(?:[01]\\d|2[0-3])(?::[0-5]\\d){2}\\].*$";
        return Pattern.matches(timeLabelRegex, dataStr);
    }

    public static String dateToWeek(String datetime) {

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date = null;
        try {
            date = f.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(Objects.requireNonNull(date));
        //一周的第几天
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static boolean delFiles(File file) {

        boolean result = false;
        if (file.isDirectory()) {
            File[] childrenFiles = file.listFiles();

            for (File childFile : Objects.requireNonNull(childrenFiles)) {
                result = delFiles(childFile);
                if (!result) {
                    return result;
                }
            }
        }
        result = file.delete();
        return result;
    }

    public static boolean isIntNumber(String str, int length) {
        try {
            int num = Integer.parseInt(str);
            return String.valueOf(num).length() == length;
        } catch (Exception e) {
            return false;
        }
    }

    public static int getDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, 0); //输入类型为int类型
        return c.get(Calendar.DAY_OF_MONTH);
    }

}