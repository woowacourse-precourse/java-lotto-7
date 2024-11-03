package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.MonetaryUnit;

import java.util.Arrays;
import java.util.List;

import static lotto.view.ErrorMessages.NOT_DIVISIBLE_BY_THOUSAND;
import static lotto.view.ErrorMessages.NOT_NUMBER_FORMAT;
import static lotto.view.LottoMessageFormats.*;

public class InputView {
    private static final String WINNING_LOTTO_DELIMITER = ",";

    private InputView() {
    }

    public static int readUserMoney() {
        System.out.println(INPUT_PURCHASE_AMOUNT_PROMPT_MESSAGE.getMessage());
        String userInput = Console.readLine();
        int userMoney = validateNumberFormatOfUserMoney(userInput);
        validateDivisibilityByThousand(userMoney);

        return userMoney;
    }

    private static int validateNumberFormatOfUserMoney(String userInput) {
        int userMoney;
        try {
            userMoney = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
        }

        return userMoney;
    }

    private static void validateDivisibilityByThousand(int userMoney) {
        if (userMoney % MonetaryUnit.USER_MONEY_PRICE.getUnit() != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    public static List<Integer> readWinningLotto() {
        System.out.println(INPUT_WINNING_NUMBERS_PROMPT_MESSAGE.getMessage());

        return Arrays.stream(Console.readLine().split(WINNING_LOTTO_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_PROMPT_MESSAGE.getMessage());

        return Integer.parseInt(Console.readLine());
    }
}