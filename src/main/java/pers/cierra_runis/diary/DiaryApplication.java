package pers.cierra_runis.diary;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

class HitokotoResponse {
    public String hitokoto;
}

public class DiaryApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // File dir = new File("diarys/");
        // if (dir.mkdir()) {
        // System.out.println("diarys 文件夹创建成功");
        // } else if (dir.exists()) {
        // System.out.println("diarys 文件夹已经存在");
        // } else {
        // System.out.println("diarys 文件夹创建失败");
        // }
        //
        // if (PasswordWindow.display()) {
        // new Page().start(stage);
        // }

        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder().uri(URI.create("https://v1.hitokoto.cn")).GET().build();
        var gson = new Gson();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            var body = response.body();
            System.out.println(body);
            HitokotoResponse res = gson.fromJson(body, HitokotoResponse.class);
            System.out.println(res.hitokoto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
