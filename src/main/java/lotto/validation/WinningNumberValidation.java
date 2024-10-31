package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_LENGTH_6;
import static lotto.constants.LottoNumbers.LOTTO_NUMBER_COUNT;

public class WinningNumberValidation {
    private final static String DELIMITER = ",";

    public static void validate(String inputWinningNumbers) {
        List<String> winningNumbers = setTrimNumbers(inputWinningNumbers);
        winningNumbers = setUniqueNumbers(winningNumbers);
    }

    public static List<String> setTrimNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
    public static List<String> setUniqueNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }

        Set<String> uniqueWinningNumbers = Set.copyOf(winningNumbers);
        if (uniqueWinningNumbers.size() < winningNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }

        return uniqueWinningNumbers.stream().toList();
    }
}
