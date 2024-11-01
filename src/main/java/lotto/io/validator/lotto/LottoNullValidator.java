package lotto.io.validator.lotto;

import static java.util.Objects.isNull;
import static lotto.io.exception.EmptyInputException.emptyLottoNumbers;

import java.util.List;
import java.util.Objects;
import lotto.io.preprocessor.IOPreprocessor;
import lotto.io.validator.InputValidator;

public class LottoNullValidator extends InputValidator {

    private LottoNullValidator() {
    }

    public static LottoNullValidator initiate() {
        return new LottoNullValidator();
    }

    @Override
    public void check(final String source) {
        if (isNull(source)) {
            throw emptyLottoNumbers();
        }
        List<String> sources = IOPreprocessor.stringToListString(source);
        validateEachString(sources);
        super.check(source);
    }

    private void validateEachString(final List<String> source) {
        boolean anyMatched = source.stream()
                .anyMatch(Objects::isNull);
        if (anyMatched) {
            throw emptyLottoNumbers();
        }
    }
}
