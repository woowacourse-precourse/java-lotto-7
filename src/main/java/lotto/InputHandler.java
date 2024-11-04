package lotto;

import static lotto.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static lotto.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;
import static lotto.ErrorMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.LottoConstants.LOTTO_NUMBER_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    public InputHandler() {
    }

    public static int requestPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT);
        }
    }

    public static List<Integer> requestWinningNumber() {
        try {
            String[] inputNumbers = Console.readLine().split(LOTTO_NUMBER_DELIMITER);
            List<String> winningNumbers = Arrays.stream(inputNumbers).
                    map(String::trim).toList();

            return winningNumbers.stream().
                    map(Integer::parseInt).toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT);
        }
    }

    public static int requestBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT);
        }
    }
}
