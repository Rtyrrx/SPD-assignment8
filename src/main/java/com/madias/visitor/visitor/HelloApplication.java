package com.madias.visitor.visitor;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        FileExplorerApp app = new FileExplorerApp();
        app.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}