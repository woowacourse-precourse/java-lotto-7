package lotto.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberValidatorTest {
    private final BonusNumberValidator validator = new BonusNumberValidator();

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외를 발생시킨다.")
    @Test
    void 보너스_번호_중복_검증_예외_테스트() {
        final String BONUS = "1";
        final String LOTTO = "1,2,3,4,5,6";
        assertThrows(IllegalArgumentException.class, () -> validator.checkDuplicate(BONUS, LOTTO));
    }

    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 번호_범위_검증_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.checkValueRange(input));
    }
}
