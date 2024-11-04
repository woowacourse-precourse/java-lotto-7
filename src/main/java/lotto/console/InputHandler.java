package lotto.console;

import java.util.function.Supplier;
import lotto.store.winning.BonusNumber;
import lotto.store.user.Cash;
import lotto.store.user.Lotto;

public class InputHandler {

    private final InputView inputView = new InputView();

    public Cash inputCash() {
        return handleError(inputView::inputPurchasePrice);
    }

    public Lotto inputWinningNumbers() {
        return handleError(inputView::inputNumbers);
    }

    public BonusNumber inputBonusNumber(Lotto lotto) {
        return handleError(() -> inputView.inputNumber(lotto));
    }

    private <T> T handleError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
