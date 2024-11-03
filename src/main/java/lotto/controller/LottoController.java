package lotto.controller;

import lotto.customer.Customer;
import lotto.view.InputView;

public class LottoController {
    private Customer customer;
    private InputView inputView;

    private void initializeCustomer() {
        customer = new Customer(inputView.readPayAmount());
    }
    public void run() {

    }
}
