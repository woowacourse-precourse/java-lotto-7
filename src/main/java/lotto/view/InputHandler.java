package lotto.view;

import java.util.List;

public class InputHandler {
    public int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 입력받은 값이 숫자가 아닙니다.");
        }
    }

    public void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] null이 입력되었습니다.");
        }
    }

//    public List<Integer> parsedNumbers(String input) {
//
//    }
}
