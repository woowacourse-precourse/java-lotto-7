package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Payment;
import lotto.domain.lotto.Lottos;
import lotto.domain.rank.Result;
import lotto.domain.winning.AnswerNumbers;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningLotto;
import lotto.global.contents.LottoDetail;
import lotto.global.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Payment payment = retry(inputView::readPrice);
        Lottos lottos = purchase(payment);
        AnswerNumbers answerNumbers = create();
        result(lottos, answerNumbers, payment);
    }

    private Lottos purchase(Payment payment) {
        Lottos lottos = Lottos.from(
                LottoMachine.generate(
                        payment.calculateCount(LottoDetail.PRICE))
        );
        outputView.printLottos(lottos);
        return lottos;
    }

    private AnswerNumbers create() {
        WinningLotto winningLotto = retry(inputView::readWinningNumbers);
        BonusNumber bonusNumber = retry(() ->
                inputView.readBonusNumber(winningLotto)
        );
        return AnswerNumbers.from(winningLotto, bonusNumber);
    }

    private void result(Lottos lottos,
                        AnswerNumbers answerNumbers,
                        Payment payment) {
        Result result = Result.of(lottos, answerNumbers);
        outputView.printResult(result);
        outputView.printTotalProfitRate(
                result.calculateProfitRate(payment)
        );
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }
}
