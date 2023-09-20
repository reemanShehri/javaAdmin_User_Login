package LabFinalProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class ShowAll extends JFrame{

	Container c;
	JScrollPane j;
	JTable table;
	DataBase data;
	DefaultTableModel model;
	ShowAll(DataBase data){
		c=getContentPane();
		String head[]= {"ID","Date","Customer"};
		model=new DefaultTableModel(new String[][] {},head);
		table=new JTable(model);
		j=new JScrollPane(table);
		data.settable(data.getordered(), model);
		
		c.setBackground(Color.yellow);
		c.setLayout(null);
		j.setBounds(40,40,400,400);
		
		c.add(j);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,500);
		
	}
}
