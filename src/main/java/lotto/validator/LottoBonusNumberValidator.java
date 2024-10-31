package lotto.validator;

import java.util.regex.Pattern;
import lotto.util.LottoParser;

public class LottoBonusNumberValidator {

    private static final String LOTTO_BONUS_NUMBER_PATTERN_TEXT = "^\\d+$";
    private static final Pattern LOTTO_BONUS_NUMBER_PATTERN = Pattern.compile(LOTTO_BONUS_NUMBER_PATTERN_TEXT);
    private final int lottoNumberMin;
    private final int lottoNumberMax;

    public LottoBonusNumberValidator(int lottoNumberMin, int lottoNumberMax) {
        this.lottoNumberMin = lottoNumberMin;
        this.lottoNumberMax = lottoNumberMax;
    }

    public void validateBonusNumber(String bonusNumber) {
        validateDigit(bonusNumber);

        int number = LottoParser.parseInt(bonusNumber);
        validateMoreThanLottoNumberMin(number);
        validateLessThanLottoNumberMax(number);
    }

    private void validateDigit(String bonusNumber) {
        if (!LOTTO_BONUS_NUMBER_PATTERN.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoreThanLottoNumberMin(int bounusNumber) {
        if (bounusNumber < lottoNumberMin) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLessThanLottoNumberMax(int bonusNumber) {
        if (bonusNumber > lottoNumberMax) {
            throw new IllegalArgumentException();
        }
    }


}
