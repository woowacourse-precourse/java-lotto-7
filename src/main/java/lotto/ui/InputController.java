package lotto.ui;

import lotto.LottoPayment;
import lotto.exception.LottoArgumentException;

public class InputController {

    private final InputUi inputUi;

    public InputController(final InputUi inputUi) {
        this.inputUi = inputUi;
    }

    public LottoPayment getPayment() {
        final String input = inputUi.readLine().trim();
        validateNumber(input);
        return new LottoPayment(input);
    }

    private void validateNumber(final String numberInput) {
        isBlank(numberInput);
        isPositiveNumber(numberInput);
    }

    private void isBlank(final String numberInput) {
        if (numberInput.isBlank()) {
            throw new LottoArgumentException("공백은 허용되지 않습니다.");
        }
    }

    private void isPositiveNumber(final String numberInput) {
        for (int i = 0; i < numberInput.length(); i++) {
            if (!Character.isDigit(numberInput.charAt(i))) {
                throw new LottoArgumentException("숫자가 아닙니다.");
            }
        }
    }
}
