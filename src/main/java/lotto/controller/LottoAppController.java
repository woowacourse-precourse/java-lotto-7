package lotto.controller;

import lotto.model.payment.Payment;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoChecker;
import lotto.model.lotto.LottoPublisher;
import lotto.model.draw_numbers.DrawNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoAppController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoChecker lottoChecker;
    private final LottoPublisher lottoPublisher;

    public LottoAppController(InputView inputView, OutputView outputView, LottoChecker lottoChecker, LottoPublisher lottoPublisher) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoChecker = lottoChecker;
        this.lottoPublisher = lottoPublisher;
    }

    public DrawNumbers draw() {
        return inputView.getDrawNumbers();
    }

    public List<Lotto> buyLottos() {
        Payment payment = inputView.getPayment();
        long lottoCount = outputView.printLottoCount(payment);

        return publishLotto(lottoCount);
    }

    public void printResult(List<Lotto> lottos, DrawNumbers drawNumbers) {
        double revenueRate = lottoChecker.calcRevenueRate(lottos, drawNumbers);
        System.out.println(outputView.resultToString(revenueRate));
    }

    private List<Lotto> publishLotto(long lottoCount) {
        List<Lotto> lottos = lottoPublisher.publishLotto(lottoCount);
        outputView.printLottos(lottos);
        return lottos;
    }
}
