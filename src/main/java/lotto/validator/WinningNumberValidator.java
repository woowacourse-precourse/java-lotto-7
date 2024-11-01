package lotto.validator;

public class WinningNumberValidator {
    private String inputWinningNumbers;
    private String[] winningNumbers;
    private final String SEPARATOR = ",";

    public void setValue(String inputWinningNumbers) {
        this.inputWinningNumbers = inputWinningNumbers;
        this.winningNumbers = inputWinningNumbers.split(SEPARATOR);
    }


    public void validate(String inputWinningNumbers) {
        setValue(inputWinningNumbers);
        validateBlank();
        validateSeparator();
        validateSize();
        validateEachNumber();
    }

    private void validateSeparator() {
        if (inputWinningNumbers.contains(",")) {
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
            if (!isNumeric(number.trim())) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 정수여야 합니다.");
            }
            if (!isOutOfRange(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1이상 45이하여야 합니다.");
            }
        }
    }

    private boolean isNumeric(String number) {
        return number.matches("\\d+");
    }

    private boolean isOutOfRange(String number) {
        int parseNumber = Integer.parseInt(number);
        return parseNumber >= 1 && parseNumber <= 45;
    }

    public void validateBonusNumber(String bonusNumber) {

    }
}
