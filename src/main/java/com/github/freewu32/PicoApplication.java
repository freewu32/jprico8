package com.github.freewu32;

import com.github.freewu32.game.PicoGame;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class PicoApplication extends javafx.application.Application {

    private PicoGame picoGame;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(800, 600);
        this.picoGame = new PicoGame(canvas);

        Group root = new Group(canvas);
        root.setAutoSizeChildren(true);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        //TODO 测试加载rom
        getPicoGame().loadForPath("D:\\javaProject\\jprico8\\src\\test\\" +
                "resources\\rom\\jelpi.p8.png");
    }

    public PicoGame getPicoGame() {
        return picoGame;
    }

    public static void main(String[] args) {
        PicoApplication.launch(args);
    }
}
