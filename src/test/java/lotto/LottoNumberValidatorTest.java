package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.validators.LottoNumberValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberValidatorTest {
    private final LottoNumberValidator validator = new LottoNumberValidator();

    @DisplayName("로또 번호의 갯수가 6이 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,6,7"})
    void 로또_번호_갯수_검증_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.checkArraySize(List.of(input.split(","))));
    }

    @DisplayName("로또 번호 중 중복되는 숫자가 있으면 예외를 발생시킨다.")
    @Test
    void 중복_번호_검증_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> validator.checkDuplicate("1,2,3,4,5,5"));
    }

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,60"})
    void 번호_범위_검증_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.checkValueRange(input));
    }
}
