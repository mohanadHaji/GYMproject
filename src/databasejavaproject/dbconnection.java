


package databasejavaproject;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class dbconnection {
    
    
    private Connection con=null;
    private Statement st;
    private ResultSet rst;
     PreparedStatement ps=null;
    //private PreparedStatement pst;
    
    
    public dbconnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gymprojec","root","1234");
            
           
            st= con.createStatement();
          
            if(con!=null)        
            System.out.println("Welcom we inside data");

        } catch (Exception ex) {
           System.out.println("Eroor"+ex);
        }
        
      
    }
    
   //get data from data base  //**************************member****************************
    public void getdata()
    {
       String query ="select * from memberr";
        try {
            rst= st.executeQuery(query);
            while(rst.next())
       {
           String membername = rst.getString("membername");
           String memberid = rst.getString("memberid");
           String gender = rst.getString("gender");
           String address = rst.getString("address");
           String date = rst.getString("date");
           String weight = rst.getString("weight");
             System.out.println("  Name:-"+membername+"  id:-"+memberid +" gender:-"+gender+"  address:-"+address+"  date:-"+date+"  weight:-"+weight);
        
   }     
            
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void insertmemintodata(String membername,String gender,String address,LocalDate date,int weight) 
            {
                try{
                rst = st.getGeneratedKeys();
			if (rst.next()) {
				System.out.println("Auto Generated Primary Key " + rst.getInt(2));
			}
                
                }
                catch(SQLException ex)
                {
                  //syso
                          
                }
    
            //String query="INSERT into memberr " +
        //"(membername,gender,address,date,weight)" + " values(membername,gender,address,date,weight)"; 
               //  String query ="insert into memberr (membername, gender, address, date, weight)"+membername+"','"+gender+"','"+address+"','"+date+"','"+weight+"');";
               // String query ="insert into memberr"+membername+"','"+gender+"','"+address+"','"+date+"','"+weight+"');";
            
               String query ="insert into memberr values ('"+membername+"','"+0+"','"+gender+"','"+address+"','"+date+"','"+weight+"');";//String query ="insert into memberr (membername,gender,address,date,weight) values (membername,gender,address,date,weight)";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "The Insert Has Problem" );
            System.out.println("The Insert Has Problem");
        }
        
        }
                
    
            
    
    
     public void deletefrommysql() throws SQLException
     {
         
          String query ="delete from memberr where memberid = '4'";
          st.executeUpdate(query);
         
         
         
     }
            
    public  ObservableList<memberclass> getmember()
    {
       // dbconnection con =new dbconnection();
        
        ObservableList<memberclass>list= FXCollections.observableArrayList();
       
       
             String query="select * from memberr";
             //Statement pst;
        try {
           // pst = con.prepareStatement(query);
             rst=st.executeQuery(query);
             while(rst.next())
                   {
             
                    list.add(new memberclass(rst.getString("membername"),Integer.parseInt(rst.getString("memberid")),rst.getString("gender"),rst.getString("address"),rst.getString("date"),Integer.parseInt(rst.getString("weight"))));
         //now the list is full data from mysql
                   
                   }
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
          return list;
    
        
    }
    
    public  boolean updatememberinfo(String name,String genderr,String addresss,String dateofbirthh,int weightt,int id) throws SQLException
    {
           //String query = "update memberr set membername='"+name+"',gender='"+genderr+"',address='"+addresss+"',date='"+dateofbirthh+"',weight='"+weightt+"'"+where;       

        //String query = "update memberr set membername='"+name+"',gender='"+genderr+"',address='"+addresss+"',date='"+where;       
        try {
                    //String query = "update memberr set membername = ' " + name + " ' , gender ='  " + genderr + " ', address = ' " + addresss + " ' , date = ' " + dateofbirthh + " ', weight = ' " +weightt+ " ' " +where;       
   String query="Update memberr set membername='"+name+"', gender='"+genderr+"', address='"+addresss+"',date='"+dateofbirthh+"', weight='"+weightt+"' where memberid='"+id+"' ";

             ps= con.prepareStatement(query);
           return !ps.execute();
          // rst=ps.executeQuery();
            
            
// String table="memberr";
// String query ="update memberr"+ table+"set membername="+membernamee+",memberid="+memberidd+",gender"+genderr+",address"+addresss+",""date"+dateofbirthh+",weight"+weightt";
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
            
           
        }
        
        return false;
    }
    
   // ************************************************end member****************************
  //****************************************************start box*********************
    
    
    public void isertnewbox(int nobox,int capacity)
      {
            
               String query ="insert into box values ('"+nobox+"','"+capacity+"');";//String query ="insert into memberr (membername,gender,address,date,weight) values (membername,gender,address,date,weight)";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "The Insert of Box Has Problem" );
            //System.out.println("The Insert Has Problem");
        }
        
        }
    
     public void deletebox(int id)
      {
      
    String query ="delete from box where bid ='"+id+"' ";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }  
     
    public void insertintoreservedbox(int idmem,int idbox,LocalDate start,LocalDate end)
    {String startt = start.toString();
    String endd = end.toString();
     
      String query ="insert into mrentb values ('"+startt+"','"+endd+"','"+2+"','"+idbox+"','"+idmem+"');";//String query ="insert into memberr (membername,gender,address,date,weight) values (membername,gender,address,date,weight)";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "The Insert Box Has Problem" );
            System.out.println("The Insert Box Has Problem");
        }
        
        }
    
    public boolean insertCustomerToData(String CustomerName,int id) 
            {
                try{
                rst = st.getGeneratedKeys();
			if (rst.next()) {
				System.out.println("Auto Generated Primary Key " + rst.getInt(2));
			}
                
                }
                catch(SQLException ex)
                {                
                          
                }
    
           
               String query ="insert into Customer values ("+id +",'"+CustomerName +"');"; //Add Customer to data BAse
        try {
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
            
        }
        
        }


    
    public ResultSet getCustomersFromBase() 
{
                
           
              String query ="select * from customer;";
        try {
            rst= st.executeQuery(query);
            return rst;     
            
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
            return rst;
        }   
        
}
    
    public boolean insertGoodToData(String goodName,int id,float price,int quantity) 
            {
                   
   
               String query ="insert into Goods values (" +id +"," +quantity  +",'"+goodName +"'," +price  +");"; //Add Customer to data BAse
        try {
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
            
        }
        
        }  
    public static Connection getConnection() throws Exception {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gymprojec","root","1234");
			
			
			return conn;
		}
}    
    

    
    /*
    
     public String getdataFrom_member_box(int mid)
    {
        String staee=null;
        //daterentstart varchar(40),daterentend varchar(40),priceofrent int , bid int , memberid int ,

       String query ="select * from mrentb where memberid='"+mid+"' ";
        try {
            rst= st.executeQuery(query);
            while(rst.next())
       {
           String daterentstart = rst.getString("daterentstart");
           String daterentend = rst.getString("daterentend");
           int priceofrent = rst.getInt("priceofrent");
           int bid = rst.getInt("bid");
             mid = rst.getInt("memberid");
            staee="  Date rent Start:-"+daterentstart+"  Date Rent End:-"+daterentend +" Price of Rent:-"+priceofrent+"  Box ID:-"+bid;
        
   }     
            
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staee; 
       
    }
    */
    
