package lotto.unit;

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
}
