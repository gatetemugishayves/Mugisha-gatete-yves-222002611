package staffForm;

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

import Mystaff.staff;


public class StaffForm implements ActionListener{
	JFrame frame;
	JLabel staff_id_lb=new JLabel("STAFFID");
	JLabel name_lb=new JLabel("NAME");
	JLabel role_lb=new JLabel("ROLE");
	JLabel email_lb=new JLabel("EMAIL");
	JLabel phone_lb=new JLabel("PHONE");

	JTextField staff_id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField role_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phone_txf=new JTextField();


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
	public StaffForm() {
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
		frame.setTitle("STAFF FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		staff_id_lb.setBounds(10, 10, 130, 30);
		name_lb.setBounds(10, 50, 150, 30);
		role_lb.setBounds(10, 90, 170, 30);
		email_lb.setBounds(10, 130, 150, 30);
		phone_lb.setBounds(10, 170, 150, 30);
		
		
		staff_id_txf.setBounds(200, 10, 170, 30);
		name_txf.setBounds(200, 50, 170, 30);
		role_txf.setBounds(200, 90, 170, 30);
		email_txf.setBounds(200, 130, 170, 30);
		phone_txf.setBounds(200, 170, 170, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		staff_id_lb.setFont(font);
		name_lb.setFont(font);
		role_lb.setFont(font);
		email_lb.setFont(font);
		phone_lb.setFont(font);
		

		staff_id_txf.setFont(font);
		name_txf.setFont(font);
		role_txf.setFont(font);
		email_txf.setFont(font);
		phone_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(staff_id_lb);
		frame.add(name_lb);
		frame.add(role_lb);
		frame.add(email_lb);
		frame.add(phone_lb);
		
		frame.add(staff_id_txf);
		frame.add(name_txf);
		frame.add(role_txf);
		frame.add(email_txf);
		frame.add(phone_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		staff tff =new staff();
		if(e.getSource()==insert_btn) {
			tff.setName(name_txf.getText());
			tff.setRole(role_txf.getText());
			tff.setEmail(email_txf.getText());
			tff.setPhone(phone_txf.getText());
			
			tff.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("staff_id");
            model.addColumn("name");
            model.addColumn("role");
            model.addColumn("email");
            model.addColumn("phone");
           
           
            ResultSet resultSet =staff.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(staff_id_txf.getText());
	    	tff.setName(name_txf.getText());
	    	tff.setRole(role_txf.getText());
	    	tff.setEmail(email_txf.getText());
	    	tff.setPhone(phone_txf.getText());
	  
			
	    	tff.update(id);
	    }
	  else {
			int id=Integer.parseInt(staff_id_txf.getText());
			tff.delete(id);}

	  }		
		public static void main(String[] args) {
			StaffForm ef=new StaffForm();
			System.out.println(ef);
		
			
		}

	}



