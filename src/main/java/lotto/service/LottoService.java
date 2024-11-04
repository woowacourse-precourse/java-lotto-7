package lotto.service;

import lotto.domain.Customer;
import lotto.domain.Price;
import lotto.exceptionHandler.ExceptionHandler;
import lotto.view.InputView;

public class LottoService {

    private Price price;
    private Customer customer;

    public void inputPrice() {
        ExceptionHandler.handle(() -> {
            int value = InputView.inputPrice();
            price = Price.from(value);
        });
    }

    public void initCustomer() {
        customer = Customer.from(price.getValue());
    }
}