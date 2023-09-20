package LabFinalProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class Customer extends JFrame implements ActionListener{

	Container c;
	JLabel id,first,last,tel,email;
	JTextField tid,tfirst,tlast,ttel,temail;
	JButton clear,insert,remove;
	JScrollPane j;
	JTable table;
	DataBase data;
	DefaultTableModel model;
	Customer(DataBase data){
		this.data=data;
		c=getContentPane();
		id=new JLabel("ID:");first=new JLabel("First Name:");last=new JLabel("Last Name:");
		tel=new JLabel("Tel:");email=new JLabel("Email:");
		tid=new JTextField();tfirst=new JTextField();tlast=new JTextField();
		ttel=new JTextField();temail=new JTextField();
		clear=new JButton("Clear");insert=new JButton("Insert");remove=new JButton("Remove");
		String head[]= {"ID","First Name","Last Name","Tel","Email"};
		model=new DefaultTableModel(new String[][] {},head);
		table=new JTable(model);
		j=new JScrollPane(table);
		data.settable(data.getcustomer(), model);
		
		remove.setBackground(Color.red);
		remove.setForeground(Color.white);
		clear.setBackground(Color.orange);
		clear.setForeground(Color.white);
		insert.setBackground(Color.green);
		insert.setForeground(Color.white);
		insert.addActionListener(this);clear.addActionListener(this);remove.addActionListener(this);
		
		c.setLayout(null);
		c.setBackground(Color.DARK_GRAY);
		id.setForeground(Color.white);first.setForeground(Color.white);last.setForeground(Color.white);
		tel.setForeground(Color.white);email.setForeground(Color.white);
		
	    id.setBounds(20,20,100,25);first.setBounds(20,60,100,25);last.setBounds(20,100,100,25);tel.setBounds(20,140,100,25);
	    email.setBounds(20,180,100,25);tid.setBounds(130,20,130,25);tfirst.setBounds(130,60,130,25);tlast.setBounds(130,100,130,25);
	    ttel.setBounds(130,140,130,25);temail.setBounds(130,180,130,25);
	    clear.setBounds(20,230,235,25);insert.setBounds(280,280,150,25);remove.setBounds(530,280,150,25);
		j.setBounds(280,10,400,250);
	    
		c.add(id);c.add(first);c.add(last);c.add(tel);c.add(email);c.add(tid);
		c.add(tfirst);c.add(tlast);c.add(ttel);c.add(temail);c.add(remove);c.add(insert);
		c.add(j);c.add(clear);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700,500);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insert) {
			if(tid.getText().equals("")||tfirst.getText().equals("")||tlast.getText().equals("")||ttel.getText().equals("")||temail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pls Input all data");
			}
			else {
			String s[]=new String[] {tid.getText(), tfirst.getText(), tlast.getText(), ttel.getText(), temail.getText()};
			data.add(s,data.getcustomer());
			model.addRow(s);
			tid.setText("");tfirst.setText("");tlast.setText("");ttel.setText("");temail.setText("");
		}}
		else if(e.getSource()==remove) {
			if(table.getSelectedRowCount()==1) {
			data.remove(table.getSelectedRow(),data.getcustomer());
			model.removeRow(table.getSelectedRow());}
			else {
				JOptionPane.showMessageDialog(null, "Pls Select a Single row");
			}
		}
		else if(e.getSource()==clear) {
			tid.setText("");tfirst.setText("");tlast.setText("");ttel.setText("");temail.setText("");
		}
		
	}

}
