package lotto.io;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.common.util.StringSplitter;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(final InputView inputView) {
        this.inputView = inputView;
    }

    public PurchaseAmount readPurchaseAmount() {
        return receiveValidatedInput(
                inputView::requestPurchaseAmount,
                InputValidator::validateIsNumeric,
                input -> new PurchaseAmount(Integer.parseInt(input))
        );
    }

    public WinningLotto readWinningLotto() {
        Lotto lotto = readLotto();
        OutputView.printBlankLine();
        return createWinningLotto(lotto);
    }

    public void closeConsole() {
        inputView.closeConsole();
    }

    private Lotto readLotto() {
        return receiveValidatedInput(
                inputView::requestWinningNumbers,
                InputValidator::validateIsEmpty,
                input -> {
                    List<Integer> numbers = StringSplitter.splitByComma(input).stream()
                            .map(Integer::parseInt)
                            .toList();
                    return new Lotto(numbers);
                }
        );
    }

    private BonusNumber readBonusNumber() {
        return receiveValidatedInput(
                inputView::requestBonusNumber,
                InputValidator::validateIsNumeric,
                input -> new BonusNumber(Integer.parseInt(input))
        );
    }

    private WinningLotto createWinningLotto(final Lotto lotto) {
        while (true) {
            try {
                BonusNumber bonusNumber = readBonusNumber();
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException ex) {
                OutputView.printExceptionMessage(ex.getMessage());
            }
        }
    }

    private <T> T receiveValidatedInput(
            Supplier<String> supplier,
            Consumer<String> validator,
            Function<String, T> converter
    ) {
        while (true) {
            try {
                String input = supplier.get();
                validator.accept(input);
                return converter.apply(input);
            } catch (IllegalArgumentException ex) {
                OutputView.printExceptionMessage(ex.getMessage());
            }
        }
    }
}
