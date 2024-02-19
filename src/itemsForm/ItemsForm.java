package itemsForm;


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

import Myitems.items;

public class ItemsForm implements ActionListener {
		JFrame frame;
		JLabel item_id_lb=new JLabel("Item ID");
		JLabel name_lb=new JLabel("NAME");
		JLabel description_lb=new JLabel("DESCRIPTION");
		JLabel price_lb=new JLabel("PRICE");

		JTextField item_id_txf=new JTextField();
		JTextField name_txf=new JTextField();
		JTextField description_txf=new JTextField();
		JTextField price_txf=new JTextField();

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
		public ItemsForm() {
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
			
		}
		private void createForm() {
			frame=new JFrame();
			frame.setTitle("ITEMS FORM");
			frame.setBounds(0, 0, w/2, h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.CYAN);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			}

		private void setLocationandSize() {
			item_id_lb.setBounds(10, 10, 130, 30);
			name_lb.setBounds(10, 50, 120, 30);
			description_lb.setBounds(10, 90, 140, 30);
			price_lb.setBounds(10, 130, 100, 30);
			
			
			item_id_txf.setBounds(200, 10, 170, 30);
			name_txf.setBounds(200, 50, 170, 30);
			description_txf.setBounds(200, 90, 170, 30);
			price_txf.setBounds(200, 130, 170, 30);
			
			//Buttons CRUD
			insert_btn.setBounds(10,250, 100, 60);
			Read_btn.setBounds(120,250, 100, 60);
			update_tbtn.setBounds(230,250, 100, 60);
			delete_btn.setBounds(340,250, 100, 60);
			table.setBounds(500, 10, 600, 240);
			
		}
		private void setFontforall() {
			Font font = new Font("Georgia", Font.BOLD, 18);

			item_id_lb.setFont(font);
			name_lb.setFont(font);
			description_lb.setFont(font);
			price_lb.setFont(font);
			

			item_id_txf.setFont(font);
			name_txf.setFont(font);
			description_txf.setFont(font);
			price_txf.setFont(font);
			
			//Buttons CRUD
			Font fonti = new Font("Courier New", Font.BOLD, 15);

			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_tbtn.setFont(fonti);
			delete_btn.setFont(fonti);

		}
		private void addComponentToFrame() {
			frame.add(item_id_lb);
			frame.add(name_lb);
			frame.add(description_lb);
			frame.add(price_lb);
			
			frame.add(item_id_txf);
			frame.add(name_txf);
			frame.add(description_txf);
			frame.add(price_txf);
			
			//Buttons CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_tbtn);
			frame.add(delete_btn);
			frame.add(table);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			items imf=new items();
			if(e.getSource()==insert_btn) {
				imf.setName(name_txf.getText());
				imf.setDescription(description_txf.getText());
				imf.setPrice(price_txf.getText());
				imf.insertData();
				
			}else if (e.getSource() == Read_btn) {
				model.setColumnCount(0);
				model.setRowCount(1);
				model.addColumn("ItemID");
	            model.addColumn("NAME");
	            model.addColumn("DESCRIPTION");
	            model.addColumn("PRICE");
	           
	            ResultSet resultSet =items.viewData();
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
		    	int id=Integer.parseInt(item_id_txf.getText());
		    	imf.setName(name_txf.getText());
		    	imf.setDescription(description_txf.getText());
		    	imf.setPrice(price_txf.getText());
				
				
		    	imf.update(id);
		    }
		  else {
				int id=Integer.parseInt(item_id_txf.getText());
				imf.delete(id);}

		  }		
			public static void main(String[] args) {
				ItemsForm ef=new ItemsForm();
				System.out.println(ef);
			
				
			}

		}


