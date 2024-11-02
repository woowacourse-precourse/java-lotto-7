package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.AnswerNumbers;
import lotto.domain.BonusNumber;
import lotto.domain.Payment;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.Lottos;
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
        result(lottos, answerNumbers);
    }

    private Lottos purchase(Payment payment) {
        Lottos lottos = Lottos.from(
                LottoMachine.generate(
                        payment.calculateCount())
        );
        outputView.printLottos(lottos);
        return lottos;
    }

    private AnswerNumbers create() {
        WinningNumbers winningNumbers = retry(inputView::readWinningNumbers);
        BonusNumber bonusNumber = retry(() -> inputView.readBonusNumber(winningNumbers));
        return AnswerNumbers.from(winningNumbers, bonusNumber);
    }

    private void result(Lottos lottos, AnswerNumbers answerNumbers) {
        Result result = Result.of(lottos, answerNumbers);
        outputView.printResult(result);
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
