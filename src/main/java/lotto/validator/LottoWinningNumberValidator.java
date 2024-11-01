package lotto.validator;

import java.util.List;
import lotto.enums.LottoCriteria;
import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoInputException;
import lotto.utility.NumberUtility;
import lotto.utility.StringUtility;

public class LottoWinningNumberValidator {

    private final static String LOTTO_SPLITTER = ",";

    public static void validateLottoWinningNumber(String lottoWinningNumberInput){
        List<String> lottoWinningNumberList = StringUtility.splitBySplitter(lottoWinningNumberInput,LOTTO_SPLITTER);
        if(!isValidWinningNumberSize(lottoWinningNumberList)){
            throw new LottoInputException(LottoErrorMessage.LOTTO_WINNING_INVALID_SIZE);
        }
        if(!NumberUtility.isNumbers(lottoWinningNumberList)){
            throw new LottoInputException(LottoErrorMessage.NOT_A_NUMBER);
        }
        if(!isNumbersInRange(lottoWinningNumberList)){
            throw new LottoInputException(LottoErrorMessage.INVALID_NUMBER);
        }
    }

    private static boolean isValidWinningNumberSize(List<String> lottoWinningNumberList) {
        if(lottoWinningNumberList.size() != LottoCriteria.WINNING_NUMBER_COUNT.getCriteriaVal()) {
            return false;
        }
        return true;
    }

    private static boolean isNumbersInRange(List<String> lottoWinningNumberList) {
        for(String lottoWinningNumber : lottoWinningNumberList){
            if(!isLottoWinningNumberInRange(NumberUtility.getNumber(lottoWinningNumber))){
                return false;
            }
        }
        return true;
    }

    private static boolean isLottoWinningNumberInRange(int number){
        return number >= LottoCriteria.MIN_LOTTO_NUM.getCriteriaVal()
                && number <= LottoCriteria.MAX_LOTTO_NUM.getCriteriaVal();
    }

    public static void validateLottoBonusNumber(String bonusNumber) {
        List<String> lottoWinningNumberList = StringUtility.splitBySplitter(bonusNumber,LOTTO_SPLITTER);
        if(!isValidBonusNumberSize(lottoWinningNumberList)){
            throw new LottoInputException(LottoErrorMessage.LOTTO_WINNING_INVALID_SIZE);
        }
        if(!NumberUtility.isNumbers(lottoWinningNumberList)){
            throw new LottoInputException(LottoErrorMessage.NOT_A_NUMBER);
        }
        if(!isNumbersInRange(lottoWinningNumberList)) {
            throw new LottoInputException(LottoErrorMessage.INVALID_NUMBER);
        }
    }

    private static boolean isValidBonusNumberSize(List<String> lottoBonusNumberList) {
        return lottoBonusNumberList.size() == LottoCriteria.BONUS_NUMBER_SIZE.getCriteriaVal();
    }
}


