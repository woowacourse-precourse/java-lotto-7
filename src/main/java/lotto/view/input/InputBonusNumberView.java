package lotto.view.input;

import java.util.regex.Pattern;
import lotto.exception.SingleNumberFormatException;

public class InputBonusNumberView extends InputView {
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해주세요.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public Integer getValue() {
        System.out.println(INPUT_MESSAGE);
        String bonusNumber = inputValue();
        validate(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private void validate(String s) {
        if(!PATTERN.matcher(s).matches()) {
            throw new SingleNumberFormatException();
        }
    }
}
