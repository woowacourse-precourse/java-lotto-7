package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.constants.ErrorMessages;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
    void lottoNumbersSizeNotSix() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_COUNT);
    }

    @Test
    @DisplayName("로또 번호에 중복된 값이 있는 경우 예외가 발생한다.")
    void lottoNumbersContainDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어나는 경우 예외가 발생한다.")
    void lottoNumbersOutOfRange() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    @DisplayName("로또 번호가 정상적으로 생성된다.")
    void createLottoSuccessfully() {
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호에 문자열이 포함된 경우 예외가 발생한다.")
    void lottoNumbersContainString() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, Integer.parseInt("a"))))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("로또 번호에 음수가 포함된 경우 예외가 발생한다.")
    void lottoNumbersContainNegative() {
        List<Integer> numbers = Arrays.asList(-1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
    }
}
