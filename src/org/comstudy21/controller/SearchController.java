package org.comstudy21.controller;

import java.util.Vector;

import org.comstudy21.model.Customer;

public class SearchController implements Controller {

	
	public SearchController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		
		Customer customer = new Customer(0, name, email, phone);
		
		Vector<Vector> dataVector = dao.select(customer);
		
		dm.setDataVector(dataVector, columnNames);
		
	}
	
	
	

}
