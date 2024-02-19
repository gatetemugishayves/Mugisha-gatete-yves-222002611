package Myitems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class items {
	private int item_id;
	private String name;
	private String description	;
	private String price;
public items (int item_id,String name,String description	,String price) {
	super();
	this.item_id= item_id;
	this.name= name;
	this.description= description;
	this.price= price;
}
public items() {
	// TODO Auto-generated constructor stub
}
public int getItem_id() {
	return item_id;
}
public void setItem_id(int item_id) {
	this.item_id = item_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO items (name,description,price) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.name);
       preparedStatement.setString(2, this.description);
       preparedStatement.setString(3, this.price);
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

	        String sql = "SELECT * FROM items";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputitem_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE items SET  name=? description=? price=?    WHERE item_id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getName());
          stm.setString(2, this.getDescription());
          stm.setString(3, this.getPrice());

          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputitem_id);
       
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
public void delete(int inputitem_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/yves_gatetemugisha_orms";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM items WHERE  item_id =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputitem_id); // Assuming there is a column named 'id' for the WHERE clause

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





