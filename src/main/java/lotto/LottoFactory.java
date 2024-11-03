package lotto;

import lotto.view.OutputPurchasingView;
import lotto.winningLotto.WinningController;
import lotto.publishingLotto.PublishingController;
import lotto.purchasingLotto.PurchasingController;
import lotto.purchasingLotto.PaymentValidator;
import lotto.view.InputPaymentView;

public class LottoFactory {
    //유효성, 인풋, 아웃풋 뷰 생성해서 컨트롤러에 주입한다.
    //컨트롤러 3개를 여기서 생성해서 돌리기
    private final InputPaymentView inputPaymentView;
    private final PaymentValidator paymentValidator;
    private final OutputPurchasingView outputPurchasingView;

    public LottoFactory() {
        this.inputPaymentView = new InputPaymentView();
        this.paymentValidator = new PaymentValidator();
        this.outputPurchasingView = new OutputPurchasingView();
    }

    public void create() {
        PurchasingController purchasingController = new PurchasingController(inputPaymentView, paymentValidator, outputPurchasingView);
        purchasingController.purchaseLottoTickets();
        PublishingController publishingController = new PublishingController();
        WinningController winningController = new WinningController();
    }
}
