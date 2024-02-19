package Myorders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class orders {
	private int order_id;
	private String customer_id;
	private String 	total_amount	;
	private String order_date;
public orders (int order_id,String customer_id,String total_amount,String order_date) {
	super();
	this.order_id= order_id;
	this.customer_id= customer_id;
	this.total_amount= total_amount;
	this.order_date= order_date;
}
public orders() {
	// TODO Auto-generated constructor stub
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public String getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}
public String getTotal_amount() {
	return total_amount;
}
public void setTotal_amount(String total_amount) {
	this.total_amount = total_amount;
}
public String getOrder_date() {
	return order_date;
}
public void setOrder_date(String order_date) {
	this.order_date = order_date;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO orders ( customer_id, total_amount,order_date) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.customer_id);
       preparedStatement.setString(2, this.total_amount);
       preparedStatement.setString(3, this.order_date);

       //preparedStatement.setString(6, this.gender);
       
          
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM orders";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputorder_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE orders SET  customer_id=? total_amount=? order_date=?   WHERE order_id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getCustomer_id());
          stm.setString(2, this.getTotal_amount());
          stm.setString(3, this.getOrder_date());
         
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputorder_id);
       
        // Execute the update
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to update data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputorder_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM orders WHERE  order_id =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputorder_id); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}

