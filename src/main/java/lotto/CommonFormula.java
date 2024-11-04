package lotto;

public class CommonFormula {
    public void isInputEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
        }
    }

    public void isContainsWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력이 불가능합니다.");
        }
    }
}
