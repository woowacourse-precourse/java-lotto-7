package lotto;

import static lotto.validator.WinningLottoValidator.MAX_VALUE;
import static lotto.validator.WinningLottoValidator.MIN_VALUE;
import static lotto.validator.WinningLottoValidator.SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    private List<Lotto> issueLottoes(int quantity) {
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = numberGenerator.getNumber(MIN_VALUE, MAX_VALUE, SIZE);
            Collections.sort(numbers);
            lottoes.add(new Lotto(numbers));
        }

        return lottoes;
    }
}
