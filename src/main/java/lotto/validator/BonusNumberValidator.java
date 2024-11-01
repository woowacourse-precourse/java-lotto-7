package lotto.validator;

import java.util.List;

public class BonusNumberValidator {
    private String inputBonusNumber;

    private void setValue(String inputBonusNumber) {
        this.inputBonusNumber = inputBonusNumber;
    }

    public void validate(List<Integer> winningNumbers, String inputBonusNumber) {
        setValue(inputBonusNumber);
        validateBlank();
        validatePositiveInteger();
        validateDuplicateWithWinningNumbers(winningNumbers);
    }

    private void validateBlank() {
        if (inputBonusNumber.isEmpty() || inputBonusNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 빈칸일 수 없습니다.");
        }
    }

    private void validatePositiveInteger() {
        if (!inputBonusNumber.trim().matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
    }

    private void validateDuplicateWithWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(inputBonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
        }
    }
}
