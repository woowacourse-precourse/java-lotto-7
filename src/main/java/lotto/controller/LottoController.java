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
        Purchase purchase = createPurchase();

        LottoGenerator lottos = showPrintLottos(outputView, purchase);

        WinningNumber winningNumber = createWinningNumber();

        WinningStatics winningStatics = showWinningStatics(outputView, lottos, winningNumber);

        showEarning(outputView, purchase, winningStatics);
    }

    private Purchase createPurchase() {
        while (true) {
            try {
                return new Purchase(inputView.purchaseInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumber createWinningNumber() {
        while (true) {
            try {
                String winningNum = inputView.winningNumberInput();
                String bonusNumber = inputView.bonusInput();
                return new WinningNumber(winningNum, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoGenerator showPrintLottos(OutputView outputView, Purchase purchase) {
        LottoGenerator lottos = new LottoGenerator(purchase.numberOfLotto());
        outputView.printLottoStatus(lottos.getLottos());

        return lottos;
    }

    private WinningStatics showWinningStatics(OutputView outputView, LottoGenerator lottos, WinningNumber winningNumber) {
        WinningStatics winningStatics = new WinningStatics();
        winningStatics.numOfWinnings(lottos.getLottos(), winningNumber);
        outputView.printWinningStatics(winningStatics);

        return winningStatics;
    }

    private void showEarning(OutputView outputView, Purchase purchase, WinningStatics winningStatics) {
        Earning earning = new Earning(purchase.getAmount(), winningStatics.getWinningStatics());
        outputView.printEarning(earning);
    }
}
