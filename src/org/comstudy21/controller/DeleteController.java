package org.comstudy21.controller;

import org.comstudy21.model.Customer;

public class DeleteController implements Controller {

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		
		int no = Integer.parseInt(noLabel.getText().substring(3).trim());
		System.out.println(no);
		Customer dto = new Customer(no, name, email, phone);
		dao.delete(dto);
		
	}

	
	
}
