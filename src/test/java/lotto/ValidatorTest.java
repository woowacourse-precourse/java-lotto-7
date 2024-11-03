package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "1234,", "12345", "-1"})
    void 구입_금액_예외_테스트(String string) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1,2,3,4,5,5", "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "0,1,2,3,4,5", "-1,2,3,4,5,6"})
    void 당첨_번호_예외_테스트(String string) {
        assertThatThrownBy(() -> validator.validateWinningNumbers(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "0", "46", "13,", "1", "-1"})
    void 보너스_숫자_예외_테스트(String string) {
        assertThatThrownBy(() -> validator.validateBonusNumber(string, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}