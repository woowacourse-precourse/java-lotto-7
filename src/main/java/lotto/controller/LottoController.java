package lotto.controller;

import lotto.domain.earning.Earning;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.purchase.Purchase;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningStatics;
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
        Purchase purchase = new Purchase(inputView.purchaseInput());

        LottoGenerator lottos = new LottoGenerator(purchase.numberOfLotto());

        outputView.printLottoStatus(lottos.getLottos());

        String winningNum = inputView.winningNumberInput();
        String bounsNumber = inputView.bonusInput();

        WinningNumber winningNumber = new WinningNumber(winningNum, bounsNumber);
        WinningStatics winningStatics = new WinningStatics();
        winningStatics.numOfWinnings(lottos.getLottos(), winningNumber);

        outputView.printWinningStatics(winningStatics);

        int purchaseAmount = purchase.getAmount();
        Earning earning = new Earning(purchaseAmount, winningStatics.getWinningStatics());
        outputView.printEarning(earning);
    }
}
