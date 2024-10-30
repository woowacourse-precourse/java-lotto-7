package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.validators.BonusNumberValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberValidatorTest {
    private final BonusNumberValidator validator = new BonusNumberValidator();

    @DisplayName("보너스 번호가 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:1,2,3,4,5,6", "60:1,2,3,4,5,6", "asdf:1,2,3,4,5,6"})
    void 보너스_번호_입력값_검증_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }
}
