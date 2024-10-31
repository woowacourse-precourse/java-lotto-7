package lotto.controller;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private int moneyInput;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        processInput();
        lottoService.checkLottoResult();
        printResult();
    }

    private void processInput() {
        processMoneyInput();
        processWinnerNumbersInput();
        processBonusNumberInput();
    }

    private void processMoneyInput() {
        continueUntilNormalInput(() -> {
            outputView.printMoneyInputMessage();
            this.moneyInput = inputView.getMoneyInput();

            lottoService.purchaseLotto(moneyInput);
            printPurchasedLotto();
        });
    }

    private void processWinnerNumbersInput() {
        continueUntilNormalInput(() -> {
            outputView.printWinnerNumbersInputMessage();
            List<Integer> winnerNumbersInput = inputView.getWinnerNumbersInput();

            lottoService.setWinnerLotto(winnerNumbersInput);
        });
    }

    private void processBonusNumberInput() {
        continueUntilNormalInput(() -> {
            outputView.printBonusNumberInputMessage();
            int bonusNumber = inputView.getBonusNumberInput();

            lottoService.setBonusNumber(bonusNumber);
        });
    }

    private void continueUntilNormalInput(Runnable processSpecificInput) {
        while (true) {
            try {
                processSpecificInput.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private void printPurchasedLotto() {
        List<String> purchasedLotto = lottoService.purchasedLottoNumbersMessage();
        outputView.printPurchasedLottoCount(purchasedLotto.size());

        for (String lotto : purchasedLotto) {
            outputView.printMessage(lotto);
        }
    }

    private void printResult() {
        outputView.printLottoResultHeader();

        for (Object lotto : LottoRank.values()) {
            outputView.printMessage(lotto.toString());
        }

        outputView.printRateOfReturn(LottoRank.getTotalPrize() * 100.0 / moneyInput);
    }
}
