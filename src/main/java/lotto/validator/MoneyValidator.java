package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class MoneyValidator {
    private static final int LOTTO_PRICE = 1000;

    public static void validate(String input){
        try{
            int money = Integer.parseInt(input);
            if(money % LOTTO_PRICE != 0){
                throw new LottoException(ErrorMessage.INVALID_MONEY_AMOUNT);
            }
        } catch (NumberFormatException e){
            throw new LottoException(ErrorMessage.INVALID_MONEY_FORMAT);
        }
    }
}
