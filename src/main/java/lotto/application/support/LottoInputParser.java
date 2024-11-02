package lotto.application.support;

import static lotto.common.Consts.INPUT_MUST_BE_NUMBER;
import static lotto.common.Consts.INPUT_MUST_BE_POSITIVE_NUMBER;
import static lotto.common.Consts.LOTTO_PRICE;
import static lotto.common.Consts.PURCHASE_AMOUNT_1000_UNIT;

import lotto.common.Errors;

public class LottoInputParser {

    public int parseAmount(String amount){
        try{
            int parsed = Integer.parseInt(amount);
            validate(parsed);

            return parsed;
        } catch (NumberFormatException e) {
            Errors.IllegalArgumentException(INPUT_MUST_BE_NUMBER);
        }
        return -1;
    }

    private void validate(int amount){
        if((amount % LOTTO_PRICE) != 0){
            Errors.IllegalArgumentException(PURCHASE_AMOUNT_1000_UNIT);
        }

        if(amount < 0){
            Errors.IllegalArgumentException(INPUT_MUST_BE_POSITIVE_NUMBER);
        }
    }
}
