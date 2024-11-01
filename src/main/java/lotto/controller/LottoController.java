package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.service.LottoGenerator;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        // 구매할 금액 입력 받기
        PurchasePrice purchasePrice = inputView.receivePurchasePrice();
//        System.out.println("This is the purchase price. " + purchasePrice.getPurchasePrice());

    }
}
