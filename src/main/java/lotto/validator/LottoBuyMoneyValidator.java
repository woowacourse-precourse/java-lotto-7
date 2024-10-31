package lotto.validator;

import lotto.enums.LottoCriteria;
import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoInputException;
import lotto.utility.NumberUtility;

public class LottoBuyMoneyValidator {

    public static void validateLottoBuyMoney(String lottoBuyMoney){
        if(!NumberUtility.isNumber(lottoBuyMoney)){
            throw new LottoInputException(LottoErrorMessage.NOT_A_NUMBER);
        }
        if(!NumberUtility.isPositive(NumberUtility.getNumber(lottoBuyMoney))){
            throw new LottoInputException(LottoErrorMessage.NOT_POSITIVE);
        }
        if(!isValidMoneyUnit(NumberUtility.getNumber(lottoBuyMoney))){
            throw new LottoInputException(LottoErrorMessage.INVALID_BUY_NUMBER);
        }
        if(!isValidLottoTry(NumberUtility.getNumber(lottoBuyMoney))){
            throw new LottoInputException(LottoErrorMessage.INVALID_LOTTO_COUNT);
        }
    }

    private static boolean isValidMoneyUnit(int lottoBuyMoney) {
        if(lottoBuyMoney % LottoCriteria.BUY_MONEY_UNIT.getCriteriaVal() != 0) {
            return false;
        }
        return true;
    }

    private static boolean isValidLottoTry(int lottoBuyNum) {
        int lottoCount = lottoBuyNum / LottoCriteria.BUY_MONEY_UNIT.getCriteriaVal();
        if(lottoCount > LottoCriteria.MAX_LOTTO_COUNT.getCriteriaVal()){
            return false;
        }
        if(lottoCount < LottoCriteria.MIN_LOTTO_COUNT.getCriteriaVal()){
            return false;
        }
        return true;
    }
}