package lotto.controller;

import lotto.domain.Payment;
import lotto.domain.lotto.Lottos;
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
        Payment payment = receive();
        outputView.printLottos(Lottos.from(payment.calculateCount()));
    }

    private Payment receive() {
        while (true) {
            try {
                return inputView.readPrice();
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
                return receive();
            }
        }
    }
}
