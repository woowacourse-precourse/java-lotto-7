package lotto.domain;

import java.util.Arrays;
import lotto.global.message.ErrorMessage;
import lotto.global.message.OutputMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoByInvalidSize() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        String expectedErrorMessage = String.format(
                OutputMessage.ERROR_FORMAT,
                ErrorMessage.INVALID_LOTTO_SIZE
        );

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createLottoByInvalidNumber(int invalidNumber) {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, invalidNumber);
        String expectedErrorMessage = String.format(
                OutputMessage.ERROR_FORMAT,
                ErrorMessage.INVALID_LOTTO_NUMBER_RANGE
        );

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicateNumber() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 5);
        String expectedErrorMessage = String.format(
                OutputMessage.ERROR_FORMAT,
                ErrorMessage.DUPLICATE_LOTTO_NUMBER
        );

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("유효한 로또 번호로 로또를 생성한다.")
    @Test
    void createValidLotto() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = Lotto.from(numbers);

        // then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}