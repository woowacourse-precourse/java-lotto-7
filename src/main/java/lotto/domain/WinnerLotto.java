package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorCode;

public class WinnerLotto extends Lotto {

    public WinnerLotto(List<Integer> numbers) {
        super(numbers);
    }

    public static WinnerLotto from(String winningNumbersInput) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(WinnerLotto::parseInt)
                .toList();
        return new WinnerLotto(winningNumbers);
    }

    private static Integer parseInt(String number) {
        try {
            return  Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NOT_INTEGER.getMessage());
        }
    }
}
