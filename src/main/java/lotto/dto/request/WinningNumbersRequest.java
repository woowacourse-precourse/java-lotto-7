package lotto.dto.request;

import static lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.List;

public record WinningNumbersRequest(List<Integer> winningNumbers) {

    private static final String DELIMITER = ",";

    public static WinningNumbersRequest from(String input) {
        try {
            return new WinningNumbersRequest(
                Arrays.stream(input.split(DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }
}
