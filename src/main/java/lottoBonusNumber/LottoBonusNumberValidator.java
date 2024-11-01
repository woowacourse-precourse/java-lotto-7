package lottoBonusNumber;

import convert.SingleStringToNumConverter;
import java.util.List;

public class LottoBonusNumberValidator {
    private final static int MINIMUM_LOTTO_NUMBER = 1;
    private final static int MAXIMUM_LOTTO_NUMBER = 45;
    private final static String ERROR_TEXT_INFRONT_OF_DETAILS = "[ERROR] ";
    private final static String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_BONUS_NUMBER = "로또 보너스 번호로 1부터 45까지, 전에 입력한 로또 당첨 번호 6개와 중복되지 않는 숫자 한개를 입력해주세요";
    private final static IllegalArgumentException EXCEPTION_LOTTO_BONUS_NUMBER = new IllegalArgumentException(ERROR_TEXT_INFRONT_OF_DETAILS + RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_BONUS_NUMBER);

    private final SingleStringToNumConverter stringToIntConverter;

    // 최종적으로 당첨 번호를 갖고오는 컨트롤러?가 필요하다.
    public LottoBonusNumberValidator() {
        stringToIntConverter = new SingleStringToNumConverter();
    }

    public void validateAllThing(String bonusNumber, List<Integer> seperatedLottoWinningNumbers) {
        validateIsNumeric(bonusNumber);
        validateRangeOfNumbersGreaterThan1AndLessThan45(bonusNumber);
        validateIsOverlapWithWinningNumber(bonusNumber, seperatedLottoWinningNumbers);
    }

    // number format exception 말고 또 다른 것도 있나?
    private void validateIsNumeric(String bonusNumber) {
        try {
            stringToIntConverter.convert(bonusNumber);
        } catch (NumberFormatException numberFormatException) {
            throw EXCEPTION_LOTTO_BONUS_NUMBER;
        }
    }

    private void validateRangeOfNumbersGreaterThan1AndLessThan45(String bonusNumber) {
        int convertedBonusNumber = stringToIntConverter.convert(bonusNumber);

        if (convertedBonusNumber > MAXIMUM_LOTTO_NUMBER || convertedBonusNumber < MINIMUM_LOTTO_NUMBER) {
            throw EXCEPTION_LOTTO_BONUS_NUMBER;
        }
    }

    private void validateIsOverlapWithWinningNumber(String bonusNumber, List<Integer> seperatedLottoWinningNumbers) {
        int convertedBonusNumber = stringToIntConverter.convert(bonusNumber);

        boolean isOverlapWithWinningNumbers = seperatedLottoWinningNumbers.stream().anyMatch(lottoWinningNumber ->
            convertedBonusNumber == lottoWinningNumber
        );

        if (isOverlapWithWinningNumbers) {
            throw EXCEPTION_LOTTO_BONUS_NUMBER;
        }
    }
}
