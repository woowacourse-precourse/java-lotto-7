package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.exception.InvalidInputWinningNumbersException;

public class InputWinningNumbersView extends InputView {
    // PATTERN: 1자리 또는 2자리 숫자와 쉼표가 5번 반복 + 1자리 또는 2자리 숫자
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해주세요.";

    public List<Integer> getWinningNumberList() {
        System.out.println(INPUT_MESSAGE);
        String inputValue = inputValue();
        System.out.println();
        validate(inputValue);
        return Arrays.stream(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new InvalidInputWinningNumbersException();
        }
    }
}
