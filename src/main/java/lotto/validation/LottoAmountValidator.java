package lotto.validation;

import lotto.constant.LottoConstant;
import lotto.exception.LottoException;

public class LottoAmountValidator extends LottoValidator {
    private final static String REGEX_EXPRESSION = "^[0-9]+$";

    public static Integer validateLottoAmount(String amount){
        checkForNonNumericValues(amount);
        hasThousandRemainder(amount);
        validateMinimumPurchaseAmount(amount);
        return Integer.parseInt(amount);
    }

    private static void hasThousandRemainder(String amount){
        if(remainderAmountByLottoPrice(amount)!=0){
            throw new IllegalArgumentException(LottoException.INVALID_AMOUNT.getMessage());
        }
    }

    private static Integer divideAmountByLottoPrice(String amount){
        return (Integer.parseInt(amount))/LottoConstant.LOTTO_PRICE;
    }

    private static Integer remainderAmountByLottoPrice(String amount){
        return (Integer.parseInt(amount))%LottoConstant.LOTTO_PRICE;
    }


    private static void validateMinimumPurchaseAmount(String amount){
        if(divideAmountByLottoPrice(amount)==0){
            throw new IllegalArgumentException(LottoException.INVALID_AMOUNT.getMessage());
        }
    }

    private static void checkForNonNumericValues(String input){
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(LottoException.INVALID_AMOUNT.getMessage());
        }
    }

}
