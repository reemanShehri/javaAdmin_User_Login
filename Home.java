package LabFinalProject;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{

	Container c;
	JPanel home,side;
	JLabel pic,store;
	JMenuBar menubar;
	ImageIcon img;
	JButton product,catagury,customer,order,user;
	DataBase data;
	Home(boolean t,DataBase data){
		this.data=data;
		c= getContentPane();
		c.setLayout(new BorderLayout());
		img =new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\first\\src\\LabFinalProject\\Laptop.jpg");
		home=new JPanel();side=new JPanel();
		menubar =new JMenuBar();
		pic =new JLabel();store =new JLabel("My Store");
		product=new JButton("Product");catagury=new JButton("Catagury");customer=new JButton("Customer");order=new JButton("Order");user=new JButton("User");
		
		product.setBackground(Color.red);catagury.setBackground(Color.red);customer.setBackground(Color.red);order.setBackground(Color.red);user.setBackground(Color.red);
		product.setForeground(Color.white);catagury.setForeground(Color.white);customer.setForeground(Color.white);order.setForeground(Color.white);user.setForeground(Color.white);
		product.addActionListener(this);catagury.addActionListener(this);customer.addActionListener(this);order.addActionListener(this);user.addActionListener(this);
		side.setBackground(Color.orange);side.setPreferredSize(new Dimension(400,800));
		store.setFont(new Font("Ink Free",Font.BOLD,75));
		
		pic.setIcon(img);
		home.add(pic);
		side.add(store);
		menubar.add(product);menubar.add(catagury);menubar.add(customer);menubar.add(order);
		if(t)
		menubar.add(user);
		
		c.add(home,BorderLayout.CENTER);c.add(side,BorderLayout.EAST);
		
		this.setJMenuBar(menubar);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1300,800);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==product) {
			new Product(data);
		}
		else if(e.getSource()==catagury) {
			new Catagury(data);
		}
		else if(e.getSource()==customer) {
	        new Customer(data);
        }
		else if(e.getSource()==order) {
			new Order(data);
		}
		else if(e.getSource()==user) {
			new User(data);
		}
	}
	

}
