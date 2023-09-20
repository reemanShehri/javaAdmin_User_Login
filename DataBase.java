package LabFinalProject;

import java.util.*;

import javax.swing.table.DefaultTableModel;

public class DataBase {
	private int productIndex=0,cataguryIndex=0;
	private ArrayList<String[]> admin;
	private ArrayList<String[]> user;
	private ArrayList<String[]> product;
	private ArrayList<String[]> catagury;
	private ArrayList<String[]> customer;
	private ArrayList<String[]> order;
	private ArrayList<String[]> ordered;
	DataBase(){
	    admin= new ArrayList<String[]>();
	    user= new ArrayList<String[]>();
	    product= new ArrayList<String[]>();
	    catagury= new ArrayList<String[]>();
	    customer= new ArrayList<String[]>();
	    order= new ArrayList<String[]>();
	    ordered= new ArrayList<String[]>();
	    admin.add(new String[]{"admin","123"});
	}
	public int login(String name,String pass) {
		for(int i=0;i<admin.size();i++) {
			if(name.equals(admin.get(i)[0])&&pass.equals(admin.get(i)[1])) {
				return 2;
			}
		}
		for(int i=0;i<user.size();i++) {
			if(name.equals(user.get(i)[1])&&pass.equals(user.get(i)[2])) {
				return 1;
			}
		}
		return 0;
	}
	public void add(String[] s,ArrayList<String[]> k) {
		k.add(s);
		if(k==product) {
			productIndex++;
		}
		else if(k==catagury) {
			cataguryIndex++;
		}
	}
	public void remove(int index,ArrayList<String[]> k) {
		k.remove(index);
	}
	public void settable(ArrayList<String[]> k,DefaultTableModel model) {
		for(int i=0;i<k.size();i++) {
			model.addRow(k.get(i));
		}
	}
	public void search(ArrayList<String[]> k,DefaultTableModel model,String name) {
		for(int i=0;i<k.size();i++) {
			if(k.get(i)[1].contains(name)) {
			model.addRow(k.get(i));}
		}
	}
	public ArrayList<String[]> getadmin() {
		return admin;
	}
	public ArrayList<String[]> getuser() {
		return user;
	}
	public ArrayList<String[]> getproduct() {
		return product;
	}
	public ArrayList<String[]> getcatagury() {
		return catagury;
	}
	public ArrayList<String[]> getcustomer() {
		return customer;
	}
	public ArrayList<String[]> getorder() {
		return order;
	}
	public ArrayList<String[]> getordered() {
		return ordered;
	}
	public int getProductIndex() {
		return productIndex;
	}
	public int getCataguryIndex() {
		return cataguryIndex;
	}
	public String[] getAllcatagury() {
		String s[]=new String[catagury.size()];
		for(int i=0;i<catagury.size();i++) {
			s[i]=catagury.get(i)[1];
		}
		return s;
	}
}
