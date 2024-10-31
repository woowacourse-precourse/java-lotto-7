package lotto.validator;

import java.util.regex.Pattern;
import lotto.domain.WinningLotto;
import lotto.error.LottoError;
import lotto.util.LottoParser;

public class LottoBonusNumberValidator {

    private static final String LOTTO_BONUS_NUMBER_PATTERN_TEXT = "^\\d+$";
    private static final Pattern LOTTO_BONUS_NUMBER_PATTERN = Pattern.compile(LOTTO_BONUS_NUMBER_PATTERN_TEXT);
    private final LottoNumberValidator lottoNumberValidator;

    public LottoBonusNumberValidator(LottoNumberValidator lottoNumberValidator) {
        this.lottoNumberValidator = lottoNumberValidator;
    }

    public void validateBonusNumber(String bonusNumber, WinningLotto winningLotto) {
        validateDigit(bonusNumber);
        int number = LottoParser.parseInt(bonusNumber);

        lottoNumberValidator.validateLottoNumber(number);
        validateDuplicationNumber(number, winningLotto);
    }

    private void validateDigit(String bonusNumber) {
        if (!LOTTO_BONUS_NUMBER_PATTERN.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException(LottoError.LOTTO_BONUS_NUMBER_INVALID_FORMAT.getMessage());
        }
    }

    private void validateDuplicationNumber(int bonusNumber, WinningLotto winningLotto) {
        if (winningLotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException(LottoError.LOTTO_BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }


}
