package lotto.model;

import lotto.util.InputValidator;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input, WinningNumbers winningNumbers, InputValidator validator) {
        validate(input, winningNumbers, validator);
        this.number = Integer.parseInt(input.trim());
    }

    private void validate(String input, WinningNumbers winningNumbers, InputValidator validator) {
        if (validator == null) {
            throw new IllegalStateException("입력 검증기가 초기화되지 않았습니다.");
        }
        validator.validateBonusNumber(input, winningNumbers.getNumbers());
    }

    public int getNumber() {
        return number;
    }
}
