package lotto.domain.lotto;

import lotto.global.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBER_INPUT.getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { 46, 100, 20000 })
    void should_ThrowException_When_OutOfLottoRange(int invalidNumber) {
        // given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        numbers.add(invalidNumber);

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
    }

    @DisplayName("로또 번호가 0 또는 음수일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1 })
    void should_ThrowException_When_ZeroOrNegativeNumber(int invalidNumber) {
        // given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        numbers.add(invalidNumber);

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NEGATIVE_NUMBER.getMessage());
    }

    @DisplayName("로또 번호 리스트는 불변이어야 한다")
    @Test
    void should_ThrowException_When_TryingToModifyLottoNumbers() {
        // given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.from(numbers);
        List<Integer> lottoNumbers = lotto.getNumbers();

        // when & then
        assertThatThrownBy(() -> lottoNumbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoNumbers.set(0, 10))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
