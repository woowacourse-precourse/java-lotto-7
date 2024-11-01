package lotto.io.validator.money;

import static java.util.Objects.isNull;
import static lotto.io.exception.EmptyInputException.emptyInput;

public class NullValidator extends InputValidator {

    @Override
    public void check(final String source) {
        if (isNull(source)) {
            throw emptyInput();
        }
        String cleanedSource = source.strip();
        super.check(cleanedSource);
    }
}
