package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoHandler;

public class LottoController {

    private Customer customer;
    private final LottoHandler lottoHandler;
    private Lotto lotto;

    public LottoController(LottoHandler lottoHandler) {
        this.lottoHandler = lottoHandler;
    }

    public void start() {
        purchaseLotto();
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void purchaseLotto() {
        int rawInputMoney = Integer.parseInt(Console.readLine());
        customer = new Customer();
        customer.buyLottoTickets(rawInputMoney);
        lottoHandler.buyLottos(customer.getLottoTickets());
        System.out.println(lottoHandler.getLottoList());
    }

    private void inputWinningNumbers() {
        String rawWinningNumbers = Console.readLine();
        lottoHandler.inputWinningLottoNumbers(rawWinningNumbers);
        System.out.println(lottoHandler.getWinningLottoNumbers().getNumbers());
    }

    private void inputBonusNumber() {
        int rawBonusNumbers = Integer.parseInt(Console.readLine());
        lottoHandler.setBonusNumber(rawBonusNumbers);
        System.out.println(lottoHandler.getBonusNumber());
    }



}
