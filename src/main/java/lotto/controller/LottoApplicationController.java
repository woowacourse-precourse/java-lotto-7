package lotto.controller;

import java.util.List;
import lotto.domain.LottoDraw;
import lotto.domain.LottoPaper;
import lotto.domain.LottoResult;
import lotto.domain.Payment;
import lotto.domain.MatchResult;

public class LottoApplicationController {

    private final PaymentController paymentController;
    private final LottoController lottoController;
    private final ResultController resultController;

    public LottoApplicationController() {
        this.paymentController = new PaymentController();
        this.lottoController = new LottoController();
        this.resultController = new ResultController();
    }

    public void run() {
        Payment payment = processPayment();

        LottoPaper lottoPaper = purchaseLottoPaper(payment);

        LottoDraw lottoDraw = generateLottoDraw();

        List<MatchResult> matchResults = generateMatchResults(lottoPaper, lottoDraw);

        LottoResult lottoResult = generateLottoResult(matchResults);

        printLottoResult(lottoResult);

        printTotalRate(payment, lottoResult);
    }

    private Payment processPayment() {
        return paymentController.processPayment();
    }

    private LottoPaper purchaseLottoPaper(Payment payment) {
        return lottoController.purchaseLottoPaper(payment);
    }

    private LottoDraw generateLottoDraw() {
        return lottoController.generateLottoDraw();
    }

    private List<MatchResult> generateMatchResults(LottoPaper lottoPaper, LottoDraw lottoDraw) {
        return resultController.generateMatchResults(lottoPaper.getLottos(), lottoDraw);
    }

    private LottoResult generateLottoResult(List<MatchResult> matchResults) {
        return resultController.generateLottoResult(matchResults);
    }

    private void printLottoResult(LottoResult lottoResult) {
        resultController.printLottoResult(lottoResult);
    }

    private void printTotalRate(Payment payment, LottoResult lottoResult) {
        resultController.printTotalRate(payment, lottoResult);
    }
}
