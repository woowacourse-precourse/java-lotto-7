package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.WinningResult;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController(OutputView outputView, LottoGame lottoGame) {
        this.outputView = outputView;
        this.lottoGame = lottoGame;
    }

    public void LottoGameStart() {
        outputView.printPriceInputPrompt();
        int price = lottoGame.getAmount();
        System.out.println();
        List<Lotto> lottoes = lottoGame.purchase(price);
        outputView.printLottoes(lottoes);
        System.out.println();
        outputView.promptWinningNumbers();
        WinningResult winningResult = lottoGame.playLottoGame(lottoes, price);
        winningResult.printWinningResult(winningResult.getResultMap());
        System.out.println();

    }
}
