package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.ErrorMessages;

public class InputView {

    public static int getPurchaseAmount() {
        while (true) {
            System.out.println("구입 금액을 1,000원 단위로 입력해주세요");
            try {
                int amount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(amount);
                return amount;

            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.ERROR_INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해주세요. (쉼표로 구분)");
            try {
                List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                        .map(Integer::parseInt)
                        .sorted()
                        .collect(Collectors.toList());
                validateWinningNumbers(numbers);
                return numbers;

            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.ERROR_INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해주세요.");
            try {
                int number = Integer.parseInt(Console.readLine());
                validateBonusNumber(number, winningNumbers);
                return number;

            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.ERROR_INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void validatePurchaseAmount(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_NON_POSITIVE_AMOUNT);
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_AMOUNT_UNIT);
            }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_WINNING_NUMBER_COUNT);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_NUMBER_DUPLICATION);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_NUMBER_SIZE);
            }
        }
    }

    private static void validateBonusNumber(int number, List<Integer> winningNumber) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_NUMBER_SIZE);
        }
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_NUMBER_DUPLICATION);
        }
    }
}
