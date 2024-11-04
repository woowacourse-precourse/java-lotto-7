package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.entity.WinningNumbers;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import lotto.enums.NotificationMessage;

public class InputView {

    private static final String DELIMITER = ",";

    public static WinningNumbers getWinningNumbers() {
        List<Integer> mainNumbers = inputMainNumbers();
        int bonusNumber = inputBonusNumber(mainNumbers);
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(NotificationMessage.PURCHASE_AMOUNT.getMessage());

                String purchaseInput = Console.readLine().trim();
                validatePositiveInteger(purchaseInput);
                int purchaseAmount = Integer.parseInt(purchaseInput);

                validatePurchaseAmount(purchaseAmount);

                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_AMOUNT.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(int amount) {
        validateOverPrice(amount);
        validateDivisibleByPrice(amount);
    }

    private static List<Integer> inputMainNumbers() {
        while (true) {
            try {
                System.out.println(NotificationMessage.WINNING_NUMBERS.getMessage());

                String[] inputs = Console.readLine().trim().split(DELIMITER);
                List<Integer> mainNumbers = Arrays.stream(inputs)
                        .map(input -> {
                            validatePositiveInteger(input);
                            return Integer.parseInt(input.trim());
                        })
                        .collect(Collectors.toList());

                WinningNumbers.validateMainNumbers(mainNumbers);
                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return mainNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber(List<Integer> mainNumbers) {
        while (true) {
            try {
                System.out.println(NotificationMessage.BONUS_NUMBER.getMessage());

                String bonusInput = Console.readLine().trim();
                validatePositiveInteger(bonusInput);
                int bonusNumber = Integer.parseInt(bonusInput);

                WinningNumbers.validateBonusNumber(bonusNumber, mainNumbers);
                System.out.println(NotificationMessage.DIVIDER.getMessage());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePositiveInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    private static void validateDivisibleByPrice(int amount) {
        if (amount % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    private static void validateOverPrice(int amount) {
        if (amount < LottoConstants.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }
}
