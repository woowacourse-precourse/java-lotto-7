package lotto.controller;

import static lotto.constant.PromptMessage.BONUS_NUMBER_PROMPT;
import static lotto.constant.PromptMessage.MONEY_PROMPT;
import static lotto.constant.PromptMessage.WINNING_NUMBERS_PROMPT;

import lotto.model.Lotto;
import lotto.model.LottoMatcher;
import lotto.model.LottoPurchaseMoney;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        LottoPurchaseMoney invested = getPurchaseMoney();
        Lottos issued = new Lottos(invested.toLottoCount());
        OutputView.printLottos(issued);

        WinningLotto winningLotto = getWinningLotto();
        LottoMatcher lottoMatcher = new LottoMatcher(issued, winningLotto);
        OutputView.printPrizeStats(lottoMatcher, invested);
    }

    private LottoPurchaseMoney getPurchaseMoney() {
        while (true) {
            try {
                OutputView.println(MONEY_PROMPT.getMessage());
                return new LottoPurchaseMoney(InputView.getInteger());
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
