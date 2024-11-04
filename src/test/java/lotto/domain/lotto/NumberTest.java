package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또_번호는")
class NumberTest {

    @Test
    void 범위가_1부터_45_사이가_아닐_경우_예외를_반환한다() {
        assertThatThrownBy(() -> new Number(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
