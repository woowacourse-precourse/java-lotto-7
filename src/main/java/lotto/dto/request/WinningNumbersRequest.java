package lotto.dto.request;

import static lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.List;

public record WinningNumbersRequest(List<Integer> winningNumbers) {

    public static WinningNumbersRequest from(String input) {
        try {
            return new WinningNumbersRequest(
                Arrays.stream(input.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }
}
