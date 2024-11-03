package lotto.io.validator.lotto;

import static lotto.io.error.ErrorMessage.INVALID_LOTTO_LENGTH_RANGE;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.InvalidRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoLengthValidatorTest {

    private final LottoLengthValidator validator = LottoLengthValidator.initiate();

    @ParameterizedTest
    @DisplayName("중복되는 로또 번호 포함")
    @CsvSource({"1,1,2,3,4,5", "1,2,2,3,4,6", "5,5,6,7,8,9"})
    void duplicatedNumberIncludedCase1() {
        // given
        String source = "1,1,2,3,4,5";

        // when & then
        assertThrows(
                InvalidRangeException.class,
                () -> validator.check(source),
                INVALID_LOTTO_LENGTH_RANGE
        );
    }

    @ParameterizedTest
    @DisplayName("6개보다 적거나 많은 수를 입력하는 경우")
    @CsvSource({"1,1,3,4,5,6,7", "1,2,2,3,4,6,7,8"})
    void lowerThanDefaultLottoLength() {
        // given
        String source = "1,2,3,4,5";

        // when & then
        assertThrows(
                InvalidRangeException.class,
                () -> validator.check(source),
                INVALID_LOTTO_LENGTH_RANGE
        );
    }

}
