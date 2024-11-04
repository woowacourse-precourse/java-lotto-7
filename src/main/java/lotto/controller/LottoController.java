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
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoPurchaseMoney lottoPurchaseMoney = getLottoPurchaseMoney();
        Lottos lottos = new Lottos(lottoPurchaseMoney.toLottoCount());
        outputView.printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();
        LottoMatcher lottoMatcher = new LottoMatcher(lottos, winningLotto);
        outputView.printPrizeStats(lottoMatcher, lottoPurchaseMoney);
    }

    private LottoPurchaseMoney getLottoPurchaseMoney() {
        while (true) {
            try {
                outputView.println(MONEY_PROMPT.getMessage());
                return new LottoPurchaseMoney(inputView.getInteger());
            } catch (IllegalArgumentException e) {
                outputView.println(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = getLotto();

        while (true) {
            try {
                outputView.println(BONUS_NUMBER_PROMPT.getMessage());
                return new WinningLotto(lotto, inputView.getLottoNumber());
            } catch (IllegalArgumentException e) {
                outputView.println(e.getMessage());
            }
        }
    }

    private Lotto getLotto() {
        while (true) {
            try {
                outputView.println(WINNING_NUMBERS_PROMPT.getMessage());
                return new Lotto(inputView.getLottoNumberList());
            } catch (IllegalArgumentException e) {
                outputView.println(e.getMessage());
            }
        }
    }
}
