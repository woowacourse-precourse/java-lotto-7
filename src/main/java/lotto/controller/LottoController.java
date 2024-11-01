package lotto.controller;

import lotto.domain.Consumer;
import lotto.service.LottoService;

import static lotto.util.Utils.changeStringToInt;
import static lotto.view.InputView.inputPrice;
import static lotto.view.OutputView.*;

public class LottoController {

    private static final int NUMBER_LIMIT = 1000;
    private final LottoService lottoService = new LottoService();
    private Consumer consumer;

    public void start() {
        setting();
//        startLotto();
//        resultLotto();
    }

    public void setting() {
        consumer = payMoney();
        lottoService.buyLottoes(consumer, NUMBER_LIMIT);
        lottoResult();
    }

    private void lottoResult() {
        printLottoCount(consumer.getMoney() / NUMBER_LIMIT);
        printLottoes(consumer);
    }

    private Consumer payMoney() {
        try {
            return new Consumer(inputMoney());
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return payMoney();
        }
    }

    private int inputMoney() {
        try {
            String inputMoney = inputPrice();
            return changeStringToInt(inputMoney);
        } catch (IllegalArgumentException e) {
            ErrorMessage(e.getMessage());
            return inputMoney();
        }
    }


}
