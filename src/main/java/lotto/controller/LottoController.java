package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        // 구매금액 입력 받기
        OutputView.printPurchaseAmountMessage();
        String purchaseAmount = InputView.getPurchaseAmount();

        // 로또번호 입력 받기
        OutputView.printLottoNumbersMessage();
        String lottoNumbers = InputView.getLottoNumbers();
    }

}
