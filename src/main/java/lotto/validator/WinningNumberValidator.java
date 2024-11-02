package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberValidator {
    private final String SEPARATOR = ",";
    private String inputWinningNumbers;
    private String[] winningNumbers;
    private List<Integer> duplicateCheckNumbers;

    private void setValue(String inputWinningNumbers) {
        this.inputWinningNumbers = inputWinningNumbers;
        this.winningNumbers = inputWinningNumbers.split(SEPARATOR);
        this.duplicateCheckNumbers = new ArrayList<>();
    }

    public void validate(String inputWinningNumbers) {
        setValue(inputWinningNumbers);
        validateBlank();
        validateSeparator();
        validateSize();
        validateEachNumber();
    }

    private void validateSeparator() {
        if (!inputWinningNumbers.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 구분자는 쉼표여야 합니다.");
        }
    }

    private void validateBlank() {
        if (inputWinningNumbers.isBlank() || inputWinningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 비어있을 수 없습니다.");
        }
    }

    private void validateSize() {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
    }

    private void validateEachNumber() {
        for (String number : winningNumbers) {
            validateNumeric(number.trim());
            int parseNumber = Integer.parseInt(number);
            validateOutOfRange(parseNumber);
            isDuplicate(parseNumber);
            duplicateCheckNumbers.add(parseNumber);
        }
    }

    private void validateNumeric(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 정수여야 합니다.");
        }
    }

    private void validateOutOfRange(int parseNumber) {
        if (parseNumber < 1 || parseNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 1이상 45이하여야 합니다.");
        }
    }

    private void isDuplicate(int parseNumber) {
        if (duplicateCheckNumbers.contains(parseNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 서로 중복될 수 없습니다.");
        }
    }
}
