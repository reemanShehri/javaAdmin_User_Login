package LabFinalProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class User extends JFrame implements ActionListener{
	
	Container c;
	JLabel id,user,pass,full,tel,email;
	JTextField tid,tuser,tpass,tfull,ttel,temail;
	JButton clear,insert,remove;
	JScrollPane j;
	JTable table;
	DataBase data;
	String head[];
	DefaultTableModel model;
	User(DataBase data){
		this.data=data;
		c=getContentPane();
		id=new JLabel("ID:");user=new JLabel("UserName:");pass=new JLabel("Password:");
		full=new JLabel("FullName");tel=new JLabel("Tel:");email=new JLabel("Email:");
		tid=new JTextField();tuser=new JTextField();tpass=new JTextField();
		tfull=new JTextField();ttel=new JTextField();temail=new JTextField();
		clear=new JButton("Clear");insert=new JButton("Insert");remove=new JButton("Remove");
	    head= new String[]{"ID","UserName","Password","Fullname","Tel","Email"};
	    model=new DefaultTableModel(new String[][] {},head);
		table=new JTable(model);
		j=new JScrollPane(table);
		data.settable(data.getuser(), model);
		
		remove.setBackground(Color.red);
		remove.setForeground(Color.white);
		clear.setBackground(Color.orange);
		clear.setForeground(Color.white);
		insert.setBackground(Color.green);
		insert.setForeground(Color.white);
		insert.addActionListener(this);clear.addActionListener(this);remove.addActionListener(this);
		
		c.setLayout(null);
		c.setBackground(Color.DARK_GRAY);
		id.setForeground(Color.white);user.setForeground(Color.white);pass.setForeground(Color.white);
		full.setForeground(Color.white);tel.setForeground(Color.white);email.setForeground(Color.white);
		
	    id.setBounds(20,20,100,25);user.setBounds(20,60,100,25);pass.setBounds(20,100,100,25);full.setBounds(20,140,100,25);
	    tel.setBounds(20,180,100,25);email.setBounds(20,220,100,25);tid.setBounds(130,20,130,25);tuser.setBounds(130,60,130,25);
	    tpass.setBounds(130,100,130,25);tfull.setBounds(130,140,130,25);ttel.setBounds(130,180,130,25);temail.setBounds(130,220,130,25);
	    clear.setBounds(20,260,235,25);insert.setBounds(280,280,150,25);remove.setBounds(530,280,150,25);
		j.setBounds(280,10,400,250);
	    
		c.add(id);c.add(user);c.add(pass);c.add(tel);c.add(email);c.add(tid);c.add(full);
		c.add(tuser);c.add(tpass);c.add(ttel);c.add(temail);c.add(remove);c.add(insert);
		c.add(j);c.add(clear);c.add(tfull);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700,500);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insert) {
			if(tid.getText().equals("")||tuser.getText().equals("")||tpass.getText().equals("")||tfull.getText().equals("")||ttel.getText().equals("")||temail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pls Input all data");
			}
			else {
				String[] s=new String[] {tid.getText(), tuser.getText(), tpass.getText(),tfull.getText() ,ttel.getText(),temail.getText()};
			data.add(s, data.getuser());
			model.addRow(s);
			JOptionPane.showMessageDialog(null, "Data added successfully");
			tid.setText("");tuser.setText("");tpass.setText("");tfull.setText("");ttel.setText("");temail.setText("");
			}
		}
		else if(e.getSource()==remove) {
			if(table.getSelectedRowCount()==1) {
			data.remove(table.getSelectedRow(),data.getuser());
			model.removeRow(table.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Data deleted successfully");}
			else {
				JOptionPane.showMessageDialog(null, "Pls select a single row");
			}
		}
		else if(e.getSource()==clear) {
			tid.setText("");tuser.setText("");tpass.setText("");ttel.setText("");temail.setText("");tfull.setText("");
		}
		
	}

}
