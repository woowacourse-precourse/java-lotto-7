package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String ERROR_PURCHASE_AMOUNT = "[ERROR] 올바른 숫자를 입력해야 합니다.";
    private static final String ERROR_AMOUNT_POSITIVE = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    private static final String ERROR_WINNING_NUMBERS_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String ERROR_WINNING_NUMBERS_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                if (amount <= 0) {
                    throw new IllegalArgumentException(ERROR_AMOUNT_POSITIVE);
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_PURCHASE_AMOUNT);
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_PURCHASE_AMOUNT);
            }
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_SIZE);
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_RANGE);
        }
    }
}