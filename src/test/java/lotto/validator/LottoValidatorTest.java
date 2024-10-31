package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "jewan", "1 2", "1234"})
    void 로또_구입_금액_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateInputMoney(inputString));
    }
}
