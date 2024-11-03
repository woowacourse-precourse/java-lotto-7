package lottoBonusNumber;

import java.util.List;
import utils.StaticFinalMessages;

public class LottoBonusNumberValidator {
    private final static String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_BONUS_NUMBER = "로또 보너스 번호로 1부터 45까지, 전에 입력한 로또 당첨 번호 6개와 중복되지 않는 숫자 한개를 입력해주세요";
    private final static IllegalArgumentException EXCEPTION_LOTTO_BONUS_NUMBER = new IllegalArgumentException(
            StaticFinalMessages.ERROR_TEXT_INFRONT_OF_DETAILS + RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_BONUS_NUMBER);

    public void validateAllThing(String bonusNumber, List<Integer> seperatedLottoWinningNumbers) {
        validateIsNumeric(bonusNumber);
        validateRangeOfNumbersGreaterThan1AndLessThan45(bonusNumber);
        validateIsOverlapWithWinningNumber(bonusNumber, seperatedLottoWinningNumbers);
    }

    // number format exception 말고 또 다른 것도 있나?
    private void validateIsNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException numberFormatException) {
            throw EXCEPTION_LOTTO_BONUS_NUMBER;
        }
    }

    private void validateRangeOfNumbersGreaterThan1AndLessThan45(String bonusNumber) {
        int convertedBonusNumber = Integer.parseInt(bonusNumber);

        if (convertedBonusNumber > StaticFinalMessages.MAXIMUM_LOTTO_NUMBER || convertedBonusNumber < StaticFinalMessages.MINIMUM_LOTTO_NUMBER) {
            throw EXCEPTION_LOTTO_BONUS_NUMBER;
        }
    }

    private void validateIsOverlapWithWinningNumber(String bonusNumber, List<Integer> seperatedLottoWinningNumbers) {
        int convertedBonusNumber = Integer.parseInt(bonusNumber);

        boolean isOverlapWithWinningNumbers = seperatedLottoWinningNumbers.stream().anyMatch(lottoWinningNumber ->
            convertedBonusNumber == lottoWinningNumber
        );

        if (isOverlapWithWinningNumbers) {
            throw EXCEPTION_LOTTO_BONUS_NUMBER;
        }
    }
}
