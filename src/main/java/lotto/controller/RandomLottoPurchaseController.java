package lotto.controller;

import lotto.service.LottoIssueService;
import lotto.service.PaymentService;
import lotto.view.LottoPaymentView;
import lotto.view.View;

public class RandomLottoPurchaseController implements Controller {

    private final PaymentService paymentService = new PaymentService();
    private final LottoIssueService lottoIssueService;

    public RandomLottoPurchaseController(LottoIssueService lottoIssueService) {
        this.lottoIssueService = lottoIssueService;
    }

    @Override
    public View execute() {
        int lottoCnt = paymentService.buyLotto();
        return new LottoPaymentView(
                lottoIssueService.issue(null, lottoCnt));
    }
}
