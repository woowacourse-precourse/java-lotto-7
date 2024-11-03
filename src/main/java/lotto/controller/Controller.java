package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.model.LottoManager;
import lotto.view.PrintView;

public class Controller {
    private static final InputValidation inputValidation = new InputValidation();
    private static final PrintView printView = new PrintView();
    private static LottoManager lottoManager;

    public Controller() {
        this.issueLotties();
        this.checkWinPrizes();
        printView.printStatistic(lottoManager.calculateEarnRate().toString(), lottoManager.getWinLottiesCount());
    }

    private void issueLotties() {
        lottoManager = new LottoManager(inputValidation.getValidatedMoney());
        List<List<Integer>> lottisNumber = lottoManager.getLotties().stream().map(Lotto::getNumbers).collect(Collectors.toList());
        printView.printLotties(lottisNumber);
    }

    private void checkWinPrizes() {
        lottoManager.setWinningNumbers(inputValidation.getValidatedWinningNumbers());
        lottoManager.setBonusNumber(inputValidation.getValidatedBonusNumber(lottoManager.getWinningNumbers()));
        lottoManager.checkLottiesWin();
    }

}
