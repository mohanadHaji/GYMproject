/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasejavaproject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class MemberController implements Initializable {
    
@FXML private TextField membername;
@FXML private TextField memberid;
@FXML private TextField gender;
@FXML private TextField address;    
@FXML private DatePicker dateofbirth;
@FXML private TextField weight;
@FXML private Button insertmember;
@FXML
   private void insertmemberintodata(ActionEvent event) throws SQLException 
   {
       String membernamee=membername.getText();
int memberidd=Integer.parseInt(memberid.getText());
String genderr = gender.getText() ;
String addresss= address.getText();    
LocalDate dateofbirthh= dateofbirth.getValue();
int weightt=Integer.parseInt(weight.getText());
 dbconnection connect=new dbconnection(); 
//connect.insertmemintodata(membernamee, genderr, addresss, dateofbirthh, weightt);
       
   }

   @FXML Button getdatafrommysql;
   
   @FXML
  public void getdatafrommysql()
  {
      dbconnection connect=new dbconnection(); 
//connect.getdata();
       
  }
  
   @FXML Button deletedatafrommysql;
  @FXML
  public void deletedatafrommysql() throws SQLException
  {
    dbconnection connect=new dbconnection(); 
connect.deletefrommysql();
  }

  
  @FXML 
  public void mainmenue(ActionEvent event)
  {
        Parent root;
    try {
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
          
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/sample.css");
        
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    }
      
      
      
      
  }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
       
    }    
    
}
