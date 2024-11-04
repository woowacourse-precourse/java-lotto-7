package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("invalidInputSource")
    void 로또_번호에_1미만_45초과_숫자가_있으면_예외가_발생한다(List<Integer> candidate) {
        assertThatThrownBy(() -> new Lotto(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
    }

    private static Stream<Arguments> invalidInputSource() {
        return Stream.of(
                Arguments.of(List.of(-1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(46, 1, 2, 3, 4, 5))
        );
    }

    @Test
    void 입력받은_숫자가_로또번호에_존재하면_True를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertTrue(lotto.haveNumber(1));
        assertTrue(lotto.haveNumber(2));
        assertTrue(lotto.haveNumber(3));
        assertTrue(lotto.haveNumber(4));
        assertTrue(lotto.haveNumber(5));
    }

    @Test
    void 입력받은_숫자가_로또번호에_존재하지_않으면_False를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertFalse(lotto.haveNumber(7));
        assertFalse(lotto.haveNumber(45));
    }
}
