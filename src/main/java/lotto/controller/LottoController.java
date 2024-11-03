package lotto.controller;

import lotto.customer.Customer;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private LottoMachine lottoMachine;
    private Customer customer;
    private InputView inputView;

    private void initializeCustomer() {
        customer = new Customer(inputView.readPayAmount());
        List<Lotto> all_lottos = lottoMachine.publishLotteries(customer.getPayAmount());
    }
    public void run() {

    }
}
