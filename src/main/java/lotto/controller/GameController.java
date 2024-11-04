package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PrizeType;

import java.util.List;

public class GameController {
    private IOController ioController;
    private LottoFactory lottoFactory;

    public GameController(IOController ioController, LottoFactory lottoFactory) {
        this.ioController = ioController;
        this.lottoFactory = lottoFactory;
    }

    public void run() {
        purchaseLotto();
        inputExpectedLotto();
        winningLotto();
    }

    private void purchaseLotto() {
        int cash = ioController.inputCash();
        int lottoCount = lottoFactory.convertCashToLottTicket(cash);
        List<Lotto> winningLotto = lottoFactory.createLottoByFactory(lottoCount);
        ioController.printPurchaseLotto(winningLotto, lottoCount);
    }

    private void inputExpectedLotto() {
        List<Integer> userLotto = ioController.inputExpectedLotto();
        int bonusBall = ioController.inputBonusBall();
        lottoFactory.createLottoByUser(userLotto, bonusBall);
    }

    private void winningLotto() {
        List<PrizeType> prizes = lottoFactory.checkWinningLotto();
        double rateOfReturn = lottoFactory.calculateRateOfReturn(prizes);
        ioController.printWinningResult(prizes, rateOfReturn);
    }
}
