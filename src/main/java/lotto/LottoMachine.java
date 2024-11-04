package lotto;

import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.util.NumberGenerator;
import lotto.validator.PurchaseAmountValidator;

public class LottoMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberGenerator numberGenerator;

    public LottoMachine(InputHandler inputHandler, OutputHandler outputHandler, NumberGenerator numberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numberGenerator = numberGenerator;
    }

    private int calculatePurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / PurchaseAmountValidator.UNIT;
    }
}
