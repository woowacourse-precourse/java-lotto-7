package lotto.viewHandler.validator;

import lotto.viewHandler.Validator;
import lotto.viewHandler.exception.NotInteger;

public class LottoPurchaseMoneyParseInt implements Validator<Integer, String> {
    @Override
    public Integer validate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotInteger("숫자만 입력해주세요.");
        }
    }
}
