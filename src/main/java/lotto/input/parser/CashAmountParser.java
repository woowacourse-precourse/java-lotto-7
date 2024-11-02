package lotto.input.parser;

import lotto.exception.ExceptionMessage;

public class CashAmountParser {
    private final int LOTTO_PRICE = 1000;

    public int parse(String input) throws IllegalArgumentException {
        validate(input);
        return calLottoAmount(input);
    }

    private void validate(String input) {
        try {
            int amount = Integer.parseInt(input);
            //음수값 체크
            if (amount < 0) {
                throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_INPUT.getMessage());
            }
            //1000 단위인지 체크
            if(amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(ExceptionMessage.THOUSAND_UNIT_ONLY.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER.getMessage());
        }
    }

    private int calLottoAmount(String input) {
        return Integer.parseInt(input) / LOTTO_PRICE;
    }
}
