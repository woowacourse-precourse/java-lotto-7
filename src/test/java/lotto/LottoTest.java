package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.utils.LottoErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void ThrowExceptionWhenLottoNumberCountOverSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INVALID_LOTTO_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void ThrowExceptionWhenDuplicateLottoNumbersExist() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void throwsExceptionIfLottoNumberIsOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 51)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INVALID_LOTTO_NUMBER_IN_RANGE.getMessage());

    }
}
