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
        Purchase purchase = null;
        while (purchase == null) {
            try {
                purchase = new Purchase(inputView.purchaseInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoGenerator lottos = new LottoGenerator(purchase.numberOfLotto());
        outputView.printLottoStatus(lottos.getLottos());

        WinningNumber winningNumber = null;
        while (winningNumber == null) {
            try {
                String winningNum = inputView.winningNumberInput();
                String bonusNumber = inputView.bonusInput();
                winningNumber = new WinningNumber(winningNum, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        WinningStatics winningStatics = new WinningStatics();
        winningStatics.numOfWinnings(lottos.getLottos(), winningNumber);
        outputView.printWinningStatics(winningStatics);

        int purchaseAmount = purchase.getAmount();
        Earning earning = new Earning(purchaseAmount, winningStatics.getWinningStatics());
        outputView.printEarning(earning);
    }
}
