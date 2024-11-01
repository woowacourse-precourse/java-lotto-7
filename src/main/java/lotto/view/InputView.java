package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ErrorMessage;
import lotto.enums.NotificationMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(NotificationMessage.PURCHASE_AMOUNT.getMessage());

                int purchaseAmount = Integer.parseInt(Console.readLine().trim());

                validatePurchaseAmount(purchaseAmount);

                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(NotificationMessage.WINNING_NUMBERS.getMessage());

        String[] inputs = Console.readLine().trim().split(",");
        if (inputs.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }

        List<Integer> numbers = new ArrayList<>();

        for (String input : inputs) {
            numbers.add(Integer.parseInt(input.trim()));
        }

        return numbers;
    }

    public static int getBonusNumber() {
        System.out.println(NotificationMessage.BONUS_NUMBER.getMessage());

        return Integer.parseInt(Console.readLine().trim());
    }
}
