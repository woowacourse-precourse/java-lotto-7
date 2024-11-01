package lotto.controller;

import static lotto.constant.PromptMessage.BONUS_NUMBER_PROMPT;
import static lotto.constant.PromptMessage.MONEY_PROMPT;
import static lotto.constant.PromptMessage.WINNING_NUMBERS_PROMPT;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Money invested = getMoney();
        Lottos issued = new Lottos(invested.toLottoCount());
        OutputView.printLottos(issued);

        WinningLotto winningLotto = getWinningLotto();
    }

    private Money getMoney() {
        while (true) {
            try {
                OutputView.println(MONEY_PROMPT.getMessage());
                return new Money(InputView.getInteger());
            } catch (IllegalArgumentException e) {
                OutputView.println(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = getLotto();

        while (true) {
            try {
                OutputView.println(BONUS_NUMBER_PROMPT.getMessage());
                return new WinningLotto(lotto, InputView.getLottoNumber());
            } catch (IllegalArgumentException e) {
                OutputView.println(e.getMessage());
            }
        }
    }

    private Lotto getLotto() {
        while (true) {
            try {
                OutputView.println(WINNING_NUMBERS_PROMPT.getMessage());
                return new Lotto(InputView.getLottoNumberList());
            } catch (IllegalArgumentException e) {
                OutputView.println(e.getMessage());
            }
        }
    }
}
