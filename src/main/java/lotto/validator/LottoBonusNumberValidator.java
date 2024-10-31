package lotto.validator;

import java.util.List;
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

    public void validateBonusNumber(String bonusNumber, List<Integer> lottoWinningNumbers) {
        validateDigit(bonusNumber);

        int number = LottoParser.parseInt(bonusNumber);
        validateMoreThanLottoNumberMin(number);
        validateLessThanLottoNumberMax(number);
        validateDuplicationNumber(number, lottoWinningNumbers);
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

    private void validateDuplicationNumber(int bonusNumber, List<Integer> winningNumbers){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }


}
