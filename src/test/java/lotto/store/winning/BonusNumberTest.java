package lotto.store.winning;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 보너스_번호의_범위가_맞으면_예외가_발생하_않는다(int value) {
        assertDoesNotThrow(() -> BonusNumber.from(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호의_범위가_맞지_않으면_예외가_발생한다(int value) {
        assertThatThrownBy(() -> BonusNumber.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
