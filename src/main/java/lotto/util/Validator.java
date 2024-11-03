package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static int validatePurchaseAmount(String input) {
        try {
            long purchaseAmount = Long.parseLong(input);

            if (purchaseAmount > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("[ERROR] 구입금액이 너무 큽니다.");
            } else if (purchaseAmount < 1000) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 이상이어야 합니다.");
            } else if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력할 수 있습니다.");
            }

            return (int) purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수만 입력할 수 있습니다.");
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] winningNumbers = input.split(",");

        Set<String> unique = new HashSet<>(Arrays.asList(winningNumbers));
        if (unique.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 다른 6개의 번호를 입력해 주세요.");
        }

        boolean anyMatch = Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 1 || number > 45);
        if (anyMatch) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .toList();
    }
}
