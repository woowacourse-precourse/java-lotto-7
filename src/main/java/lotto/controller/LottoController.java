package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;

public class LottoController {

    private Customer customer;

    public void start() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        int rawInputMoney = Integer.parseInt(Console.readLine());
        customer = new Customer();
        customer.buyLottoTickets(rawInputMoney);
    }
}
