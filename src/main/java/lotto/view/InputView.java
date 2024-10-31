package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getPurchaseAmount() {
        String input = Console.readLine();
        validateBlankInput(input);
        return Integer.parseInt(input);
    }

    private void validateBlankInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열은 입력할 수 없습니다.");
        }
    }
}
