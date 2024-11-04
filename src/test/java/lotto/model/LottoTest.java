package lotto.model;

import static lotto.common.ErrorMessage.LOTTO_NUMBERS_MUST_SIX;
import static lotto.common.ErrorMessage.LOTTO_NUMBER_DISTINCT;
import static lotto.common.ErrorMessage.LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_MUST_SIX.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DISTINCT.getMessage());
    }

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또 번호는 오름차순으로 생성된다.")
    @Test
    void 로또_번호는_오름차순_이다() {
        Lotto lotto = new Lotto(List.of(13, 1, 14, 4, 2, 6));
        assertThat(lotto.getNumbers())
                .containsExactly(1, 2, 4, 6, 13, 14);
    }
}
