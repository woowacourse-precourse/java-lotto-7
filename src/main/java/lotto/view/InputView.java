package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ErrorMessages;

public class InputView {

    private static final String PURCHASE_PRICE_MSG = "\n구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MSG = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MSG = "\n보너스 번호를 입력해 주세요.";

    public static Integer inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MSG);
        String input = Console.readLine();
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_PRICE_FORMAT.getMessage());
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MSG);
        String input = Console.readLine();
        if (!input.matches("^[0-9]+(,[0-9]+){5}$")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MSG);
        String input = Console.readLine();
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
        return Integer.parseInt(input);
    }
}
