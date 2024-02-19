package MENU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu customersmenu;
    private JMenu itemsmenu;
    private JMenu ordersmenu;
    private JMenu order_itemsmenu;
    private JMenu staffmenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem customersItem;
    private JMenuItem itemsItem;
    private JMenuItem ordersItem;
    private JMenuItem order_itemsItem;
    private JMenuItem staffItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();
       

        // Create home menu
        customersmenu = new JMenu("customers");
        itemsmenu = new JMenu("items");
        ordersmenu= new JMenu("orders");
        order_itemsmenu = new JMenu("order_items ");
        staffItem = new JMenu("staff");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(customersmenu);
        customersItem = new JMenuItem("CustomersForm");
        customersItem.addActionListener(this);
        
        menuBar.add(itemsmenu);
        itemsItem = new JMenuItem("ItemsForm");
        itemsItem.addActionListener(this);
        
        menuBar.add(ordersmenu);
        ordersItem = new JMenuItem("OrdersForm");
        ordersItem.addActionListener(this);
        
        menuBar.add(order_itemsmenu);
        order_itemsItem = new JMenuItem("Order_itemsForm");
        order_itemsItem.addActionListener(this);
        
        menuBar.add(staffmenu);
        staffItem = new JMenuItem("StaffForm");
        staffItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        customersmenu.add(customersItem);
        itemsmenu.add(itemsItem);
        ordersmenu.add(ordersItem);
        order_itemsmenu.add(order_itemsItem);
        staffmenu.add(staffItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customersItem) {
            new customersForm.CustomersForm();
        
        } else if (e.getSource() == customersItem) {
            new itemsForm.ItemsForm();
        
        } else if (e.getSource() == ordersItem) {
            new ordersForm.OrdersForm();
       
        } else if (e.getSource() == order_itemsItem) {
           new order_itemsForm.Order_itemsForm();
        
        } else if (e.getSource() == staffItem) {
           new staffForm.StaffForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT"));
    }
}





