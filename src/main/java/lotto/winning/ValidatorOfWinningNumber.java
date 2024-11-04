package lotto.winning;

import java.util.List;

public class ValidatorOfWinningNumber {
    private static ValidatorOfWinningNumber validator;

    private ValidatorOfWinningNumber() {}

    public static ValidatorOfWinningNumber getValidator() {
        if (validator == null) {
            validator = new ValidatorOfWinningNumber();
            return validator;
        }
        return validator;
    }

    public void validateCastingToNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력하세요.");
        }
    }

    public void validateInRange(int number) {
        boolean isInRange = (1 <= number) && (number <= 45);
        if (!isInRange) {
            throw new IllegalArgumentException("[ERROR] 1 - 45 사이의 숫자만 입력하세요.");
        }
    }

    public void validateDegenerate(List<Integer> winningNumbers, int number) {
        boolean isDegenerated = winningNumbers.contains(number);
        if (isDegenerated) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }
}
