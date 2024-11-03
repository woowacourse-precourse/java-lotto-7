package lotto.common;

import java.util.List;
import lotto.publishingLotto.model.Lotto;
import lotto.view.Publishing_OutputTicketsView;
import lotto.view.Purchasing_OutputView;
import lotto.winningLotto.WinningController;
import lotto.publishingLotto.PublishingController;
import lotto.purchasingLotto.PurchasingController;
import lotto.purchasingLotto.PaymentValidator;
import lotto.view.Purchasing_InputView;

public class LottoFactory {
    //유효성, 인풋, 아웃풋 뷰 생성해서 컨트롤러에 주입한다.
    //컨트롤러 3개를 여기서 생성해서 돌리기
    private final Purchasing_InputView purchasingInputView;
    private final PaymentValidator paymentValidator;
    private final Purchasing_OutputView purchasingOutputView;
    private final Publishing_OutputTicketsView publishingOutputTicketsView;

    public LottoFactory() {
        this.purchasingInputView = new Purchasing_InputView();
        this.paymentValidator = new PaymentValidator();
        this.purchasingOutputView = new Purchasing_OutputView();
        this.publishingOutputTicketsView = new Publishing_OutputTicketsView();
    }

    public void create() {
        PurchasingController purchasingController = new PurchasingController(purchasingInputView, paymentValidator,
                purchasingOutputView);
        int numberOfTickets = purchasingController.purchaseLottoTickets();
        PublishingController publishingController = new PublishingController(publishingOutputTicketsView, numberOfTickets);
        List<Lotto> LottoTickets = publishingController.publishLottoTickets();
        WinningController winningController = new WinningController(LottoTickets);
    }
}
