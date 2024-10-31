package lotto.controller;

import lotto.ErrorMessage;
import lotto.view.InputView;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
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
    }

    private void validateIsRightNumber(int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_DIVIDE_PRICE.getMsg());
        }
    }
}
