package lotto.controller;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.service.LottoService;
import lotto.util.InputFormatter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputFormatter inputFormatter;
    private int moneyInput;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
        this.inputFormatter = new InputFormatter();
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
            String moneyInputRaw = inputView.getMoneyInput();
            this.moneyInput = inputFormatter.formatMoneyInput(moneyInputRaw);

            lottoService.purchaseLotto(this.moneyInput);
            printPurchasedLotto();
        });
    }

    private void processWinnerNumbersInput() {
        continueUntilNormalInput(() -> {
            String winnerNumbersInputRaw = inputView.getWinnerNumbersInput();
            List<Integer> winnerNumbersInput = inputFormatter.formatWinningNumbersInput(winnerNumbersInputRaw);

            lottoService.setWinnerLotto(winnerNumbersInput);
        });
    }

    private void processBonusNumberInput() {
        continueUntilNormalInput(() -> {
            String bonusNumberInputRaw = inputView.getBonusNumberInput();
            int bonusNumber = inputFormatter.formatBonusNumberInput(bonusNumberInputRaw);

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
