/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Marisa Ibraheem
 */
public class Baseball extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        //load the FXML Scene
        Parent root = FXMLLoader.load(getClass().getResource("Player_Averages.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Baseball");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}