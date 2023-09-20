package LabFinalProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class AddProduct extends JFrame implements ActionListener{

	Container c;
	JLabel catagury,name,quantity,price,discription;
	JTextField tname,tquantity,tprice,tdiscription;
	JComboBox <String>x;
	JButton cancel,add;
	DataBase data;
	DefaultTableModel model;
	AddProduct(DataBase data,DefaultTableModel model){
		this.data=data;
		this.model=model;
		c=getContentPane();
		catagury=new JLabel("Catagury:");name=new JLabel("Name:");quantity=new JLabel("Quantity:");
		price=new JLabel("Price:");discription=new JLabel("Discription:");
		tname=new JTextField();tquantity=new JTextField();
		tprice=new JTextField();tdiscription=new JTextField();
		x=new JComboBox<String>(data.getAllcatagury());
		cancel=new JButton("Cancel");add=new JButton("Add");
		
		cancel.setBackground(Color.red);
		cancel.setForeground(Color.white);
		add.setBackground(Color.green);
		add.setForeground(Color.white);
		add.addActionListener(this);cancel.addActionListener(this);
		
		c.setLayout(null);
		c.setBackground(Color.DARK_GRAY);
		catagury.setForeground(Color.white);name.setForeground(Color.white);quantity.setForeground(Color.white);
		discription.setForeground(Color.white);price.setForeground(Color.white);
		
	    catagury.setBounds(20,20,100,25);name.setBounds(20,60,100,25);quantity.setBounds(20,100,100,25);price.setBounds(20,140,100,25);
	    discription.setBounds(20,180,100,25);x.setBounds(130,20,130,25);tname.setBounds(130,60,130,25);tquantity.setBounds(130,100,130,25);
	    tprice.setBounds(130,140,130,25);tdiscription.setBounds(130,180,130,25);cancel.setBounds(20,400,100,25);add.setBounds(140,400,100,25);
		
		c.add(catagury);c.add(name);c.add(quantity);c.add(price);c.add(discription);c.add(tname);
		c.add(tquantity);c.add(tprice);c.add(tdiscription);c.add(x);c.add(cancel);c.add(add);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,500);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancel) {
			this.dispose();
		}
		else {
			if(tname.getText().equals("")||tquantity.getText().equals("")||tprice.getText().equals("")||tdiscription.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Pls Input all data");
			}
			else {
			    String[] s=new String[]{data.getProductIndex()+"",tname.getText(),tprice.getText(), tquantity.getText(),  tdiscription.getText(), (String)x.getSelectedItem()};
				data.add(s,data.getproduct());
				model.addRow(s);
				tname.setText("");tquantity.setText("");tprice.setText("");tdiscription.setText("");
		}}
	}

}
