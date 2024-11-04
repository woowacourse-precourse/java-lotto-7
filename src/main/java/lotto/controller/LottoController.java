package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public static void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();

        LottoGame lottoGame = new LottoGame(inputView.inputMoney());
        lottoGame.createLotto(randomNumberStrategy);

        outputView.printOfBuyLotto(lottoGame);
        Lotto winningLotto = inputView.inputWinningNumber();
        final List<Rank> ranks = lottoGame.match(winningLotto, inputView.inputBonusNumber(winningLotto));

        outputView.printWinningResult(LottoResult.matchResult(ranks));
        outputView.printProfit(lottoGame.calculateProfit(ranks));
    }
}
