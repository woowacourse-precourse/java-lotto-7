package lotto.service;

import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;
import static lotto.constants.ErrorMessage.LOTTO_CAN_NOT_HAVE_CHARACTER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.model.InputWinningNumbers;

public class ParseNumbersService {

    private static final Pattern HAS_CHARACTER_PATTERN = Pattern.compile("[^0-9]");
    private static final String NUMBERS_DELIMITER = ",";
    private static final int INCLUDE_AFTER_DELIMITER = -1;

    public ParseNumbersService() {
    }

    public List<Integer> getWinningLotto(InputWinningNumbers inputWinningNumbers) {
        List<String> winningNumbers = Arrays.stream(inputWinningNumbers.get()
                        .split(NUMBERS_DELIMITER, INCLUDE_AFTER_DELIMITER))
                .map(String::strip).toList();

        validate(winningNumbers);

        return winningNumbers.stream().mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validate(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            validateIsBlank(winningNumber);
            validateHasCharacter(winningNumber);
        }
    }

    private void validateIsBlank(String winningNumber) {
        if (winningNumber == null || winningNumber.isBlank()) {
            throw new IllegalArgumentException(INPUT_CAN_NOT_BE_BLANK.get());
        }
    }

    private void validateHasCharacter(String winningNumber) {
        if (HAS_CHARACTER_PATTERN.matcher(winningNumber).find()) {
            throw new IllegalArgumentException(LOTTO_CAN_NOT_HAVE_CHARACTER.get());
        }
    }
}
