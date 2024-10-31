package lotto.controller;

import lotto.ErrorMessage;
import lotto.LottoManager;
import lotto.model.Lottos;
import lotto.NumberGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerate lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = new LottoManager(lottoGenerator);
    }

    public void run() {
        int money = lottoMoneyInput();

        Lottos lottos = lottoManager.buyLotto(money);
        outputView.showHowManyLotto(lottos);
        outputView.showAllLottoNums(lottos);
    }

    private int lottoMoneyInput() {
        int money;
        while (true) {
            try {
                money = inputView.lottoMoneyInput();
                validateIsRightNumber(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return money;
    }

    private void validateIsRightNumber(int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_DIVIDE_PRICE.getMsg());
        }
    }
}
