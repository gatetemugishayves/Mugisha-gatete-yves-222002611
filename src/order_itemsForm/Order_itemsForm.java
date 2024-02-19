package order_itemsForm;

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

import Myorder_items.order_items;


public class Order_itemsForm implements ActionListener {
	JFrame frame;
	JLabel order_item_id_lb=new JLabel("OrderItemID");
	JLabel order_id_lb=new JLabel("Order ID");
	JLabel item_id_lb=new JLabel("Item ID");
	JLabel quantity_lb=new JLabel("QAULITY");

	JTextField order_item_id_txf=new JTextField();
	JTextField order_id_txf=new JTextField();
	JTextField item_id_txf=new JTextField();
	JTextField quantity_txf=new JTextField();

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
	public Order_itemsForm() {
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
		frame.setTitle("ORDER-ITEMES FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		order_item_id_lb.setBounds(10, 10, 130, 30);
		order_id_lb.setBounds(10, 50, 150, 30);
		item_id_lb.setBounds(10, 90, 170, 30);
		quantity_lb.setBounds(10, 130, 150, 30);
		
		
		order_item_id_txf.setBounds(200, 10, 170, 30);
		order_id_txf.setBounds(200, 50, 170, 30);
		item_id_txf.setBounds(200, 90, 170, 30);
		quantity_txf.setBounds(200, 130, 170, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		order_item_id_lb.setFont(font);
		order_id_lb.setFont(font);
		item_id_lb.setFont(font);
		quantity_lb.setFont(font);
		

		order_item_id_txf.setFont(font);
		order_id_txf.setFont(font);
		item_id_txf.setFont(font);
		quantity_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(order_item_id_lb);
		frame.add(order_id_lb);
		frame.add(item_id_lb);
		frame.add(quantity_lb);
		
		frame.add(order_item_id_txf);
		frame.add(order_id_txf);
		frame.add(item_id_txf);
		frame.add(quantity_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		order_items ois=new order_items();
		if(e.getSource()==insert_btn) {
			ois.setOrder_id(order_id_txf.getText());
			ois.setItem_id(item_id_txf.getText());
			ois.setQuantity(quantity_txf.getText());
			ois.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("OrderItemID");
            model.addColumn("ORDER ID");
            model.addColumn("ITEM ID");
            model.addColumn("QAULITY");
            
           
            ResultSet resultSet =order_items.viewData();
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
	    	int id=Integer.parseInt(order_item_id_txf.getText());
	    	ois.setOrder_id(order_id_txf.getText());
	    	ois.setItem_id(item_id_txf.getText());
	    	ois.setQuantity(quantity_txf.getText());
			
			
	    	ois.update(id);
	    }
	  else {
			int id=Integer.parseInt(order_item_id_txf.getText());
			ois.delete(id);}

	  }		
		public static void main(String[] args) {
			Order_itemsForm ef=new Order_itemsForm();
			System.out.println(ef);
		
			
		}

	}




