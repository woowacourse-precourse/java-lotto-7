package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private boolean isNumber(String input) {
        return input.matches("^[0-9]+$");
    }

}
