package lotto.domain.model;

import lotto.domain.model.LottoNumbers;
import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class LottoNumbersTest {

    @DisplayName("로또 번호가 6개가 아닐 때 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenLottoNumbersCountIsInvalid() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있을 때 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenLottoNumbersContainDuplicates() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_WINNING_NUMBER);
    }

    @DisplayName("로또 번호가 1~45의 범위를 벗어날 때 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenLottoNumbersAreOutOfRange() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER_RANGE);

        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER_RANGE);
    }

    @DisplayName("로또 번호가 올바를 때 객체가 정상적으로 생성된다.")
    @Test
    void shouldCreateLottoNumbersWhenInputIsValid() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        assertThat(lottoNumbers.getNumbers()).isEqualTo(numbers);
    }
}
