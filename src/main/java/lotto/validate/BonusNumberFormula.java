package lotto.validate;

public class BonusNumberFormula {
    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        }
    }

    public void isRightRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 값이어야 합니다.");
        }
    }
    public void isDuplicate(String input, String winningNumber) {
        if (winningNumber.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 중복된 값은 불가능합니다.");
        }
    }
}
