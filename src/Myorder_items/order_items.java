package Myorder_items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class order_items {
	private int order_item_id;
	private String order_id ;
	private String item_id	;
	private String quantity;
public order_items (int order_item_id,String order_id,String item_id	,String quantity) {
	super();
	this.order_item_id= order_item_id;
	this.order_id= order_id;
	this.item_id= item_id;
	this.quantity= quantity;
}
public order_items() {
	// TODO Auto-generated constructor stub
}
public int getOrder_item_id() {
	return order_item_id;
}
public void setOrder_item_id(int order_item_id) {
	this.order_item_id = order_item_id;
}
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getItem_id() {
	return item_id;
}
public void setItem_id(String item_id) {
	this.item_id = item_id;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO order_items ( order_id, item_id,quantity) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.order_id);
       preparedStatement.setString(2, this.item_id);
       preparedStatement.setString(3, this.quantity);
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

	        String sql = "SELECT * FROM order_items";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputorder_item_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE order_items SET  order_id=? item_id=? quantity=?    WHERE order_item_id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getOrder_id());
          stm.setString(2, this.getItem_id());
          stm.setString(3, this.getQuantity());

          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputorder_item_id);
       
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
public void delete(int inputorder_item_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM order_items WHERE  order_item_id =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputorder_item_id); // Assuming there is a column named 'id' for the WHERE clause

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




