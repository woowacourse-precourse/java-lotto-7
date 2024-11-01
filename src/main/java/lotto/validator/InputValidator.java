package lotto.validator;

public class InputValidator {
    private final int LIMIT_AMOUNT = 1000;

    public void validatePurchaseAmount(String amount) {
        if (!amount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
        if (Integer.parseInt(amount) < LIMIT_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (!(Integer.parseInt(amount) % LIMIT_AMOUNT == 0)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위어야 합니다.");
        }
    }

    public void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers.isBlank() || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 비어있을 수 없습니다.");
        }
        if (!winningNumbers.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 구분자는 쉼표여야 합니다.");
        }
        String[] splitWinningNumbers = winningNumbers.split(",");
        if (splitWinningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
        for (String number : splitWinningNumbers) {
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
