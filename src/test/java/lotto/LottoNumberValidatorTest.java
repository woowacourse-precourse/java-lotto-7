package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.validators.LottoNumberValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberValidatorTest {
    private final LottoNumberValidator validator = new LottoNumberValidator();

    @DisplayName("로또 번호가 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"asdf", "1", "1,1,2,3,4,5", "1,2,3,4,5,60"})
    void 로또_번호_입력값_검증_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }
}
