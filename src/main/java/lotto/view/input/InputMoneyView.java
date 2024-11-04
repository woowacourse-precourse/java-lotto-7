package lotto.view.input;

import java.util.regex.Pattern;
import lotto.exception.MoneyFormatException;

public class InputMoneyView extends InputView {
    private static final String INPUT_MESSAGE = "금액을 입력해주세요";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public Integer getValue() {
        System.out.println(INPUT_MESSAGE);
        String input = inputValue();
        validate(input);

        return Integer.parseInt(input);
    }

    private void validate(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new MoneyFormatException();
        }
    }
}
