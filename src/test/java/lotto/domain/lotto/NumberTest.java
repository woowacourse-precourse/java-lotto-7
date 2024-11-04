package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또_번호는")
class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 46, 100})
    void 범위가_1부터_45_사이가_아닐_경우_예외를_반환한다(int number) {
        assertThatThrownBy(() -> new Number(number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
