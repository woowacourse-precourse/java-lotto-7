package lotto.model.ticket;

import lotto.message.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 객체 테스트")
class LottoTest {

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenLottoNumbersCountLessThan6() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.LOTTO_NUMBERS_COUNT.get());
    }

    @DisplayName("로또 번호의 개수가 6개보다 크면 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenLottoNumbersCountGreaterThan6() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.LOTTO_NUMBERS_COUNT.get());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenLottoNumbersDuplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.LOTTO_NUMBERS_DUPLICATE.get());
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenLottoNumbersOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.get());
    }
}
