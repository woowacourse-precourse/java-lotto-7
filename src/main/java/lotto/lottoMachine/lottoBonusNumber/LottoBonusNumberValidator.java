package lotto.lottoMachine.lottoBonusNumber;

import java.util.List;
import lotto.lottoMachine.utils.StaticFinalMessages;

public class LottoBonusNumberValidator {
    public boolean validateAllThing(String bonusNumber, List<Integer> seperatedLottoWinningNumbers) {
        return validateIsNumeric(bonusNumber) && validateRangeOfNumbersGreaterThan1AndLessThan45(bonusNumber)
                && validateIsOverlapWithWinningNumber(bonusNumber, seperatedLottoWinningNumbers);
    }

    // number format exception 말고 또 다른 것도 있나?
    private boolean validateIsNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private boolean validateRangeOfNumbersGreaterThan1AndLessThan45(String bonusNumber) {
        int convertedBonusNumber = Integer.parseInt(bonusNumber);

        return convertedBonusNumber <= StaticFinalMessages.MAXIMUM_LOTTO_NUMBER
                && convertedBonusNumber >= StaticFinalMessages.MINIMUM_LOTTO_NUMBER;
    }

    private boolean validateIsOverlapWithWinningNumber(String bonusNumber, List<Integer> seperatedLottoWinningNumbers) {
        int convertedBonusNumber = Integer.parseInt(bonusNumber);

        boolean isOverlapWithWinningNumbers = seperatedLottoWinningNumbers.stream().anyMatch(lottoWinningNumber ->
                convertedBonusNumber == lottoWinningNumber
        );

        return !isOverlapWithWinningNumbers;
    }
}
