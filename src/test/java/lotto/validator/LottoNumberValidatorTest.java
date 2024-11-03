package lotto.validator;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberValidatorTest {

    @Test
    @DisplayName("로또 번호가 주어진 범위에 있지 않은 경우에 예외가 발생한다")
    void shouldThrowExceptionForInvalidLottoNumberRange() {
        // given
        Set<Integer> invalidNumbers = Set.of(1, 2, 3, 4, 5, 100);

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> LottoNumberValidator.validateRange(invalidNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.INVALID_RANGE.getMessage())
        );

    }

    @Test
    @DisplayName("로또 번호가 6개가 아니라면 예외가 발생한다")
    void shouldThrowExceptionForInvalidLottoCount() {
        // given
        Set<Integer> invalidNumbers = Set.of(1, 2, 3);

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> LottoNumberValidator.validateCount(invalidNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.INVALID_COUNT.getMessage())
        );

    }

}
