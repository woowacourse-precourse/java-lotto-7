package lotto.view;

import java.util.regex.Pattern;
import lotto.exception.InvalidInputBonusNumberFormatException;

public class InputBonusNumberView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getBonusNumber() {
        System.out.println(INPUT_MESSAGE);
        String bonusNumber = inputValue();
        System.out.println();
        validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new InvalidInputBonusNumberFormatException();
        }
    }
}
