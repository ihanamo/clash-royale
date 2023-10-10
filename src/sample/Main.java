package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Date;

/**
 * The type Main.
 */
public class Main extends Application {
    /**
     * The constant gc.
     */
    public static GraphicsContext gc;
    @FXML
    private ImageView imageView;
    /**
     * The Sign up scene.
     */
    static Scene signUpScene;
    /**
     * The Sign in scene.
     */
    static Scene signInScene;
    /**
     * The Main menu.
     */
    static Scene mainMenu;
    /**
     * The Game scene.
     */
    static Scene gameScene;
    /**
     * The Stage.
     */
    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        URL url = getClass().getResource("FirstPage.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root=loader.load();
        signInScene=new Scene(root, 600, 400);
        primaryStage.setScene(signInScene);
        primaryStage.setTitle("SignIn");
        URL urlSignUp = getClass().getResource("SignUp.fxml");
        FXMLLoader loaderSignUp = new FXMLLoader(urlSignUp);
        Parent rootSignUp=loaderSignUp.load();
        signUpScene=new Scene(rootSignUp, 600, 400);

        URL urlMainMenu = getClass().getResource("MainMenu.fxml");
        FXMLLoader loaderMainMenu = new FXMLLoader(urlMainMenu);
        Parent rootMainMenu=loaderMainMenu.load();
        mainMenu=new Scene(rootMainMenu, 600, 400);

        URL urlGame = getClass().getResource("Game.fxml");
        FXMLLoader loaderGame = new FXMLLoader(urlGame);
        Parent rootGame=loaderGame.load();
        gameScene=new Scene(rootGame, 650, 458);
        primaryStage.show();
    }

    /**
     * Change scene to sign up.
     */
    public static void changeSceneToSignUp()
    {
        stage.setScene(signUpScene);
    }

    /**
     * Change scene to sign in.
     */
    public static void changeSceneToSignIn()
    {
        stage.setScene(signInScene);
    }

    /**
     * Change scene to main menu.
     */
    public static void changeSceneToMainMenu()
    {
        stage.setScene(mainMenu);
    }

    /**
     * Change scene to game.
     */
    public static void changeSceneToGame()
    {
        stage.setScene(gameScene);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
