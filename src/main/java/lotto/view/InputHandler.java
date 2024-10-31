package lotto.view;

public class InputHandler {
    public int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 입력받은 값이 숫자가 아닙니다.");
        }
    }
}
