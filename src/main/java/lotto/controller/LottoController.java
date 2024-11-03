package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.view.ErrorView;
import lotto.view.LottoView;
import lotto.view.StatisticsView;

public class LottoController {
    LottoView lottoView = LottoView.createLottoView();
    ErrorView errorView = ErrorView.createErrorview();
    StatisticsView statisticsView = StatisticsView.createStatisticsView();
    LottoService lottoService = LottoService.createLottoService();

    private int pay;
    private int amount;
    private int change;

    public void runLottoProgram() {
        // 구입 금액 입력
        lottoView.printInsertPay();
        pay = lottoView.validatePayInput(LottoException.PAY_INPUT_ERROR.getText());
        amount = lottoService.calculateAmount(pay);
        change = lottoService.calculateChange(pay);
        lottoView.printNoticeBuyAmount(amount, change);
        // 수동 구매 갯수 입력
        
    }

    private void purchaseLotto(){

    }


}
