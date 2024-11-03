package lotto.view;

import lotto.util.Converter;
import lotto.util.Validator;

import java.util.List;

public class NumberInputView extends InputView {

    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static List<Integer> getWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = inputValue();

        Validator.validateNotBlank(input);
        return Converter.convertLottoNumber(input);
    }

    public static int getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = inputValue();

        Validator.validateNotBlank(input);
        Validator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }
}
