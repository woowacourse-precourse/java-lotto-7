package lotto.domain;

import lotto.TestConstants;
import lotto.constants.ErrorMessageConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final List<Integer> INVALID_LOTTO_SIZE_EXCEEDS = List.of(1, 2, 3, 4, 5, 6, 7);
    private static final List<Integer> OUT_OF_RANGE_LOW = List.of(0, 2, 3, 4, 5, 6);

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(INVALID_LOTTO_SIZE_EXCEEDS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_COUNT);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(TestConstants.DUPLICATE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_DUPLICATE);
    }

    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(OUT_OF_RANGE_LOW))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.INVALID_WINNING_NUMBER_RANGE);
    }
}
