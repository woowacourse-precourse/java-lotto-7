package lotto;

import lotto.controller.BonusController;
import lotto.controller.LottoController;
import lotto.controller.PaymentController;
import lotto.controller.ResultController;
import lotto.controller.WinningController;
import lotto.service.Payment;
import lotto.service.generator.BonusGenerator;
import lotto.service.generator.WinningGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        PaymentController paymentController = new PaymentController(inputView, outputView);
        Payment payment = paymentController.pay();
        LottoController lottoController = new LottoController(outputView, payment);
        lottoController.showTicket();

        WinningController winningController = new WinningController(inputView, outputView);
        WinningGenerator winningGenerator = winningController.inputWinning();
        BonusController bonusController = new BonusController(inputView, outputView);
        BonusGenerator bonusGenerator = bonusController.inputBonus(winningGenerator.getWinning());

        ResultController resultController = new ResultController(outputView, lottoController.getTicket(), payment);
        resultController.showWinning(winningGenerator.getWinning(), bonusGenerator.getBonus());
    }
}
