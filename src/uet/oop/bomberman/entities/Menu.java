package uet.oop.bomberman.entities;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.entities.level.level1;

import static uet.oop.bomberman.BombermanGame.*;

// menu game
public class Menu {
    private static ImageView statusGame; // hinh anh trang thai tro choi
    public static Text level, bomb, time; // cac doan text hien thi thong tin
    public static int bombNumber = 20, timeNumber = 120; // so bomb va time con lai

    // tao menu
    public static void createMenu(Group root) {
        level = new Text("Level: 1");// bat dau voi level 1
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.WHITE);
        level.setX(416);
        level.setY(20);
        bomb = new Text("Bombs: 20");// bat dau voi 20 bomb
        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bomb.setFill(Color.WHITE);
        bomb.setX(512);
        bomb.setY(20);
        time = new Text("Times: 120");// bat dau voi 120s
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.WHITE);
        time.setX(608);
        time.setY(20);

        Image newGame = new Image("images/newGame.png"); // nut newgame
        statusGame = new ImageView(newGame);
        statusGame.setX(-75);
        statusGame.setY(-10);
        statusGame.setScaleX(0.5);
        statusGame.setScaleY(0.5);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, bomb, time, statusGame);
        pane.setMinSize(800, 32);
        pane.setMaxSize(800, 480);
        pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);

        statusGame.setOnMouseClicked(event -> {
            if (player.isLiVe()) {
                running = !running;
            } else {
                new level1();
                running = true;
            }
            updateMenu();
        });

    }

    public static void updateMenu() {
        level.setText("Level: " + l);
        bomb.setText("Bombs: " + bombNumber);

        if (player.isLiVe())
            if (running) {
                Image pauseGame = new Image("images/pauseGame.png");
                statusGame.setImage(pauseGame);
            } else {
                Image playGame = new Image("images/playGame.png");
                statusGame.setImage(playGame);
            }
        else {
            Image newGame = new Image("images/newGame.png");
            statusGame.setImage(newGame);
        }
    }
}
