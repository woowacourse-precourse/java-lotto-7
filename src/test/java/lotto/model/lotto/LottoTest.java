package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoErrorStatus;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.LOTTO_NUMBER_DUPLICATED.getMessage());
    }

    @Test
    void 로또_번호_범위_초과시_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 로또_번호_범위_미만시_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }
}
