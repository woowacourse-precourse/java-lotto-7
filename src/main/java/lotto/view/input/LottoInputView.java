package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.output.ErrorMessage;

public class LottoInputView {

    public int readMoney() {
        String input = Console.readLine();
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT_ERROR.toString());
        }

        int money = tryParseInt(input);

        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 이상이어야 합니다");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 모든 숫자는 1000으로 나누어 떨어져야 합니다.");
        }

        return money;
    }

    private int tryParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.toString());
        }
    }
}