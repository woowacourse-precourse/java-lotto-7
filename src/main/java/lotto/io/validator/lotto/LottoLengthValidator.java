package lotto.io.validator.lotto;

import static lotto.exception.InvalidRangeException.invalidLottoLength;
import static lotto.io.error.ErrorMessage.INVALID_LOTTO_LENGTH_RANGE;

import java.util.List;
import java.util.Set;
import lotto.io.preprocessor.IOPreprocessor;
import lotto.io.validator.InputValidator;
import lotto.model.lotto.Lotto;

public class LottoLengthValidator extends InputValidator {

    private LottoLengthValidator() {
    }

    public static LottoLengthValidator initiate() {
        return new LottoLengthValidator();
    }

    @Override
    public void check(final String source) {
        List<String> sources = IOPreprocessor.stringToListString(source);
        if (sources.size() != Lotto.MAX_NUMBER_COUNT) {
            throw invalidLottoLength(INVALID_LOTTO_LENGTH_RANGE);
        }

        Set<String> uniqueSources = IOPreprocessor.stringToSetString(source);
        if (sources.size() != uniqueSources.size()) {
            throw invalidLottoLength(INVALID_LOTTO_LENGTH_RANGE);
        }

        super.check(source);
    }
}
