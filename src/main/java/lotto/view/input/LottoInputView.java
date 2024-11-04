package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.output.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView {

    public int readMoney() {
        String input = Console.readLine();
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT_ERROR.toString());
        }

        int money = tryParseInt(input);
        moneyValidate(money);

        return money;
    }

    public List<Integer> readLottoNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .map(this::tryParseInt)
                .collect(Collectors.toList());
    }

    public int readBonusNumber() {
        return tryParseInt(Console.readLine());
    }

    private int tryParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.toString());
        }
    }

    private static void moneyValidate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_UNDER_1000.toString());
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_MULTIPLE_1000.toString());
        }
    }
}