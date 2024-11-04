package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String ERROR_AMOUNT_MESSAGE = "[ERROR] 구입 금액은 숫자여야 하며 1,000원 단위로 입력해 주세요.";
    private static final String ERROR_WINNING_NUMBERS_MESSAGE = "[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String PROMPT_AMOUNT = "구입 금액을 입력해 주세요:";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요 (쉼표로 구분):";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요:";

    public int readPurchaseAmount() {
        while (true) {
            System.out.println(PROMPT_AMOUNT);
            String input = Console.readLine();

            try {
                int amount = Integer.parseInt(input);
                validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_AMOUNT_MESSAGE);
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            System.out.println(PROMPT_WINNING_NUMBERS);
            String input = Console.readLine();

            try {
                List<Integer> numbers = parseWinningNumbers(input);
                validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_WINNING_NUMBERS_MESSAGE);
            }
        }
    }

    public int readBonusNumber() {
        while (true) {
            System.out.println(PROMPT_BONUS_NUMBER);
            String input = Console.readLine();

            try {
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_BONUS_NUMBER_MESSAGE);
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.stream().anyMatch(n -> n < 1 || n > 45) || numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
