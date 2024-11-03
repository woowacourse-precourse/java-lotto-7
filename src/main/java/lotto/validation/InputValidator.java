package lotto.validation;

import java.util.ArrayList;
import java.util.List;
import static lotto.utils.Constants.DELIMITER;
import static lotto.utils.MessageFormatter.formatErrorMessage;
import static lotto.utils.ErrorMessages.*;

public class InputValidator {
    public static int amountValidate (String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(formatErrorMessage(AMOUNT_SHOULD, BE_INTEGER));
        }
    }

    public static List<Integer> listValidate (String input) {
        List<Integer> result = new ArrayList<>();
        String[] tokens = input.split(DELIMITER);
        for (String token : tokens) {
            try {
                result.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(formatErrorMessage(LOTTO_SHOULD, BE_INTEGER));
            }
        }
        return result;
    }

    public static int bonusValidate (String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(formatErrorMessage(BONUS_SHOULD, BE_INTEGER));
        }
    }
}
