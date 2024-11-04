package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "\n보너스 번호를 입력해 주세요.";
    private static final String ERROR_INVALID_NUMBER = "[ERROR] 숫자를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public static int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return parseInt(Console.readLine());
    }

    public static Lotto readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return parseToLotto(Console.readLine());
    }

    public static int readBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return parseInt(Console.readLine());
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_INVALID_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private static Lotto parseToLotto(String input) {
        String[] tokens = input.replaceAll("\\s", "").split(DELIMITER);
        List<Integer> numbers = Arrays.stream(tokens)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }
}
