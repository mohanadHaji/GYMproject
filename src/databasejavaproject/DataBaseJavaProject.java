/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasejavaproject;
import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;                                         
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import javafx.scene.paint.Color;

/**
 *
 * @author hp
 */
public class DataBaseJavaProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        scene.getStylesheets().add("/css/sample.css");
        stage.setScene(scene);
        stage.show();
    }
 
    /**
     * @param args the command line arguments
     */
      dbconnection con=new dbconnection();
    public static void main(String[] args) {
              dbconnection con=new dbconnection();

      //  dbconnection con=new dbconnection();
       // con.getmember();
        //con.getdata();
        
        launch(args);
    }
    
}
