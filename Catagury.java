package LabFinalProject;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Catagury extends JFrame implements ActionListener{

	Container c;
	JLabel id,name;
	JButton next,previous,insert,delete;
	JTable table;
	JTextField tid,tname;
	JScrollPane j;
	DataBase data;
	int index;
	DefaultTableModel model;
	Catagury(DataBase data){
		
		this.data=data;
		c=getContentPane();
		id=new JLabel("ID:");name=new JLabel("Name:");
		next=new JButton("Next");previous=new JButton("Previous");insert=new JButton("Insert New Catagury");delete=new JButton("Delete Selected Catagury");
		model=new DefaultTableModel(new String[][] {},new String[] {"ID","Name"});
		table =new JTable(model);
		j=new JScrollPane(table);
		tid=new JTextField();tname=new JTextField();
		data.settable(data.getcatagury(), model);
		
		c.setBackground(Color.gray);
		id.setForeground(Color.white);name.setForeground(Color.white);next.setForeground(Color.white);
		previous.setForeground(Color.white);delete.setForeground(Color.white);insert.setForeground(Color.white);
		next.setBackground(Color.DARK_GRAY);previous.setBackground(Color.DARK_GRAY);
		insert.setBackground(Color.green);delete.setBackground(Color.red);
		tid.setEditable(false);
		if(data.getcatagury().size()>0) {
		tid.setText(data.getcatagury().get(0)[0]);tname.setText(data.getcatagury().get(0)[1]);
		table.setRowSelectionInterval(0, 0);}
		c.setLayout(null);
		
		c.add(name);c.add(id);c.add(tname);c.add(tid);c.add(next);
		c.add(previous);c.add(delete);c.add(insert);c.add(j);
		
		next.addActionListener(this);previous.addActionListener(this);insert.addActionListener(this);delete.addActionListener(this);
		id.setBounds(20,50,50,25);tid.setBounds(80,50,120,25);name.setBounds(20,100,50,25);tname.setBounds(80,100,120,25);
		next.setBounds(20,170,90,25);previous.setBounds(130,170,90,25);
		insert.setBounds(20,250,200,40);delete.setBounds(20,300,200,40);
		j.setBounds(230,50,200,250);
		
		this.setSize(500,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next) {
			if(table.getSelectedRow()<data.getcatagury().size()-1) {
				table.setRowSelectionInterval(index+1, index+1);
				tid.setText(data.getcatagury().get(table.getSelectedRow())[0]);tname.setText(data.getcatagury().get(table.getSelectedRow())[1]);
				index++;
			}
		}
		else if(e.getSource()==previous) {
			if(table.getSelectedRow()>0) {
				table.setRowSelectionInterval(index-1, index-1);
				tid.setText(data.getcatagury().get(table.getSelectedRow())[0]);tname.setText(data.getcatagury().get(table.getSelectedRow())[1]);
				index--;
			}
		}
		else if(e.getSource()==insert) {
			if(tname.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pls Input all data");
			}
			else {
				String[] s =new String[] {data.getCataguryIndex()+"",tname.getText()};
			data.add(s,data.getcatagury());
			model.addRow(s);
			JOptionPane.showMessageDialog(null, "Data added successfully");
			tid.setText("");tname.setText("");
			tid.setText(data.getcatagury().get(0)[0]);tname.setText(data.getcatagury().get(0)[1]);
			table.setRowSelectionInterval(0, 0);
			index=0;}
		}
		else if(e.getSource()==delete) {
			    data.remove(table.getSelectedRow(),data.getcatagury());
			    if(table.getSelectedRowCount()==1) {
			    model.removeRow(table.getSelectedRow());
			    if(data.getcatagury().size()>0) {
			    tid.setText(data.getcatagury().get(0)[0]);tname.setText(data.getcatagury().get(0)[1]);
				table.setRowSelectionInterval(0, 0);
				index=0;}}
			    else if(table.getSelectedRowCount()==0)
			    	JOptionPane.showMessageDialog(null, "Pls select a row");
			    else
			    	JOptionPane.showMessageDialog(null, "Pls select a single row");
			
		}
		
	}

}
