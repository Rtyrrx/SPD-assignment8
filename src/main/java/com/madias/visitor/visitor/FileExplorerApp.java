package com.madias.visitor.visitor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FileExplorerApp extends Application {

    private ListView<FSItem> listView;
    private Label iconLabel;
    private Label infoLabel;
    private Label sizeLabel;

    private final IconVisitor iconVisitor = new IconVisitor();
    private final InfoVisitor infoVisitor = new InfoVisitor();
    private final SizeVisitor sizeVisitor = new SizeVisitor();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        listView = new ListView<>();
        listView.setPrefHeight(300);

        loadSampleItems();

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                displayItemDetails(newVal);
            }
        });

        VBox infoPanel = createInfoPanel();

        root.setCenter(listView);
        root.setBottom(infoPanel);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("File Explorer - Visitor Pattern Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createInfoPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.setAlignment(Pos.CENTER_LEFT);
        panel.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 1;");

        Label titleLabel = new Label("Item Details:");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

        iconLabel = new Label("Icon: -");
        iconLabel.setStyle("-fx-font-size: 24;");

        infoLabel = new Label("Info: Select an item");
        infoLabel.setStyle("-fx-font-size: 12;");

        sizeLabel = new Label("Size: -");
        sizeLabel.setStyle("-fx-font-size: 12;");

        panel.getChildren().addAll(titleLabel, iconLabel, infoLabel, sizeLabel);

        return panel;
    }

    private void loadSampleItems() {
        listView.getItems().add(new FolderItem("Documents", 15));
        listView.getItems().add(new FolderItem("Pictures", 42));
        listView.getItems().add(new FolderItem("Videos", 8));
        listView.getItems().add(new FolderItem("Downloads", 123));
        listView.getItems().add(new FileItem("notes.txt", 2048));
        listView.getItems().add(new FileItem("music.mp3", 3145728));
        listView.getItems().add(new FileItem("report.pdf", 512000));
        listView.getItems().add(new FileItem("photo.jpg", 2097152));
    }

    private void displayItemDetails(FSItem item) {
        item.accept(iconVisitor);
        String icon = iconVisitor.getResult();

        item.accept(infoVisitor);
        String info = infoVisitor.getResult();

        item.accept(sizeVisitor);
        long size = sizeVisitor.getResult();

        iconLabel.setText("Icon: " + icon);
        infoLabel.setText("Info: " + info);
        sizeLabel.setText(String.format("Size: %,d bytes (%.2f KB)", size, size / 1024.0));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
