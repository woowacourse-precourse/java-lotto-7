package lotto.model;

import lotto.util.InputValidator;

public class BonusNumber {
    private final int number;
    private final InputValidator validator;

    public BonusNumber(String input, WinningNumbers winningNumbers, InputValidator validator) {
        if (validator == null) {
            throw new IllegalStateException("입력 검증기가 초기화되지 않았습니다.");
        }
        this.validator = validator;
        validator.validateBonusNumber(input, winningNumbers.getNumbers());
        this.number = Integer.parseInt(input.trim());
    }

    public int getNumber() {
        return number;
    }
}
