package pers.cierra_runis.diary;

import java.io.*;
import java.util.Objects;

public class Diary {

    String date;
    String title = "无标题";
    String text = "";

//    TODO: 添加图片显示功能
//    int imageIndex = 0;
//    Image[] images;
//    String[] images_name;

    public Diary(String date) {
        this.date = date;
        if (Base.isDate(date)) {
            readDiary();
        } else {
            this.date = "197801010600";
        }
    }

    public void saveDiary(String title, String text) {

        File dir = new File("diarys/" + date);
        if (dir.mkdir()) {
            System.out.println("文件夹创建成功");
        }
        File file = new File("diarys/" + date + "/" + title + ".txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        readDiary();
    }

    public void readDiary() {

        File file = new File("diarys/" + date);
        if (!file.exists()) {
            System.out.printf("该日期对应文件夹 (%s) 不存在\n", file.getPath());
        } else {

            File[] files = file.listFiles();

            if (Objects.requireNonNull(files).length != 0) {
                for (File f : files) {

                    if (f.getName().endsWith(".txt")) {
                        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                text = text.concat(line + "\n");
                            }
                            title = f.getName().substring(0, f.getName().length() - 4);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    //TODO: 添加图片显示功能
                    /*else if (f.getName().endsWith(".jpg") || f.getName().endsWith(".png")) {
                        images[imageIndex] = new Image("file:/diarys" + date + "/" + f.getName());
                        images_name[imageIndex] = f.getName().substring(0, f.getName().length() - 4);
                        imageIndex++;
                    }*/
                    else {
                        System.out.println("哪来的垃圾？");
                    }
                }
            } else {
                System.out.println("该日期对应文件夹下无文件");
            }
        }
    }

    public void deleteDiary() {
        File file = new File("diarys/" + date);
        if (!file.exists()) {
            System.out.printf("该日期对应文件夹 (%s) 不存在\n", file.getPath());
        } else {
            System.out.printf("该日期对应文件夹 (%s) 存在\n", file.getPath());
            if (Base.delFiles(file)) {
                System.out.printf("该日期对应文件夹 (%s) 已删除\n", file.getPath());
            } else {
                System.out.println("未删除");
            }
        }
    }

    public boolean isDateExisted(String date) {
        File file = new File("diarys");
        File[] files = file.listFiles();
        for (File f : Objects.requireNonNull(files)) {
            if (f.isDirectory() && Objects.equals(date, f.getName().substring(0, 8))) {
                return true;
            }
        }
        return false;
    }

    public String[] textToStrings() {
        return text.split("\n");
    }

    public String stringsToText(String[] strings) {
        String result = "";
        for (String string : strings) {
            result = result.concat(string + "\n");
        }
        return result;
    }

}
