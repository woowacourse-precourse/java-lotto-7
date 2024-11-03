package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

import static java.lang.Integer.parseInt;

public class InputView {
    public static int getAmount() {
        System.out.println("구입금액을 입력해주세요.");
        String input = Console.readLine();

        Validator.validateInput(input);

        return getLottoAmount(input);
    }

    private static int getLottoAmount(String input) {
        final int DIVIDER = 1000;
        int value = parseInt(input);

        return value / DIVIDER;
    }
}