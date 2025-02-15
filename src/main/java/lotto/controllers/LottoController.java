package lotto.controllers;
import lotto.utils.Prize;
import lotto.services.LottoService;
import lotto.views.*;

import java.util.Map;

import static lotto.utils.ErrorMessages.OBJECT_NOT_INIT;
import static lotto.utils.MessageFormatter.formatErrorMessage;


public class LottoController {

    LottoView lottoView = new LottoView();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lotto = new LottoService();

    public void run() {
    try {
        startLotto();
        enterWinningNumber();
        enterBonusNumber();

        lotto.generateStatistics();

        outputView.displayStatisticsHeaders();
        printStatistics();

        outputView.displayTotalYield(lotto.calculateYield());
    } catch (IllegalStateException e) {
        outputView.displayError(formatErrorMessage(OBJECT_NOT_INIT));
    }


    }

    private void startLotto() {
        try {
            inputView.requestPurchaseAmount();
            lotto.issue(lottoView.getUserInput());
            outputView.displayLottoCount(lotto.getIssueCount());
            outputView.displayIssuedLotto(lotto.getAllIssuedLotto());
        } catch (IllegalArgumentException e) {
            outputView.displayError(e.getMessage());
            startLotto();
        }
    }

    private void enterWinningNumber() {
        try {
            inputView.requestWinningNumbers();
            lotto.setWinningNumbers(lottoView.getUserInput());
        } catch (IllegalArgumentException e) {
            outputView.displayError(e.getMessage());
            enterWinningNumber();
        }
    }

    private void enterBonusNumber() {
        try {
            inputView.requestBonusNumber();
            lotto.setBonusNumber(lottoView.getUserInput());
        } catch (IllegalArgumentException e) {
            outputView.displayError(e.getMessage());
            enterBonusNumber();
        }
    }

    private void printStatistics() {
        Map<Prize, Integer> statistics = lotto.getStatistics();
        for (Prize prize : Prize.values()) {
            outputView.displayLottoMatch(prize == Prize.FIVE_AND_BONUS, prize.getMatchCount(), prize.getMatchAmount(), statistics.get(prize));

        }
    }
}
