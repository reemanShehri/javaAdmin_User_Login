package LabFinalProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class Product extends JFrame implements ActionListener{

	Container c;
	JPanel center,top,left;
	JButton add,remove,search;
	JTable table;
	JTextField text;
	JScrollPane j;
	DataBase data;
	DefaultTableModel model;
	Product(DataBase data){
		this.data=data;
		c= getContentPane();
		center=new JPanel();top=new JPanel();left=new JPanel();
		add=new JButton("Add New Product");remove=new JButton("Remove Selected Product");search=new JButton("Search");
		text=new JTextField(60);
		String head[]= new String[]{"Id","Name","Price","Quantity","Description","Catagury"};
		model =new DefaultTableModel(new String[][]{},head);
		table =new JTable(model);
		j=new JScrollPane(table);
		data.settable(data.getproduct(), model);
		
		c.setLayout(new BorderLayout());
		c.add(center);c.add(left,BorderLayout.WEST);c.add(top,BorderLayout.NORTH);
		
		top.setBackground(Color.DARK_GRAY);
		left.setBackground(Color.DARK_GRAY);
		center.add(j);
		left.add(add);left.add(remove);
		top.add(text);top.add(search);
		
		j.setPreferredSize(new Dimension(1000,750));
		search.setPreferredSize(new Dimension(150,25));
		add.setPreferredSize(new Dimension(250,25));
		add.setBackground(Color.green);
		add.setForeground(Color.white);
		remove.setPreferredSize(new Dimension(250,25));
		remove.setBackground(Color.red);
		remove.setForeground(Color.white);
		left.setPreferredSize(new Dimension(300,800));
		top.setPreferredSize(new Dimension(1000,50));
		
		add.addActionListener(this);remove.addActionListener(this);search.addActionListener(this);
		
		this.setSize(1300,800);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			new AddProduct(data,model);
		}
		else if(e.getSource()==remove) {
			if(table.getSelectedRowCount()==1) {
			data.remove(table.getSelectedRow(), data.getproduct());
			model.removeRow(table.getSelectedRow());
		}
			else {
				JOptionPane.showMessageDialog(null, "Pls select a single row");}
			}
		else if(e.getSource()==search) {
			if(model.getRowCount()>1)
			for(int i=0;i<=model.getRowCount()+1;i++) {
				model.removeRow(0);
			}
			else if(model.getRowCount()==1){
				model.removeRow(0);
			}
		    data.search(data.getproduct(), model, text.getText());
		}
		
	}
	

}
