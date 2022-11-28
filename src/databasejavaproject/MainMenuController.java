/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasejavaproject;

//import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.*;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class MainMenuController implements Initializable {
 private Connection con=null;
    private Statement st;
    private ResultSet rst;
     PreparedStatement ps=null;
    //****************************** To make flexible interface *********************************8//
    double x, y;
    @FXML
    private Button insertmember1;
    @FXML
    private Button deletedatafrommysql1;
    @FXML
    private Button getdatafrommysql1;
    @FXML
    private AnchorPane billsPane;
    @FXML
    private AnchorPane sellGoodPane;
    @FXML
    private AnchorPane customerPane;
    @FXML
    private TextField cusNameField;
    @FXML
    private TextField cusIdField;
    @FXML
    private Button newCusBut;
    @FXML
    private Label addedSuccesfully;
    @FXML
    private Label WrongIDCus;
    @FXML
    private Button viewCusBut;
    @FXML
    private TableView<?> cusTable;
    @FXML
    private AnchorPane buyGoodPane;
    @FXML
    private RadioButton oldGoodRadio;
    @FXML
    private ToggleGroup group1;
    @FXML
    private RadioButton newGoodRadio;
    @FXML
    private AnchorPane oldGoodPane;
    @FXML
    private AnchorPane newGoodPane;
    @FXML
    private Button insertGoodButton;
    @FXML
    private TextField goodNameField;
    @FXML
    private TextField goodIdField;
    @FXML
    private TextField goodPriceField;
    @FXML
    private TextField goodQuantityField;
    @FXML
    private Label goodAddedSuc;
    @FXML
    private Label goodAddedFail;
    @FXML
    private Button CustomersButton;
    @FXML
    private Button Bill;
    @FXML
    private Button sellGood;
    @FXML
    private Button buyGood;
    
    @FXML
    void draged(MouseEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);

    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }

    //****************************** end code flexible interface *********************************8//
    //*******We Have Three Main Interface and button manage member , manage participate 
    //,mange financial issus,manage class,manage employee
    //*********** Connect and  Visible Interfaces ***************************//
    @FXML
    private AnchorPane pagemamnagmember, pagemanagpart, pageemploye, pageclass, moneypage;
    @FXML
    private Button managepartbtn, managememberbtn, managemploy, classbtn, moneybtn;
    ///////////////////////////////////////////////////////////////////////////////////// mohanad
    ObservableList<Classe>    ob1 = FXCollections.observableArrayList();
    ObservableList<ins>    ob2 = FXCollections.observableArrayList();
     ObservableList<Employee>    ob3 = FXCollections.observableArrayList();
      void mkRFmd4() throws Exception {//for employee tab in manager   
          // this function enter database and bring data 
        ob3.clear();
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from employee");
        while (rs.next()) {
            ob3.add(new Employee(rs.getString("name"),rs.getString("DOB"),rs.getString("gender"),rs.getString("Address"),// like constructor of class
                    rs.getString("number"),rs.getString("since"),rs.getString("end"),rs.getString("jobTitle"),
                    rs.getInt("ssn"),rs.getInt("salary")));
        }
        tabelen.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));// like class
        tabledob.setCellValueFactory(new PropertyValueFactory<Employee, String>("DOB"));
        tablegender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        tableaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tablephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tablesince.setCellValueFactory(new PropertyValueFactory<Employee, String>("since"));
        tableend.setCellValueFactory(new PropertyValueFactory<Employee, String>("end"));
        tablespe.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobtitle"));
        tableid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ssn"));
        tablesalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        met.setItems(FXCollections.observableArrayList());
        met.setItems(ob3);
    }
      void mkRFmd1() throws Exception {//for employee tab in manager   
          // this function enter database and bring data for employee who are not removed 
        ob3.clear();
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from employee e where e.end = ''");
        while (rs.next()) {
            ob3.add(new Employee(rs.getString("name"),rs.getString("DOB"),rs.getString("gender"),rs.getString("Address"),
                    rs.getString("number"),rs.getString("since"),rs.getString("end"),rs.getString("jobTitle"),
                    rs.getInt("ssn"),rs.getInt("salary")));
        }
        tableid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ssn"));
        tabelen.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<Employee, String>("DOB"));
        tablegender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        tableaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tablesalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        tablephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tablesince.setCellValueFactory(new PropertyValueFactory<Employee, String>("since"));
        tablespe.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobtitle"));
        tableend.setCellValueFactory(new PropertyValueFactory<Employee, String>("end"));
        met.setItems(FXCollections.observableArrayList());
        met.setItems(ob3);
    }
    void mkRfmd2() throws Exception{// display table of classes 
        ob1.clear();
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from class c,employee e, Room r where c.Rid = r.Rid and c.ssn = e.ssn");
        while(rs.next()){
            ob1.add(new Classe(rs.getString("className"),rs.getString("startTime"),rs.getString("name"),
            rs.getInt("classID"),rs.getInt("period"),
                    rs.getInt("Rid"),rs.getInt("ssn")));
        }
        anchorins.setVisible(false);
        anchorforclass.setVisible(true);
        ctableid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("classID"));
        ctablename.setCellValueFactory(new PropertyValueFactory<Classe, String>("className"));
        ctableRid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("Rid"));
        ctableper.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("period"));
        ctablestart.setCellValueFactory(new PropertyValueFactory<Classe, String>("startTime"));
        ctableEid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("ssn"));
        cclassification.setCellValueFactory(new PropertyValueFactory<Classe, String>("teacher"));
        tablee.setItems(FXCollections.observableArrayList());
        tablee.setItems(ob1);
    }
    void mkRfmd3() throws Exception{// method to show instrments
        ob2.clear();
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from instruments");
        while(rs.next()){
            ob2.add(new ins(rs.getString("producer"), rs.getString("Iname"),rs.getInt("Iid"),rs.getInt("Rid")));
        }
        anchorins.setVisible(true);
        anchorforclass.setVisible(false);
        idco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Iid"));
        nameco.setCellValueFactory(new PropertyValueFactory<ins, String>("Iname"));
        proco.setCellValueFactory(new PropertyValueFactory<ins, String>("producer"));
        roomco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Rid"));
        tableforin.setItems(FXCollections.observableArrayList());
        tableforin.setItems(ob2);
    }   
    /////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void handlebuttonaction(ActionEvent event) throws Exception {
        if (event.getTarget() == managepartbtn) {
            pagemamnagmember.setVisible(false);//1
            pagemanagpart.setVisible(true);//2
            pageemploye.setVisible(false);//3

            newmemberpage.setVisible(false);
            newpagemedical.setVisible(false);
            newpagebox.setVisible(false);
            viewmember.setVisible(false);

            moneypage.setVisible(false);//4
            pageclass.setVisible(false);//5

        } else if (event.getTarget() == managememberbtn) {
            pagemamnagmember.setVisible(true);
            // newmemberpage.setVisible(true);
            pagemanagpart.setVisible(false);
            pageemploye.setVisible(false);
            pageclass.setVisible(false);
            moneypage.setVisible(false);

        } else if (event.getTarget() == managemploy) {
            pagemamnagmember.setVisible(false);
            pagemanagpart.setVisible(false);
            pageemploye.setVisible(true);
            newmemberpage.setVisible(false);
            newpagemedical.setVisible(false);
            newpagebox.setVisible(false);
            viewmember.setVisible(false);
            pageclass.setVisible(false);
            moneypage.setVisible(false);
            mkRFmd4();
            
        } else if (event.getTarget() == classbtn) {
            pagemamnagmember.setVisible(false);
            pagemanagpart.setVisible(false);
            pageemploye.setVisible(false);
            newmemberpage.setVisible(false);
            newpagemedical.setVisible(false);
            newpagebox.setVisible(false);
            viewmember.setVisible(false);
            pageclass.setVisible(true);
            moneypage.setVisible(false);
            mkRfmd2();

        } else if (event.getTarget() == moneybtn) {
            pagemamnagmember.setVisible(false);
            pagemanagpart.setVisible(false);
            pageemploye.setVisible(false);
            newmemberpage.setVisible(false);
            newpagemedical.setVisible(false);
            newpagebox.setVisible(false);
            viewmember.setVisible(false);
            pageclass.setVisible(false);
            moneypage.setVisible(true);

        }

    }

    //page member management has new members(Participations),medicalcheck,box.
    @FXML
    private AnchorPane newmemberpage, newpagemedical, newpagebox, viewmember;
    @FXML
    private Button newmemberbtn, medicalbtn, boxbtn, viewmemberbtn;

    @FXML
    private void handlebuttonmember(ActionEvent event) {

        if (event.getTarget() == newmemberbtn) {
            newmemberpage.setVisible(true);
            newpagemedical.setVisible(false);
            newpagebox.setVisible(false);
            viewmember.setVisible(false);

        } else if (event.getTarget() == medicalbtn) {
            newmemberpage.setVisible(false);
            newpagemedical.setVisible(true);
            newpagebox.setVisible(false);
            viewmember.setVisible(false);

        } else if (event.getTarget() == boxbtn) {
            newmemberpage.setVisible(false);
            newpagemedical.setVisible(false);
            newpagebox.setVisible(true);
            viewmember.setVisible(false);

        } else if (event.getTarget() == viewmemberbtn) {
            newmemberpage.setVisible(false);
            newpagemedical.setVisible(false);
            newpagebox.setVisible(false);
            viewmember.setVisible(true);
            //id name weight .... attribute in member class
            idmt.setCellValueFactory(new PropertyValueFactory<memberclass, Integer>("id"));//the id of variable exists in memberclass
            namemt.setCellValueFactory(new PropertyValueFactory<memberclass, String>("name"));
            gendermt.setCellValueFactory(new PropertyValueFactory<memberclass, String>("gender"));
            addressmt.setCellValueFactory(new PropertyValueFactory<memberclass, String>("address"));
            datemt.setCellValueFactory(new PropertyValueFactory<memberclass, String>("date"));
            weightmt.setCellValueFactory(new PropertyValueFactory<memberclass, Integer>("weight"));
            dbconnection db = new dbconnection();
            listmember = db.getmember();
            //membertable.getItems().addAll(listmember);
            membertable.setItems(listmember);

            //  con.close();
        }

    }

    //*********** end  Interfaces ***************************//
//****************Here The New Member Page Setting insert ,Delete ,Show
    @FXML private TextField membername;
    @FXML private TextField memberid;
    @FXML private TextField gender;
    @FXML private TextField address;
    @FXML private DatePicker dateofbirth;
    @FXML private TextField weight;
    //^^^^^^^^^^^^^^^^^^^^^^^^Insert member to my sql from new member interface ^^^^^^^^^^^^^^^^^^^^^^^^^
    @FXML private void insertmemberintodata(ActionEvent event) {
        //must check of entries
         try {
        String membernamee = membername.getText();
       // int memberidd = Integer.parseInt(memberid.getText());  
        String genderr = gender.getText();
        String addresss = address.getText();
        LocalDate dateofbirthh = dateofbirth.getValue();
        int weightt = Integer.parseInt(weight.getText());
        dbconnection connect = new dbconnection();
        //JOptionPane.
        JOptionPane.showMessageDialog(null, "Sucssefull insert new member" );
        membername.setText("");gender.setText("");address.setText("");dateofbirth.setValue(null);weight.setText("");
       
            connect.insertmemintodata(membernamee, genderr, addresss, dateofbirthh, weightt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please Check all field must be not empty" );
           }

    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^get data (select*)^^^^^^^^^^^^^^^^^^^^^^^^
    Button getdatafrommysql;

    @FXML
    public void getdatafrommysql() {
        dbconnection connect = new dbconnection();
        connect.getdata();
    }
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Delete From my sql^^^^^^^^^^^^^^^^^^^^^^^^
    Button deletedatafrommysql;

    @FXML
    public void deletedatafrommysql() {
        dbconnection connect = new dbconnection();
        try {
            connect.deletefrommysql();
        } catch (SQLException ex) {
            System.out.println("The Delete Has Problem");
        }
    }

    //*********************End member Setting***************************
    /**
     * Initializes the controller class.
     */
//***************************show member in table view and declaration columns******************* 
    ObservableList<memberclass> listmember = FXCollections.observableArrayList();
    @FXML TableView<memberclass> membertable;
    @FXML TableColumn<memberclass, String> namemt;//namemembertable
    @FXML TableColumn<memberclass, Integer> idmt;//idmembertable
    @FXML TableColumn<memberclass, String> gendermt;//gendermembertable
    @FXML TableColumn<memberclass, String> addressmt;//addressmembertable
    @FXML TableColumn<memberclass, String> datemt;//datemembertable
    @FXML TableColumn<memberclass, Integer> weightmt;//namemembertable

    
    //^^^^^^^^^^^^^^^^^^^^^^^^Serch member^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    @FXML
    TextField searchmember;// set action presserd on mouse serchmemberr
    //search data 
    @FXML
    public void serchmemberr() {
        searchmember.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (searchmember.textProperty().get().isEmpty()) //get data from textfield search and check
                {
                    membertable.setItems(listmember);
                    return;
                }
                ObservableList<memberclass> templistmember = FXCollections.observableArrayList();//store data of search in temporarly list
                ObservableList<TableColumn<memberclass, ?>> cols = membertable.getColumns();//get every column so check every cell
                for (int i = 0; i < listmember.size(); i++) {
                    for (int j = 0; j < cols.size(); j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(listmember.get(i)).toString().toLowerCase();
                        if (cellValue.contains(searchmember.getText().toLowerCase()) && cellValue.startsWith(searchmember.getText().toLowerCase())) {
                            templistmember.add(listmember.get(i));
                            break;
                        }

                    }
                }
                membertable.setItems(templistmember);
                //updatemember();
            }
        });

    }
//**************************End Search****************************

    //Start Update******************
    int indexmem = -1;
    @FXML TextField updatememid, updatememname, updatememgender, updatememaddress, updatememdate, updatememweight;
//this field in order to modify member
    @FXML
    public void getSelectedmember() {

        indexmem = membertable.getSelectionModel().getSelectedIndex();
        if (indexmem <= -1) {
            return;
        }

        updatememid.setText(idmt.getCellData(indexmem).toString());
        updatememname.setText(namemt.getCellData(indexmem).toString());
        updatememgender.setText(gendermt.getCellData(indexmem).toString());
        updatememaddress.setText(addressmt.getCellData(indexmem).toString());
        updatememdate.setText(datemt.getCellData(indexmem).toString());
        updatememweight.setText(weightmt.getCellData(indexmem).toString());
        
    }
    @FXML public void updatemember(){
        String membernamee = updatememname.getText();
        int memberidd = Integer.parseInt(updatememid.getText());
        String genderr = updatememgender.getText();
        String addresss = updatememaddress.getText();
        String dateofbirthh = updatememdate.getText();
        int weightt = Integer.parseInt(updatememweight.getText());
        indexmem = membertable.getSelectionModel().getSelectedIndex();
        dbconnection con=new dbconnection();
        try {
         if(con.updatememberinfo(membernamee,genderr,addresss,dateofbirthh,weightt,memberidd))
       
         listmember.set(indexmem,new memberclass(membernamee, listmember.get(indexmem).getId(), genderr, addresss, dateofbirthh, weightt));
          membertable.setItems(listmember);
          JOptionPane.showMessageDialog(null, "Update Member inf Successfully" );
          //clear field
          updatememname.setText("");updatememid.setText("");updatememgender.setText("");updatememaddress.setText("");
          updatememdate.setText("");updatememweight.setText("");
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Please Check all field must be not empty" );
           }
       
       // Statement st=null;
     //   String query="update memberr m "
        
        

    }
    
    
     @FXML public void close(ActionEvent event)
     {
        System.exit(1);       
     }
    

    //listmember.removeAll(listmember);
     
     
     //***********************************Box*********************
    @FXML TextField bcap,bid; 
    @FXML Pane reservepane; 
   @FXML ChoiceBox  comboboxx,combomem;
  
     @FXML public void insertboxx(ActionEvent event)
     {  reservepane.setVisible(false);
             }
      //^^^^^^^^^^^^^^^^^^^^^^^^^^^^insert new box^^^^^^^^^^^^^^^^^^^^^^^^^^
      @FXML public void insert(ActionEvent event)
     {dbconnection db =new dbconnection();
            db.isertnewbox(Integer.parseInt(bid.getText()),Integer.parseInt(bcap.getText()));
            data.removeAll();
            comboboxx.getItems().removeAll(data);
          // data.add(Integer.parseInt(bid.getText()));
      
     }
       //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^reservebox interface^^^^^^^^^^^^^^^^^^
              @FXML public void reservebox(ActionEvent event) 
      {          
          reservepane.setVisible(true);
        }
              
//^^^^^^^^^^^^^^^^^^^^^^^^^^reserved btn^^^^^^^^^^^^^^^^^^^
              @FXML DatePicker start,end;
@FXML public void reservebtn ()
 {
   int idmem=(int) combomem.getSelectionModel().getSelectedItem();
//System.out.println("id"+idmem); 
 int idbox=(int) comboboxx.getSelectionModel().getSelectedItem();
  LocalDate startdate = start.getValue();
  LocalDate enddate = end.getValue();
       
 dbconnection db=new dbconnection();
 db.insertintoreservedbox(idmem,idbox,startdate,enddate);
 //combomem.setSelectionModel(null);
 combomem.getSelectionModel().clearSelection();
 //combomem.getSelectionModel().
 //datam.Remove((combomem.getSelectedItem());
 //dbconnection db=new dbconnection();
 //insert to rent table
 
 
 
// db.deletebox(idbox);

 comboboxx.getItems().remove(comboboxx.getSelectionModel().getSelectedItem());
 comboboxx.getItems().remove(comboboxx.getSelectionModel().getSelectedItem());
 
 // comboboxx.getItems().remove(comboboxx.getSelectionModel());
 
//data.remove(comboboxx.getSelectionModel().getSelectedItem());
//comboboxx.getItems();
 
 //comboboxx.
// System.out.println("id"+idbox);
 }
              
    /*@FXML public void reservebtn ()fillmembercombo()
     { String name;
      ObservableList list = null;
         try {
               con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gymprojec","root","1234567890");

      String query="select * from memberr";
    
           st= con.createStatement();
         rst=st.executeQuery(query);
         while (rst.next()){
             name=rst.getString("membername");
             System.out.println("the name "+name);
             list= FXCollections.observableArrayList(name);
                }
         combomem.setItems(null);
          combomem.setItems(list);
          
             
        
     } catch (SQLException ex) {
         Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
     }
        
         
     }*/
     
     
      ObservableList data = FXCollections.observableArrayList();
            ObservableList datam = FXCollections.observableArrayList();

     // ObservableList data = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
         mkRFmd4();
     } catch (Exception ex) {
         Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

   @FXML
    private void handleButtonFGC(ActionEvent event) {
        
        if (event.getTarget() == CustomersButton) {
            customerPane.setVisible(true);
            buyGoodPane.setVisible(false);
            sellGoodPane.setVisible(false);
            billsPane.setVisible(false);

        } else if (event.getTarget() == buyGood) {
            customerPane.setVisible(false);
            buyGoodPane.setVisible(true);
            sellGoodPane.setVisible(false);
            billsPane.setVisible(false);

        } else if (event.getTarget() == sellGood) {
            customerPane.setVisible(false);
            buyGoodPane.setVisible(false);
            sellGoodPane.setVisible(true);
            billsPane.setVisible(false);

        } else if (event.getTarget() == Bill) {
           customerPane.setVisible(false);
            buyGoodPane.setVisible(false);
            sellGoodPane.setVisible(false);
            billsPane.setVisible(true);
           
        }
        
        
    }

    @FXML
    private void buyGoodHandle(ActionEvent event) {
        
        if(newGoodRadio.isSelected())
        {
            oldGoodPane.setVisible(false);
            newGoodPane.setVisible(true);
        } else if(oldGoodRadio.isSelected())
        {
            oldGoodPane.setVisible(true);
            newGoodPane.setVisible(false);
        }
    }

    @FXML
    private void addCustomerToDataBase(ActionEvent event) {
        addedSuccesfully.setVisible(false);
        WrongIDCus.setVisible(false);
                
        dbconnection db=new dbconnection();
        String name=cusNameField.getText();
        
        int id=Integer.parseInt(cusIdField.getText());
        
        
        if(db.insertCustomerToData(name, id))
        {
            addedSuccesfully.setVisible(true);
        }else
          WrongIDCus.setVisible(true);  
        
        
    }
    

  @FXML
    private void viewCusHandle(ActionEvent event)
    {
        
               
    }

    @FXML
    private void insertGoodToDataBase(ActionEvent event)
    {
        goodAddedSuc.setVisible(false);
        goodAddedFail.setVisible(false);
                
        dbconnection db=new dbconnection();
        String name=goodNameField.getText();
        int id=Integer.parseInt(goodIdField.getText());
        int quantity=Integer.parseInt(goodQuantityField.getText());
        float price=Float.parseFloat(goodPriceField.getText()) ;
        if(db.insertGoodToData(name, id, price, quantity))
        {
            goodAddedSuc.setVisible(true);
        }else
          goodAddedFail.setVisible(true); 
    }

      
    @FXML
    private Button maeb;

    @FXML
    private RadioButton mmaleb;

    @FXML
    private TableColumn<Employee, String> tabledob;


    @FXML
    private TableColumn<Employee, String> tablegender;

    
    @FXML
    private TableColumn<Employee,Integer> tableid;
    @FXML
    private TableColumn<ins, Integer> idco;


    @FXML
    private TableColumn<ins, String> nameco;

    
    @FXML
    private TableColumn<ins,String> proco;
    @FXML
    private TableColumn<ins, Integer> roomco;
    @FXML
    private TableView<ins> tableforin;
    @FXML
    private TextField maddresse;

   
    

    @FXML
    private TextField mspe;

    @FXML
    private RadioButton mfemaleb;

    @FXML
    private AnchorPane anchorins,anchorforclass;

    @FXML
    private TextField mide;


    @FXML
    private Button mshowab;

    @FXML
    private TableColumn<Employee, String> tablespe;

    @FXML
    private TextField msalarye;

    @FXML
    private Button mshowb;

   

    @FXML
    private TableColumn<Employee, String> tablesince;


    @FXML
    private Button mdeb;

    @FXML
    private TableColumn<Employee, String> tabelen;

   
    

    @FXML
    private DatePicker mdobe;

    @FXML
    private TableColumn<Employee, Integer> tablesalary;

    
    @FXML
    private TableView<Employee> met;

    @FXML
    private TableColumn<Employee, String> tablephone;

   

    @FXML
    private TextField mne;



    @FXML
    private TableColumn<Employee,String> tableend;

    @FXML
    private Button mseb;


    @FXML
    private Button mueb;

    @FXML
    private TextField mphonee;

    @FXML
    private TableColumn<Employee,String> tableaddress;
    @FXML
    void mae(ActionEvent event) throws Exception  {// will add employee if hr pressed add and all text is not empty 
        Alert al;
        try{
        
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        String format="yyyy-MM-dd"; // to format for buttom statment
        SimpleDateFormat simple = new SimpleDateFormat(format);
        String ends = ""; // this is for the end of job nothing is there becuase he just started
        String date = simple.format(new Date()); // take date from pc
        String message = ""; // to detcet gender
        if(mmaleb.isSelected()){
            message = "Male";
        }
        if(mfemaleb.isSelected())
            message = "Female";
        if(!mne.getText().isEmpty()&& !mide.getText().isEmpty()&& !maddresse.getText().isEmpty()&& !msalarye.getText().isEmpty() 
                && ! mphonee.getText().isEmpty() && !mspe.getText().isEmpty()){
            PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES('"+ Integer.parseInt(mide.getText())+"', '"+ mne.getText()+"', '"
                    +mdobe.getValue()+"', '"+ message+"', '" +maddresse.getText()+"', '" +Integer.parseInt(msalarye.getText())+"', '"
                    + mphonee.getText()+"', '"+ date+ "', '" + ends+"', '"+ mspe.getText()+"')");
            ps.executeUpdate();
            //System.out.println(mspe.getText());
            try {
                ////////////////////////////// here we should add the login for the user
                mkRFmd1();
            } catch (Exception ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}
        catch (NumberFormatException | SQLException e){
                    al = new Alert(AlertType.ERROR);
                    al.setContentText(e.getMessage());
                    al.show();
                    }
        } 
    

    @FXML
    void mshowa(ActionEvent event) throws Exception {
         mkRFmd4();

    }

    @FXML
    void mde(ActionEvent event) throws Exception {// this function will delete an employee based on his id number
        Connection conn = dbconnection.getConnection();
         String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            System.out.println(date);
            if(!mide.getText().isEmpty()){
               conn.prepareStatement("update employee set end='"+date+"' where ssn='"+Integer.parseInt(mide.getText())+"'").executeUpdate(); 
            }
            else{
        Employee temp = met.getSelectionModel().getSelectedItem();
        conn.prepareStatement("update employee set end='"+date+"' where ssn='"+temp.getSsn()+"'").executeUpdate();
            mkRFmd4();
            }
             
        }
    

    @FXML
    void mse(ActionEvent event) throws Exception {// method for search for employee, it dose search on id then name and address or name or addess in all data
   
        ob3.clear();
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        // search on id 
        if(!mide.getText().isEmpty()){
        ResultSet rs = st.executeQuery("select * from employee e where e.ssn = '"+Integer.parseInt(mide.getText())+"'");
        while (rs.next()) {
            ob3.add(new Employee(rs.getString("name"),rs.getString("DOB"),rs.getString("gender"),rs.getString("Address"),
                    rs.getString("number"),rs.getString("since"),rs.getString("end"),rs.getString("jobTitle"),
                    rs.getInt("ssn"),rs.getInt("salary")));
        }
        tableid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ssn"));
        tabelen.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<Employee, String>("DOB"));
        tablegender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        tableaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tablesalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        tablephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tablesince.setCellValueFactory(new PropertyValueFactory<Employee, String>("since"));
        tablespe.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobtitle"));
        tableend.setCellValueFactory(new PropertyValueFactory<Employee, String>("end"));
        met.setItems(FXCollections.observableArrayList());
        met.setItems(ob3);
        }
//=========================== search ob name and address
        else if(!mne.getText().isEmpty() && !maddresse.getText().isEmpty()){
            ResultSet rs = st.executeQuery("select * from employee e where e.name = '"+mne.getText()+"' and e.address = '"+ maddresse.getText()+"'");
        while (rs.next()) {
            ob3.add(new Employee(rs.getString("name"),rs.getString("DOB"),rs.getString("gender"),rs.getString("Address"),
                    rs.getString("number"),rs.getString("since"),rs.getString("end"),rs.getString("jobTitle"),
                    rs.getInt("ssn"),rs.getInt("salary")));
        }
        tableid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ssn"));
        tabelen.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<Employee, String>("DOB"));
        tablegender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        tableaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tablesalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        tablephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tablesince.setCellValueFactory(new PropertyValueFactory<Employee, String>("since"));
        tablespe.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobtitle"));
        tableend.setCellValueFactory(new PropertyValueFactory<Employee, String>("end"));
        met.setItems(FXCollections.observableArrayList());
        met.setItems(ob3);
        }
        // ===================== on name only
        else if(!mne.getText().isEmpty()){
            ResultSet rs = st.executeQuery("select * from employee e where e.name  = '"+mne.getText()+"'");
        while (rs.next()) {
            ob3.add(new Employee(rs.getString("name"),rs.getString("DOB"),rs.getString("gender"),rs.getString("Address"),
                    rs.getString("number"),rs.getString("since"),rs.getString("end"),rs.getString("jobTitle"),
                    rs.getInt("ssn"),rs.getInt("salary")));
        }
        tableid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ssn"));
        tabelen.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<Employee, String>("DOB"));
        tablegender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        tableaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tablesalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        tablephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tablesince.setCellValueFactory(new PropertyValueFactory<Employee, String>("since"));
        tablespe.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobtitle"));
        tableend.setCellValueFactory(new PropertyValueFactory<Employee, String>("end"));
        met.setItems(FXCollections.observableArrayList());
        met.setItems(ob3);
        }
        else if(!maddresse.getText().isEmpty()){
            ResultSet rs = st.executeQuery("select * from employee e where e.address = '"+maddresse.getText()+"'");
        while (rs.next()) {
            ob3.add(new Employee(rs.getString("name"),rs.getString("DOB"),rs.getString("gender"),rs.getString("Address"),
                    rs.getString("number"),rs.getString("since"),rs.getString("end"),rs.getString("jobTitle"),
                    rs.getInt("ssn"),rs.getInt("salary")));
        }
        tableid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ssn"));
        tabelen.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<Employee, String>("DOB"));
        tablegender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        tableaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tablesalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        tablephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tablesince.setCellValueFactory(new PropertyValueFactory<Employee, String>("since"));
        tablespe.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobtitle"));
        tableend.setCellValueFactory(new PropertyValueFactory<Employee, String>("end"));
        met.setItems(FXCollections.observableArrayList());
        met.setItems(ob3);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////met.setVisible(false);
    }

    @FXML
    void mue(ActionEvent event) throws Exception {
        Employee e = met.getSelectionModel().getSelectedItem();
        Connection conn = dbconnection.getConnection();
        String name;
        Integer id;
        String address;
        Integer salary;
        String phone;
        String sp;
        int workKnow = 0;
        
        String gender;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

       String dob;
        if(mne.getText().isEmpty()){
             name = e.getName();
        }
        else{
             name = mne.getText();
        }
        if(mide.getText().isEmpty()){
             id = e.getSsn();
        }
        else{
             id = Integer.parseInt( mide.getText());
        }
        if(maddresse.getText().isEmpty()){
            address = e.getAddress();
        }
        else{
            address = maddresse.getText();
        }
        if(msalarye.getText().isEmpty()){
            salary = e.getSalary();
        }
        else{
            salary = Integer.parseInt(msalarye.getText());
        }
        if(mphonee.getText().isEmpty()){
             phone = e.getPhone();
        }
        else{
             phone = mphonee.getText();
        }
        if(mspe.getText().isEmpty()){
             sp = e.getJobtitle();
        }
        else{
             sp = mspe.getText();
        }
        if(mdobe.getValue() == null){
             dob = e.getDOB();
        }
        else{
             dob = ft.format(ft.parse(mdobe.getValue().toString()));
        }
        if(mmaleb.isPressed() == false && mfemaleb.isPressed() == false){
             gender = e.getGender();
        }
        else if(mmaleb.isSelected()){
             gender = "Male";
        }
        else{
             gender = "Female";
        }
        conn.prepareStatement("update employee set ssn = '"+ id+"', name = '"+name+"', address = '"+address+"', DOB = '"+dob+"', gender = '"+gender
                +"', salary = '"+salary+"', number = '" +phone+"', jobTitle = '"+ sp+ "' where ssn = '"+ e.getSsn()+"'").executeUpdate();
        mkRFmd4();
        
    }

    @FXML
    void mshow(ActionEvent event) throws Exception {
        mkRFmd1();
    }

    @FXML
    void mmale(ActionEvent event) {
        mfemaleb.setSelected(false);
    }

    @FXML
    void mfemale(ActionEvent event) {
        mmaleb.setSelected(false);
    }
    @FXML
    private Button removeins;
    @FXML
    private Button addins;
    @FXML
    private TableColumn<Classe, Integer> ctableid;
    @FXML
    private TableColumn<Classe, String> ctablestart;
    @FXML
    private TextField timel;
    @FXML
    private TableColumn<Classe, String> cclassification;
    @FXML
    private TableColumn<Classe, Integer> ctableEid;
    @FXML
    private Button searchins;
    @FXML
    private TextField classeStarttime;
    @FXML
    private TableColumn<Classe, String> ctablename;
    @FXML
    private TextField employeeidl;

    @FXML
    private Button searchclass;

    @FXML
    private Button removeclass;
    @FXML
    private TextField insfacl;
    @FXML
    private TextField insroomidl;
    @FXML
    private TextField roomidl;
    @FXML
    private TextField insnamel;
    @FXML
    private TableColumn<Classe, Integer> ctableRid;
    @FXML
    private TableView<Classe> tablee;
    @FXML
    private TableColumn<Classe, Integer> ctableper;
    @FXML
    private TextField insidl;
   
    @FXML
    private TextField classidl;
    @FXML
    private TextField classnamel;
    @FXML
    private TextField infol;
    @FXML
    private TextField  classStarttime;
    @FXML
    void justaddplz(ActionEvent event) throws Exception {
        String name,start;
        int det = 0;
        Integer Cid,Rid,Eid,period;
        if(!classnamel.getText().isEmpty() && !classidl.getText().isEmpty() && !classStarttime.getText().isEmpty() && !timel.getText().isEmpty()
                && !roomidl.getText().isEmpty() && !employeeidl.getText().isEmpty()){
            Connection conn = dbconnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from class c,employee e, Room r where c.Rid = r.Rid and c.ssn = e.ssn ");
            ob1.clear();
            while(rs.next()){
                ob1.add(new Classe(rs.getString("className"),rs.getString("startTime"),rs.getString("name"),
            rs.getInt("classID"),rs.getInt("period"),
                    rs.getInt("Rid"),rs.getInt("ssn")));
            }
            int len = ob1.size(),i;
            String[] sta = new String[len];
            int[] per = new int[len];
            String[] temp = new String[2];
            String[] timeoflec = new String[2];
            int[] temp1 = new int[len+1];
            for(i = 0; i<len;i++){
               sta[i] = ob1.get(i).getStartTime();
               per[i] = ob1.get(i).getPeriod();// period of old classes
               temp = sta[i].split(":");
               temp1[i] = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);//time of all classes in same room 
            }
            String t = classStarttime.getText();
            timeoflec = t.split(":");
            int tt = Integer.parseInt(timeoflec[0])*60 + Integer.parseInt(timeoflec[1]);// start time for new class
            int tper = Integer.parseInt(timel.getText());// period time of new class
            
            int plus = tt+tper;
            for(i = 0; i<len;i++){
                System.out.println("new calss time = "+tt+" new class period = "+(tt+tper)+"  old class time"+temp1[i]+"  old class period ="+per[i]);
               // if it's the same room 
                if(tt>temp1[i] && tt<=(temp1[i]+per[i])){// if it start in midle of previos class
                    det = 1;
                    String msg = "time incorrect";
                    infol.setText(msg);
                    break;
                }
                else if(tt<temp1[i] && plus>=temp1[i]){// if it end in midle of previos class
                    det = 1;
                    String msg = "time incorrect";
                    infol.setText(msg);
                    break;
                }
                else if(tt == temp1[i]){
                    det = 1;
                    String msg = "time incorrect";
                    infol.setText(msg);
                    break;
                }
                rs = st.executeQuery("select e.ssn from employee e where e.end = '' and e.ssn = '"+Integer.parseInt(classidl.getText())+ "'");
                if(rs.next() == false){
                    det = 1;
                    String msg = "no such employee";
                    infol.setText(msg);
                }
            }
            if(det != 1){
                conn.prepareStatement("insert into class values ('"+Integer.parseInt(classidl.getText())+"', '"+classnamel.getText()
                        +"', '"+classStarttime.getText()+"', '"+Integer.parseInt(timel.getText())+"', '"
                        +Integer.parseInt(roomidl.getText())+"', '"+Integer.parseInt(employeeidl.getText())+"')").executeUpdate();
                mkRfmd2();
            }
    }
        else{
            String msg = "please fill the gapes";
                    infol.setText(msg);
        }}

    @FXML
    void addinsA(ActionEvent event) throws Exception {
        if(!insnamel.getText().isEmpty() && !insidl.getText().isEmpty() && !insfacl.getText().isEmpty() && !insroomidl.getText().isEmpty()){
            Connection conn = dbconnection.getConnection();
            conn.prepareStatement("insert into instruments values ('"+Integer.parseInt(insidl.getText())+"', '"
                    +insfacl.getText()+"', '"+insnamel.getText()+"', '"+Integer.parseInt(insroomidl.getText())+"')").executeUpdate();
            String msg = insnamel.getText()+" have been added ";
            infol.setText(msg);
            mkRfmd3();
        }
        else{
            
            String msg = " please add all info ";
            infol.setText(msg);
        }
    }

    @FXML
    void removeclassA(ActionEvent event) throws Exception {
        if(!classidl.getText().isEmpty()){
            Connection conn = dbconnection.getConnection();
            conn.prepareStatement("delete from class c where c.classId = '"+Integer.parseInt(classidl.getText())+"'").executeUpdate();
            String msg = "deleted";
            infol.setText(msg);
            mkRfmd2();
        }
        else if(tablee.getSelectionModel().getSelectedItem() != null){
            Classe cla = tablee.getSelectionModel().getSelectedItem();
            Connection conn = dbconnection.getConnection();
            conn.prepareStatement("delete from class c where c.classId = '"+cla.getClassID()+"'").executeUpdate();
            String msg = "deleted";
            infol.setText(msg);
            mkRfmd2();
        }
        else{
            String msg = "slecet class to delete";
            infol.setText(msg);
            mkRfmd2();
        }
    }

    @FXML
    void removeinsA(ActionEvent event) throws Exception {
         if(!insidl.getText().isEmpty()){
            Connection conn = dbconnection.getConnection();
            conn.prepareStatement("delete from instruments t where t.Iid = '"+Integer.parseInt(insidl.getText())+"'").executeUpdate();
            String msg = "deleted";
            infol.setText(msg);
            mkRfmd3();
        }
        else if(tableforin.getSelectionModel().getSelectedItem() != null){
            ins cla = tableforin.getSelectionModel().getSelectedItem();
            Connection conn = dbconnection.getConnection();
            conn.prepareStatement("delete from instruments i where i.Iid = '"+cla.getIid()+"'").executeUpdate();
            String msg = "deleted";
            infol.setText(msg);
            mkRfmd3();
        }
        else{
            String msg = "slecet instrument to delete";
            infol.setText(msg);
            mkRfmd3();
        }
    }

    @FXML
    void searchclassA(ActionEvent event) throws Exception {
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs;
        ob1.clear();
        if(!classidl.getText().isEmpty()){
            rs = st.executeQuery("select * from class c,employee e, Room r where c.Rid = r.Rid and c.ssn = e.ssn and c.classid = '"
                    +Integer.parseInt(classidl.getText())+"'");
            while(rs.next()){
            ob1.add(new Classe(rs.getString("className"),rs.getString("startTime"),rs.getString("name"),
            rs.getInt("classID"),rs.getInt("period"),
                    rs.getInt("Rid"),rs.getInt("ssn")));
        }
        anchorins.setVisible(false);
        anchorforclass.setVisible(true);
        ctableid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("classID"));
        ctablename.setCellValueFactory(new PropertyValueFactory<Classe, String>("className"));
        ctableRid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("Rid"));
        ctableper.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("period"));
        ctablestart.setCellValueFactory(new PropertyValueFactory<Classe, String>("startTime"));
        ctableEid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("ssn"));
        cclassification.setCellValueFactory(new PropertyValueFactory<Classe, String>("teacher"));
        tablee.setItems(FXCollections.observableArrayList());
        tablee.setItems(ob1);
            
        }
        else if(!classnamel.getText().isEmpty() && !employeeidl.getText().isEmpty()){
            rs = st.executeQuery("select * from class c,employee e, Room r where c.Rid = r.Rid and c.ssn = e.ssn and c.ssn = '"
                    +Integer.parseInt(employeeidl.getText())
                    +"' and c.className = '"+classnamel.getText()+"'");
            while(rs.next()){
            ob1.add(new Classe(rs.getString("className"),rs.getString("startTime"),rs.getString("name"),
            rs.getInt("classID"),rs.getInt("period"),
                    rs.getInt("Rid"),rs.getInt("ssn")));
        }
        anchorins.setVisible(false);
        anchorforclass.setVisible(true);
        ctableid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("classID"));
        ctablename.setCellValueFactory(new PropertyValueFactory<Classe, String>("className"));
        ctableRid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("Rid"));
        ctableper.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("period"));
        ctablestart.setCellValueFactory(new PropertyValueFactory<Classe, String>("startTime"));
        ctableEid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("ssn"));
        cclassification.setCellValueFactory(new PropertyValueFactory<Classe, String>("teacher"));
        tablee.setItems(FXCollections.observableArrayList());
        tablee.setItems(ob1);
        }
        else if(!classnamel.getText().isEmpty()){
            rs = st.executeQuery("select * from class c,employee e, Room r where c.Rid = r.Rid and c.ssn = e.ssn and c.className = '"
                    +classnamel.getText()+"'");
            while(rs.next()){
            ob1.add(new Classe(rs.getString("className"),rs.getString("startTime"),rs.getString("name"),
            rs.getInt("classID"),rs.getInt("period"),
                    rs.getInt("Rid"),rs.getInt("ssn")));
        }
        anchorins.setVisible(false);
        anchorforclass.setVisible(true);
        ctableid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("classID"));
        ctablename.setCellValueFactory(new PropertyValueFactory<Classe, String>("className"));
        ctableRid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("Rid"));
        ctableper.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("period"));
        ctablestart.setCellValueFactory(new PropertyValueFactory<Classe, String>("startTime"));
        ctableEid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("ssn"));
        cclassification.setCellValueFactory(new PropertyValueFactory<Classe, String>("teacher"));
        tablee.setItems(FXCollections.observableArrayList());
        tablee.setItems(ob1);
        }
        else if(!employeeidl.getText().isEmpty()){
            rs = st.executeQuery("select * from class c,employee e, Room r where c.Rid = r.Rid and c.ssn = e.ssn and c.ssn = '"
                    +Integer.parseInt(employeeidl.getText())+"'");
            while(rs.next()){
            ob1.add(new Classe(rs.getString("className"),rs.getString("startTime"),rs.getString("name"),
            rs.getInt("classID"),rs.getInt("period"),
                    rs.getInt("Rid"),rs.getInt("ssn")));
        }
        anchorins.setVisible(false);
        anchorforclass.setVisible(true);
        ctableid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("classID"));
        ctablename.setCellValueFactory(new PropertyValueFactory<Classe, String>("className"));
        ctableRid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("Rid"));
        ctableper.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("period"));
        ctablestart.setCellValueFactory(new PropertyValueFactory<Classe, String>("startTime"));
        ctableEid.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("ssn"));
        cclassification.setCellValueFactory(new PropertyValueFactory<Classe, String>("teacher"));
        tablee.setItems(FXCollections.observableArrayList());
        tablee.setItems(ob1);
        }
        else{
            String msg = "enter a vlaue in calss id or class name or in employee id";
            infol.setText(msg);
            mkRfmd2();
        }
        
    }

    @FXML
    void searchinsA(ActionEvent event) throws Exception {
        ob2.clear();
        Connection conn = dbconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs;
        if(!insidl.getText().isEmpty()){
            rs = st.executeQuery("select * from instruments i where i.Iid = '"+Integer.parseInt(insidl.getText())+"'");
        while(rs.next()){
            ob2.add(new ins(rs.getString("producer"), rs.getString("Iname"),rs.getInt("Iid"),rs.getInt("Rid")));
        }
        anchorins.setVisible(true);
        anchorforclass.setVisible(false);
        idco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Iid"));
        nameco.setCellValueFactory(new PropertyValueFactory<ins, String>("Iname"));
        proco.setCellValueFactory(new PropertyValueFactory<ins, String>("producer"));
        roomco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Rid"));
        tableforin.setItems(FXCollections.observableArrayList());
        tableforin.setItems(ob2);
    }
        else if(!insnamel.getText().isEmpty() && !insroomidl.getText().isEmpty()){
        rs = st.executeQuery("select * from instruments i where i.Rid = '"+Integer.parseInt(insroomidl.getText())
                +"' and i.Iname = '"+insnamel.getText()+"'");
        while(rs.next()){
            ob2.add(new ins(rs.getString("producer"), rs.getString("Iname"),rs.getInt("Iid"),rs.getInt("Rid")));
        }
        anchorins.setVisible(true);
        anchorforclass.setVisible(false);
        idco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Iid"));
        nameco.setCellValueFactory(new PropertyValueFactory<ins, String>("Iname"));
        proco.setCellValueFactory(new PropertyValueFactory<ins, String>("producer"));
        roomco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Rid"));
        tableforin.setItems(FXCollections.observableArrayList());
        tableforin.setItems(ob2);
        }
        else if(!insnamel.getText().isEmpty()){
            rs = st.executeQuery("select * from instruments i where i.Iname = '"+insnamel.getText()+"'");
        while(rs.next()){
            ob2.add(new ins(rs.getString("producer"), rs.getString("Iname"),rs.getInt("Iid"),rs.getInt("Rid")));
        }
        anchorins.setVisible(true);
        anchorforclass.setVisible(false);
        idco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Iid"));
        nameco.setCellValueFactory(new PropertyValueFactory<ins, String>("Iname"));
        proco.setCellValueFactory(new PropertyValueFactory<ins, String>("producer"));
        roomco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Rid"));
        tableforin.setItems(FXCollections.observableArrayList());
        tableforin.setItems(ob2);
        }
        else if(!insroomidl.getText().isEmpty()){
            rs = st.executeQuery("select * from instruments i where i.Rid = '"+Integer.parseInt(insroomidl.getText())+"'");
        while(rs.next()){
            ob2.add(new ins(rs.getString("producer"), rs.getString("Iname"),rs.getInt("Iid"),rs.getInt("Rid")));
        }
        anchorins.setVisible(true);
        anchorforclass.setVisible(false);
        idco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Iid"));
        nameco.setCellValueFactory(new PropertyValueFactory<ins, String>("Iname"));
        proco.setCellValueFactory(new PropertyValueFactory<ins, String>("producer"));
        roomco.setCellValueFactory(new PropertyValueFactory<ins, Integer>("Rid"));
        tableforin.setItems(FXCollections.observableArrayList());
        tableforin.setItems(ob2);
        }
        else{
            String msg = "search on instrument name or room id or instrument id ";
            mkRfmd3();
        }
    }
    @FXML
    void showins(ActionEvent event) throws Exception {
        mkRfmd3();
    }
    @FXML
    void showclasses(ActionEvent event) throws Exception {
        mkRfmd2();
    }
    @FXML 
    TextField repid;
    @FXML
    TextArea textarea;
   @FXML AnchorPane Reportmohannad;
    @FXML
   public void out(ActionEvent event)  {
       Reportmohannad.setVisible(false);
       
        vbbtn.setVisible(true);
        vbtxt.setVisible(true);
        met.setVisible(true);
        mmaleb.setVisible(true);
        mfemaleb.setVisible(true);
    }
  
    
      @FXML
   public void reportbtn(ActionEvent event)  {
       Reportmohannad.setVisible(true);
       vbbtn.setVisible(false);
        vbtxt.setVisible(false);
      met.setVisible(false);
       mmaleb.setVisible(false);
       mfemaleb.setVisible(false);
    }
      @FXML
   public void inacction(ActionEvent ecent) throws Exception{
       if(!repid.getText().isEmpty()){
           Integer id = Integer.parseInt(repid.getText());
           Connection conn = dbconnection.getConnection();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from employee e where e.ssn = '"+id+"'");
           ob3.clear();
        while (rs.next()) {
            ob3.add(new Employee(rs.getString("name"),rs.getString("DOB"),rs.getString("gender"),rs.getString("Address"),
                    rs.getString("number"),rs.getString("since"),rs.getString("end"),rs.getString("jobTitle"),
                    rs.getInt("ssn"),rs.getInt("salary")));
        }
        tableid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ssn"));
        tabelen.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        tabledob.setCellValueFactory(new PropertyValueFactory<Employee, String>("DOB"));
        tablegender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        tableaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tablesalary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        tablephone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tablesince.setCellValueFactory(new PropertyValueFactory<Employee, String>("since"));
        tablespe.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobtitle"));
        tableend.setCellValueFactory(new PropertyValueFactory<Employee, String>("end"));
        met.setItems(FXCollections.observableArrayList());
        met.setItems(ob3);
        textarea.setText(tabelen.getCellData(0)+" "+tableid.getCellData(0)+" "+tableaddress.getCellData(0)+" "+tablesalary.getCellData(0)
                +" "+tablephone.getCellData(0)+" "+tabledob.getCellData(0)+" "+tablegender.getCellData(0)+" "+tablesince.getCellData(0)
                +" "+tablespe.getCellData(0)+" "+tableend.getCellData(0));
       }
       else{
           repid.setText("enter employee id");
       }
   }
    @FXML
   public void inacctionS(ActionEvent ecent) throws Exception{
       String data = textarea.getText();
       String[] out = data.split(" ");
        System.out.println(out[0]);
        Connection conn = dbconnection.getConnection();
        conn.prepareStatement("update employee set ssn = '"+ out[1]+"', name = '"+out[0]+"', address = '"+out[2]+"', DOB = '"+out[5]+"', gender = '"+out[6]
                +"', salary = '"+out[3]+"', number = '" +out[4]+"', jobTitle = '"+ out[8]+ "' where ssn = '"+ out[1]+"'").executeUpdate();
   }
   //fill text area
 /*   @FXML TextArea textarea,textbox;
    @FXML TextField reportid;
    
   @FXML
    private void texttarea(ActionEvent event) {
        int id=Integer.parseInt(reportid.getText());
        dbconnection db=new dbconnection();
           textarea.setText(db.getdata(id)+ "\n"+
                   db.getdataFrom_member_box(id));
            
    
    }
  
*/   
   
   
   @FXML VBox vbbtn,vbtxt;

}
