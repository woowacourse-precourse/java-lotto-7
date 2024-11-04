package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class InputView {
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_PURCHASE_AMOUNT = 1000;

    private static final String MESSAGE_WINNING_NUMBERS = "당첨 번호를 입력해 주세요. (쉼표로 구분하여 6개 입력)";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ERROR_INVALID_NUMBER = "[ERROR] 유효한 숫자를 입력해 주세요.";
    private static final String ERROR_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 " + WINNING_NUMBER_COUNT + "개여야 합니다.";
    private static final String ERROR_WINNING_NUMBERS_RANGE = "[ERROR] 당첨 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] 당첨 번호에는 중복된 숫자가 없어야 합니다.";
    private static final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String ERROR_PURCHASE_AMOUNT = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";

    public static List<Integer> getWinningNumbers() {
        try {
            System.out.println(MESSAGE_WINNING_NUMBERS);
            String[] inputs = splitInput(Console.readLine());
            List<Integer> numbers = parseNumbers(inputs);
            validateWinningNumbers(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        try {
            System.out.println(MESSAGE_BONUS_NUMBER);
            int bonusNumber = parseNumber(Console.readLine());
            validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    public static int getPurchaseAmount() {
        try {
            System.out.println(MESSAGE_PURCHASE_AMOUNT);
            int amount = parseNumber(Console.readLine());
            validatePurchaseAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private static String[] splitInput(String input) {
        return input.split(",");
    }

    private static List<Integer> parseNumbers(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(parseNumber(input));
        }
        return numbers;
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
        }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_COUNT);
        }
        if (numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_RANGE);
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBERS);
        }
    }

    private static void validateBonusNumber(int number, List<Integer> winningNumbers) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
        }
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT || amount % MIN_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT);
        }
    }
}
