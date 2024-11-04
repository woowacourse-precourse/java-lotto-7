package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Inputview {
    private static final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private Lotto latestWinningNumbers;

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                int amount = stringToInt(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> numbers = parseCommaDelimitedNumbers(input);
                latestWinningNumbers = new Lotto(numbers);
                return latestWinningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println( e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                int number = stringToInt(input);
                validateBonusNumber(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> parseCommaDelimitedNumbers(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_INPUT.getMessage());
        }

        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberStr : numberStrings) {
            int number = stringToInt(numberStr.trim());
            validateNumberInRange(number);
            numbers.add(number);
        }

        return numbers;
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < MINIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_AMOUNT.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void validateNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusNumber(int number) {
        validateNumberInRange(number);
        if (latestWinningNumbers != null && latestWinningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public String[] splitByComma(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_INPUT.getMessage());
        }
        return input.split(",");
    }

    public int stringToInt(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.MISSING_INPUT.getMessage());
            }
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
