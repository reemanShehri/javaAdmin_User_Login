package LabFinalProject;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Order extends JFrame implements ActionListener{

	Container c;
	JScrollPane j1,j2;
	JTable table1,table2;
	JLabel customer,order;
	JTextField tcustomer,torder;
	JButton insert,show,remove,clear;
	DataBase data;
	DefaultTableModel model1,model2;
	String head2[];
	Order(DataBase data){
		this.data=data;
		c=getContentPane();
		String head1[]= {"Id","Name","Price","Quantity","Description","Catagury"};
		head2= new String[]{"ID","Name","Price","Quantity","Quantity X Price"};
		model1=new DefaultTableModel(new String[][] {},head1);
		model2=new DefaultTableModel(new String[][] {},head2);
		table1 =new JTable(model1);
		table2 =new JTable(model2);
		j1=new JScrollPane(table1);
		j2=new JScrollPane(table2);
		data.settable(data.getproduct(), model1);
		
		customer=new JLabel("Customer ID:");order=new JLabel("Order ID:");
		tcustomer=new JTextField();torder=new JTextField();
		insert=new JButton("Insert Order");show=new JButton("Show Orders");remove=new JButton("Remove Product");clear=new JButton("Clear");
		insert.addActionListener(this);remove.addActionListener(this);clear.addActionListener(this);show.addActionListener(this);
		customer.setForeground(Color.white);order.setForeground(Color.white);
		
		c.setLayout(null);c.setBackground(Color.DARK_GRAY);
		customer.setBounds(600,20,80,25);order.setBounds(600,60,80,25);tcustomer.setBounds(700,20,130,25);torder.setBounds(700,60,130,25);
		j1.setBounds(20,300,300,280);j2.setBounds(370,300,500,250);
		insert.setBounds(370,270,120,25);show.setBounds(500,270,120,25);remove.setBounds(630,270,140,25);clear.setBounds(780,270,80,25);
		
		c.add(customer);c.add(order);c.add(tcustomer);c.add(torder);c.add(insert);
		c.add(remove);c.add(clear);c.add(show);c.add(j1);c.add(j2);
		this.setVisible(true);
		this.setSize(900,650);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insert) {
			if(table1.getSelectedRowCount()!=1) {
				JOptionPane.showMessageDialog(null, "Pls Select a Single Row");
			}
			else {
				int x=-1;
				try {
				x=Integer.parseInt(JOptionPane.showInputDialog("Pls Input the quantity"));}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Pls Input a Number");
				}
				if(x==0) {
					JOptionPane.showMessageDialog(null, "Quantity cant be 0");
				}
				else if(x<0) {
					JOptionPane.showMessageDialog(null, "Quantity can't be less than 0");
				}
				else if(x>0) {
					if(x>(int)Integer.parseInt(data.getproduct().get(table1.getSelectedRow())[3])) {
						JOptionPane.showMessageDialog(null, "Unavailable Quantity");
					}
					else {
						if(tcustomer.getText().equals("")||torder.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Pls input IDs");
						}
						else {
						Date date=new Date();
						SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
						String date1= format.format(date);
						int index=table1.getSelectedRow();
						String s=(int)Integer.parseInt(data.getproduct().get(index)[2])*x+"";
						String[] s1= {data.getproduct().get(index)[0],data.getproduct().get(index)[1],data.getproduct().get(index)[2],x+"",s};
						String[] s2= {tcustomer.getText(),date1 ,torder.getText()};
						data.add(s1,data.getorder());
						data.add(s2,data.getordered());
						model2.addRow(s1);
						JOptionPane.showMessageDialog(null, "Data added");
					}}
				}
			}
		}
		else if(e.getSource()==remove) {
			if(table2.getSelectedRowCount()==1) {
			data.remove(table2.getSelectedRow(), data.getorder());
			model2.removeRow(table2.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Data removed");}
			else {
				JOptionPane.showMessageDialog(null, "Pls Select a single row");
			}
		}
		else if(e.getSource()==clear) {
			if(model2.getRowCount()>1)
				for(int i=0;i<=model2.getRowCount()+1;i++) {
					model2.removeRow(0);
				}
				else if(model2.getRowCount()==1){
					model2.removeRow(0);
				}
			tcustomer.setText("");torder.setText("");
			JOptionPane.showMessageDialog(null, "Data cleared");}
		else {
			new ShowAll(data);
		}
		
	}

}
