package lotto.controller;

import lotto.exception.LottoErrorMessages;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.view.LottoInfoMessages;
import lotto.view.StatisticsView;

public class LottoController {
    LottoInfoMessages lottoInfoMessages;
    StatisticsView statisticsView = StatisticsView.createStatisticsView();
    LottoService lottoService = LottoService.createLottoService();
    ValidationService validationService = ValidationService.createValidationService();

    private int pay;
    private int amount;
    private int change;

    public void runLottoProgram() {
        // 구입 금액 입력
        pay = validationService.validatePayInput();
        amount = lottoService.calculateAmount(pay);
        change = lottoService.calculateChange(pay);
        lottoService.printNoticeBuyAmount(amount, change);
        // 수동 구매 갯수 입력
//        lottoView.printInsertManualAmount(amount);
    }

    private void purchaseLotto() {

    }


}
