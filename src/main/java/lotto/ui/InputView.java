package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ERROR_NON_POSITIVE_AMOUNT = "[ERROR] 0초과 값을 입력해주세요.";
    private static final String ERROR_INVALID_AMOUNT_UNIT = "[ERROR] 1,000원 단위로 입력해주세요.";
    private static final String ERROR_INVALID_NUMBER_FORMAT = "[ERROR] 정수값을 입력해주세요.";
    private static final String ERROR_INVALID_NUMBER_SIZE = "[ERROR] 각 번호는 1 이상 45 이하여야 합니다.";


    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 1,000원 단위로 입력해주세요");
            try {
                int amount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(amount);
                return amount;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT);
            }

    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요. (쉼표로 구분)");
        try {
            List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            validateWinningNumbers(numbers);
            return numbers;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT);
        }
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void validatePurchaseAmount(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException(ERROR_NON_POSITIVE_AMOUNT);
            }

            if (amount % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_INVALID_AMOUNT_UNIT);
            }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_INVALID_NUMBER_SIZE);
            }
        }

    }
}
