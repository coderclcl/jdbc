package org.comstudy21.controller;

import org.comstudy21.model.Customer;

public class InputController implements Controller {

	@Override
	public void service() {
		
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		Customer dto = new Customer(0,name, email, phone);
		dao.insert(dto);

	}

}
