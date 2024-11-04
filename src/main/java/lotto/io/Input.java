package lotto.io;


import static lotto.vo.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.vo.ErrorMessage;

public class Input implements AutoCloseable {


    public static int readMoney() {
        String money = Console.readLine();

        validateNumber(money);

        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
        }

        return Integer.parseInt(money);
    }

    public static List<Integer> readWinningNumber() {
        String winningNumber = Console.readLine();

        if (!Pattern.matches("^[1-9|,]+$", winningNumber)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }

        if (winningNumber.startsWith(",") && winningNumber.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

        List<Integer> numbers = Arrays
                .stream(winningNumber.trim().split(","))
                .map(number -> {
                    validateLottoNumberLimit(Integer.parseInt(number));
                    return Integer.parseInt(number);
                })
                .distinct()
                .toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION.getMessage());
        }

        return numbers;
    }

    public static int readBonusNumber() {
        String strBonusNumber = Console.readLine();
        validateNumber(strBonusNumber);

        int bonusNumber = Integer.parseInt(strBonusNumber);
        validateLottoNumberLimit(bonusNumber);

        return bonusNumber;
    }

    private static void validateNumber(String input) {
        boolean isNotNumber = !Pattern.matches("[0-9]+", input);
        if (isNotNumber) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBERS.getMessage());
        }
    }

    private static void validateLottoNumberLimit(int bonusNumber) {
        if (bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_LIMIT.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        Console.close();
    }
}
