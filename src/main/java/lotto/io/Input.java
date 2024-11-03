package lotto.io;

import static lotto.io.Validator.validateBonusNumber;
import static lotto.io.Validator.validatePrice;
import static lotto.io.Validator.validateWinningNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public abstract class Input {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int price() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String input = Console.readLine();
        validatePrice(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    public static List<Integer> winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateWinningNumber(input);
        System.out.println();

        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateBonusNumber(input);
        System.out.println();
        return Integer.parseInt(input);
    }
}
