package lotto.util;

import java.util.List;
import java.util.function.Supplier;

public class RetryUtil {
    public static String retryReadPurchaseAmount(Supplier<String> supplier) {
        while (true) {
            try {
                String purchaseAmount = supplier.get();
                InputValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String retryReadWinningNumber(Supplier<String> supplier) {
        while (true) {
            try {
                String winningNumber = supplier.get();
                InputValidator.validateWinningNumber(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String retryReadBonusNumber(Supplier<String> supplier, List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = supplier.get();
                InputValidator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
