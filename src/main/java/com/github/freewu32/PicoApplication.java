package com.github.freewu32;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PicoApplication extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(800,600);
        canvas.getGraphicsContext2D()
                .fillRect(100,100,200,200);

        Group root = new Group(canvas);
        root.setAutoSizeChildren(true);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        PicoApplication.launch(args);
    }
}
