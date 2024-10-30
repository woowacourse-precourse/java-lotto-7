package lotto.domain.lotto;

import static lotto.exception.message.LottoExceptionMessage.DUPLICATE_NUMBER_INPUT;
import static lotto.exception.message.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.message.LottoExceptionMessage.INVALID_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.message.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER_INPUT.getMessage());
    }

    @Test
    @DisplayName("로또 최댓 값을 벗어나는 입력이 들어오면 예외가 발생한다.")
    void givenInputOverNumberInLottoNumbersRange_whenCreated_thenThrowException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("로또 최댓 값을 벗어나는 입력이 들어오면 예외가 발생한다.")
    void givenInputUnderNumberInLottoNumbersRange_whenCreated_thenThrowException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 0);

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_RANGE.getMessage());
    }

}
