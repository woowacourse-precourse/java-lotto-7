package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.info.LottoInfo;
import lotto.message.ErrorMessage;

public class InputView {
    public static int getMoneyToBuy() {
        while (true) {
            try {
                OutputView.notifyEnterMoneyToBuy();
                String input = Console.readLine();
                return validateMoneyToBuy(input);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static int validateMoneyToBuy(String input) {
        try {
            int moneyToBuy = Integer.parseInt(input); // 숫자가 아닌 경우 NumberFormatException 발생
            if (moneyToBuy <= 0) {
                throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
            }
            if (moneyToBuy % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE.getMessage());
            }
            return moneyToBuy;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage(), e);
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                OutputView.notifyEnterWinningMoney();
                String input = Console.readLine();
                return validateWinningNumbers(input);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        try {
            String[] tokens = input.split(",");
            if (tokens.length != LottoInfo.COUNT.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT_ERROR_MESSAGE.getMessage());
            }

            List<Integer> winningNumbers = new ArrayList<>();
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (String s : tokens) {
                String token = s.trim();

                int number = Integer.parseInt(token);

                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
                }

                if (uniqueNumbers.contains(number)) {
                    throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
                }

                uniqueNumbers.add(number);
                winningNumbers.add(number);
            }

            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage(), e);
        }
    }
}
