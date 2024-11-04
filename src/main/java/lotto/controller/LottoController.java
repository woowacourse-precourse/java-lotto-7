package lotto.controller;

import java.util.NoSuchElementException;
import java.util.function.Function;
import lotto.dto.LottosDto;
import lotto.model.LottoMachine;
import lotto.model.PurchaseAmount;
import lotto.utils.RandomLottoNumberGenerationStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = getInput(OutputView::printPurchaseAmountInputMessage, PurchaseAmount::from);
        if (purchaseAmount == null) {
            return;
        }
        LottoMachine lottoMachine = LottoMachine.initializeWith(purchaseAmount.getAmount(),
                new RandomLottoNumberGenerationStrategy());
        OutputView.printPurchasedLottos(LottosDto.from(lottoMachine.getLottos()));
    }

    private <T> T getInput(Runnable outputMessage, Function<String, T> parser) {
        while (true) {
            try {
                outputMessage.run();
                String input = InputView.readInput();
                return parser.apply(input);
            } catch (NoSuchElementException e) {
                OutputView.printErrorMessage(e.getMessage());
                return null;
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
