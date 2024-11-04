package lotto.io.validator.lotto;

import static lotto.io.error.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.InvalidRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRegexValidatorTest {

    private final LottoRegexValidator validator = LottoRegexValidator.initiate();

    @Test
    @DisplayName("1~45 범위 외의 숫자가 포함")
    void outOfRangeNumberIncluded() {
        // given
        String source = "1,2,3,4,5,67";

        // when & then
        assertThrows(
                InvalidRangeException.class,
                () -> validator.check(source),
                INVALID_LOTTO_NUMBER_RANGE
        );
    }

}
