package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ExceptionMessage;
import lotto.common.IOMessage;
import lotto.common.Limit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println(IOMessage.PURCHASE_AMOUNT_PROMPT);
        int amount = Integer.parseInt(Console.readLine());
        if (amount % Limit.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT);
        }
        return amount;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(IOMessage.WINNING_NUMBERS_PROMPT);
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int inputBonusNumber() {
        System.out.println(IOMessage.BONUS_NUMBER_PROMPT);
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < Limit.LOTTO_MIN_NUMBER || bonusNumber > Limit.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
        return bonusNumber;
    }
}
