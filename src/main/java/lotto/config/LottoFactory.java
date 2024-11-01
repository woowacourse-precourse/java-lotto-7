package lotto.config;

import lotto.controller.WinningController;
import lotto.controller.PublishingController;
import lotto.controller.PurchasingController;
import lotto.view.InputPaymentView;

public class LottoFactory {
    //유효성, 인풋, 아웃풋 뷰 생성해서 컨트롤러에 주입한다.
    //컨트롤러 3개를 여기서 생성해서 돌리기
    private final InputPaymentView inputPaymentView;

    public LottoFactory() {
        this.inputPaymentView = new InputPaymentView();
    }

    public void create() {
        PurchasingController purchasingLottoController = new PurchasingController(inputPaymentView);
        PublishingController publishingLottoController = new PublishingController();
        WinningController winningController = new WinningController();
    }
}
