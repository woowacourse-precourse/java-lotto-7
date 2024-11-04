package lotto.view;

import java.util.regex.Pattern;
import lotto.exception.InvalidInputMoneyFormatException;

public class InputBuyLottoView extends InputView{
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "구입 금액을 입력해 주세요.";

    public Integer getMoneyValue() {
        System.out.println(INPUT_MESSAGE);
        String moneyValue = inputValue();
        System.out.println();
        validate(moneyValue);
        return Integer.parseInt(moneyValue);
    }

    private void validate(String moneyValue) {
        validateFormat(moneyValue);
    }

    private void validateFormat(String moneyValue) {
        if(!PATTERN.matcher(moneyValue).matches()) {
            throw new InvalidInputMoneyFormatException();
        }
    }
}
