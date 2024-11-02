package lotto.service;

import lotto.domains.customer.Customer;

public class CustomerFactory {
	public Customer generateCustomer(int price) {
		return new Customer(price);
	}
}
