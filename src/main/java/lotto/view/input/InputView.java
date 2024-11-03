package lotto.view.input;

import java.util.List;
import lotto.controller.error.ErrorType;

public abstract class InputView {

    public String readPurchaseAmount() {
        final String input = inputPurchaseAmount();
        validateNotBlank(input);
        return input;
    }

    protected abstract String inputPurchaseAmount();

    public List<String> readWinningNumber() {
        final List<String> input = inputWinningNumber();
        input.forEach(this::validateNotBlank);
        return input;
    }

    protected abstract List<String> inputWinningNumber();

    public String readBonusNumber() {
        final String input = inputBonusNumber();
        validateNotBlank(input);
        return input;
    }

    protected abstract String inputBonusNumber();

    private void validateNotBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.NULL_OR_BLANK_INPUT.getMessage());
        }
    }
}
