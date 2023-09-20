package LabFinalProject;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	JLabel name,pass,acc;
	JTextField tname,tpass;
	JButton login;
	Container c;
	DataBase data;
	Login(){
		data=new DataBase();
		c=getContentPane();
		name=new JLabel("UserName:");pass=new JLabel("Password:");acc=new JLabel("<html><u>Account Login<u><html>");
		tname=new JTextField();tpass=new JPasswordField();
		login=new JButton("Login");
		c.setLayout(null);
		
		c.setBackground(Color.darkGray);
		acc.setForeground(Color.WHITE);name.setForeground(Color.WHITE);pass.setForeground(Color.WHITE);
		acc.setFont(new Font("Arial",Font.BOLD,26));name.setFont(new Font("Arial",Font.PLAIN,15));pass.setFont(new Font("Arial",Font.PLAIN,15));
		login.setBackground(Color.RED);login.setForeground(Color.white);login.setFont(new Font("Arial",Font.BOLD,12));
		login.addActionListener(this);
		
		acc.setBounds(50,0,200,50);name.setBounds(25,60,100,25);pass.setBounds(25,100,100,25);
		tname.setBounds(120,60,180,25);tpass.setBounds(120,100,180,25);
		login.setBounds(55, 170, 250, 30);
		
		c.add(name);c.add(tname);c.add(pass);c.add(tpass);c.add(acc);c.add(login);
		
		this.setSize(350,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int x=data.login(tname.getText(),tpass.getText());
		if(x==2) {
			new Home(true,data);
			tname.setText("");tpass.setText("");
		}
		else if(x==1) {
			new Home(false,data);
			tname.setText("");tpass.setText("");
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong Name or Password \n Pls try Again");
		}
	}

}
