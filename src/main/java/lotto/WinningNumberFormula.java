package lotto;

public class WinningNumberFormula {
    public void isContainsNotInteger(String input) {
        if (!input.matches("[0-9,]*")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표(,)만 입력 가능합니다.");
        }
    }

    public void isWrongForm(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 형식입니다.");
        }
    }
}
