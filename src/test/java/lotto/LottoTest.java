package lotto;

import lotto.exception.LottoException;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    void shouldThrowExceptionWhenLottoNumbersExceedSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoException.INVALID_COUNT.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 이하이면 예외가 발생한다")
    void throwsExceptionWhenLottoNumbersAreLessThanSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoException.INVALID_COUNT.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void shouldThrowExceptionWhenLottoNumbersAreDuplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoException.DUPLICATE_LOTTO_NUMBER.getMessage());
    }


}
