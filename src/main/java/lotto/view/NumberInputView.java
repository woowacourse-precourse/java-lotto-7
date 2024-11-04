package lotto.view;

import lotto.util.Converter;
import lotto.util.Validator;

import java.util.List;

public class NumberInputView extends InputView {

    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println(REQUEST_WINNING_NUMBER);
                String input = inputValue();

                Validator.validateNotBlank(input);
                return Converter.convertLottoNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                System.out.println(REQUEST_BONUS_NUMBER);
                String input = inputValue();

                validateBonusBefore(input);
                int number =  Integer.parseInt(input);
                validateBonusAfter(number);
                return  number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateBonusBefore(String input) {
        Validator.validateNotBlank(input);
        Validator.validateIsNumeric(input);
    }

    private static void validateBonusAfter(int input) {
        Validator.validateLottoRange(input);
    }
}
