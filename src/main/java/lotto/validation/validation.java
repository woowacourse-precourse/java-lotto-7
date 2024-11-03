package lotto.validation;

import lotto.View.InputView;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.View.InputView.*;

public class validation {
    public static int validatePurchaseAmount(String purchase_amount) {
        if (!check_invalidAmount(purchase_amount)) {
            throw new IllegalArgumentException(ERROR_PurchaseAmount);
        }
        return Integer.parseInt(purchase_amount);
    }

    public static Lotto validateWinningNumber(String input_winning_number) {
        if (!isRangeValidWinningNumber(input_winning_number)) {
            throw new IllegalArgumentException(ERROR_RangeValidWinningNumber);
        }
        if (!isCommaWinngingnumber(input_winning_number)) {
            throw new IllegalArgumentException(ERROR_CommaValidWinningNumber);
        }
        if (!isOverlapWinningnumber(input_winning_number)) {
            throw new IllegalArgumentException(ERROR_OverlapValidWinningNumber);
        }
        return parseWinningNumbers(input_winning_number);
    }

    public static int validateBounsNumber(String input_bouns_number) {
        if (!isRangeBounsNumber(input_bouns_number)) {
            throw new IllegalArgumentException(ERROR_RangeValidBounsNumber);
        }
        return parseBounsNumber(input_bouns_number);
    }

    private static boolean isRangeBounsNumber(String input_bouns_number) {
        int bounsNumber = parseBounsNumber(input_bouns_number);
        return bounsNumber >= 1 && bounsNumber <= 45;
    }

    private static boolean isRangeValidWinningNumber(String input_winning_number) {
        String[] winning_numbers = input_winning_number.split(",");
        for (String number : winning_numbers) {
            int valid_number = Integer.parseInt(number.trim());
            if (valid_number < 1 || valid_number > 45) return false;
        }
        return true;
    }

    private static boolean isOverlapWinningnumber(String input_winning_number) {
        Set<Integer> winning_number_set = new HashSet<>();
        String[] winning_numbers = input_winning_number.split(",");
        for (String number : winning_numbers) {
            int valid_number = Integer.parseInt(number.trim());
            if (!winning_number_set.add(valid_number)) return false;
        }
        return true;
    }

    private static boolean isCommaWinngingnumber(String input_winning_number) {
        return input_winning_number.contains(",");
    }

    private static Lotto parseWinningNumbers(String input_winning_number) {
        List<Integer> numbers = Arrays.stream(input_winning_number.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }

    private static int parseBounsNumber(String input_bouns_number) {
        return Integer.parseInt(input_bouns_number);
    }
    private static boolean check_invalidAmount(String purchase_amount) {
        return (purchase_amount.matches("^[0-9]+$") && Integer.parseInt(purchase_amount) % 1000 == 0 && Integer.parseInt(purchase_amount) > 0);
    }
}
