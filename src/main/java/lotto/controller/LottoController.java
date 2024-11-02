package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoController {

    private Customer customer;
    private final LottoHandler lottoHandler;
    private Lotto lotto;

    public LottoController(LottoHandler lottoHandler) {
        this.lottoHandler = lottoHandler;
    }

    public void start() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        int rawInputMoney = Integer.parseInt(Console.readLine());
        customer = new Customer();
        customer.buyLottoTickets(rawInputMoney);
        lottoHandler.buyLottos(customer.getLottoTickets());
        System.out.println(lottoHandler.getLottoList());



    }
}
