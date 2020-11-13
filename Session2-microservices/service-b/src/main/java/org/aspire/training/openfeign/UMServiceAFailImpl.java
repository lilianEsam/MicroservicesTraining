package org.aspire.training.openfeign;

import java.util.ArrayList;
import java.util.List;

import org.aspire.training.beans.Customer;
import org.springframework.stereotype.Component;

@Component
public class UMServiceAFailImpl implements UMUserInterface {

	@Override
	public Customer getUser(Integer userId) {
		return Customer.EMPTY;
	}

	@Override
	public List<Customer> getUsers() {
		return new ArrayList<>();
	}
}
