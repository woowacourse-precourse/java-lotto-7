package lotto.controller;

import lotto.model.DrawnLotto;
import lotto.model.LottoCollection;
import lotto.model.LottoDispenser;
import lotto.model.LottoHolder;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulator {

    private LottoDispenser lottoDispenser = new LottoDispenser();
    private LottoHolder lottoHolder;
    private DrawnLotto drawnLotto;


    public LottoSimulator() {}

    public void startSimulation() {
        purchaseLottoTickets();
        showPurchasedLottos();
        inputDrawnLotto();
        verifyLottoWins();
        showLottoResults();
    }

    private void purchaseLottoTickets() {
        while (true) {
            try {
                String inputMoney = InputView.receiveLottoPayment();
                LottoCollection lottoCollection = lottoDispenser.executeTransactionAndDispense(inputMoney);
                lottoHolder = new LottoHolder(lottoCollection);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void showPurchasedLottos() {
        OutputView.printPurchasedLottos(lottoHolder.getLottos());
    }

    private void inputDrawnLotto() {
        while (true) {
            try {
                String drawnNumbersInput = InputView.receiveWinningNumbers();
                String bonusNumberInput = InputView.receiveBonusNumber();
                drawnLotto = new DrawnLotto(drawnNumbersInput, bonusNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void verifyLottoWins() {
        lottoHolder.calculateRankCounts(drawnLotto);
    }

    private void showLottoResults() {
        OutputView.printRankCounts(lottoHolder.getRankCounts());
        OutputView.printProfitRate(lottoHolder.calculateProfitRate());
    }
}
