package ordersForm;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Myorders.orders;

public class OrdersForm implements ActionListener {
		JFrame frame;
		JLabel order_id_lb=new JLabel("ORDER ID");
		JLabel customer_id_lb=new JLabel("CUSTOMER ID");
		JLabel total_amount_lb=new JLabel("TOTAL AMOUNT");
		JLabel order_date_lb=new JLabel("ORDER DATE");

		JTextField order_id_txf=new JTextField();
		JTextField customer_id_txf=new JTextField();
		JTextField total_amount_txf=new JTextField();
		JTextField order_date_txf=new JTextField();

		//Buttons CRUD
		JButton insert_btn=new JButton("Insert");
		JButton Read_btn=new JButton("View");
		JButton update_tbtn=new JButton("Update");
		JButton delete_btn=new JButton("Delete");
		
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=(int) screensize.getWidth();
		int h=(int) screensize.getHeight();
		public OrdersForm() {
			createForm();
			actionEvent();
			setFontforall();
			addComponentToFrame();
			setLocationandSize();
		}

		private void actionEvent() {
			insert_btn.addActionListener(this);
			Read_btn.addActionListener(this);
			update_tbtn.addActionListener(this);
			delete_btn.addActionListener(this);
			//genderBox.addActionListener(this);
		}
		private void createForm() {
			frame=new JFrame();
			frame.setTitle("ORDERS FORM");
			frame.setBounds(0, 0, w/2, h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.CYAN);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			}

		private void setLocationandSize() {
			order_id_lb.setBounds(10, 10, 130, 30);
			customer_id_lb.setBounds(10, 50, 150, 30);
			total_amount_lb.setBounds(10, 90, 170, 30);
			order_date_lb.setBounds(10, 130, 150, 30);
			
			
			order_id_txf.setBounds(200, 10, 170, 30);
			customer_id_txf.setBounds(200, 50, 170, 30);
			total_amount_txf.setBounds(200, 90, 170, 30);
			order_date_txf.setBounds(200, 130, 170, 30);
			
			//Buttons CRUD
			insert_btn.setBounds(10,250, 100, 60);
			Read_btn.setBounds(120,250, 100, 60);
			update_tbtn.setBounds(230,250, 100, 60);
			delete_btn.setBounds(340,250, 100, 60);
			table.setBounds(500, 10, 600, 240);
			
		}
		private void setFontforall() {
			Font font = new Font("Georgia", Font.BOLD, 18);

			order_id_lb.setFont(font);
			customer_id_lb.setFont(font);
			total_amount_lb.setFont(font);
			order_date_lb.setFont(font);
			

			order_id_txf.setFont(font);
			customer_id_txf.setFont(font);
			total_amount_txf.setFont(font);
			order_date_txf.setFont(font);
			
			//Buttons CRUD
			Font fonti = new Font("Courier New", Font.BOLD, 15);

			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_tbtn.setFont(fonti);
			delete_btn.setFont(fonti);

		}
		private void addComponentToFrame() {
			frame.add(order_id_lb);
			frame.add(customer_id_lb);
			frame.add(total_amount_lb);
			frame.add(order_date_lb);
			
			frame.add(order_id_txf);
			frame.add(customer_id_txf);
			frame.add(total_amount_txf);
			frame.add(order_date_txf);
			
			//Buttons CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_tbtn);
			frame.add(delete_btn);
			frame.add(table);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			orders ord=new orders();
			if(e.getSource()==insert_btn) {
				ord.setCustomer_id(customer_id_txf.getText());
				ord.setTotal_amount(total_amount_txf.getText());
				ord.setOrder_date(order_date_txf.getText());
				
				
				ord.insertData();
				
			}else if (e.getSource() == Read_btn) {
				model.setColumnCount(0);
				model.setRowCount(1);
				model.addColumn("StaffID");
	            model.addColumn("CustomerID");
	            model.addColumn("Total Amount");
	            model.addColumn("Order Date");
	           
	            ResultSet resultSet =orders.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
		    else if (e.getSource()==update_tbtn) {
		    	int id=Integer.parseInt(order_id_txf.getText());
		    	ord.setCustomer_id(customer_id_txf.getText());
		    	ord.setTotal_amount(total_amount_txf.getText());
		    	ord.setOrder_date(order_date_txf.getText());
				
		    	ord.update(id);
		    }
		  else {
				int id=Integer.parseInt(order_id_txf.getText());
				ord.delete(id);}

		  }		
			public static void main(String[] args) {
				OrdersForm ef=new OrdersForm();
				System.out.println(ef);
			
				
			}

		}

