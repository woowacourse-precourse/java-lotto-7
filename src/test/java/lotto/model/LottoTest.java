package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBERS_DUPLICATED_NUMBER.getMessage());
    }

    @Test
    @DisplayName("입력값을 가진 객체가 생성된다.")
    void testCreateLottoIfNumbersAreValid() {
        List<Integer> numbers = List.of(new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또 번호가 6개보다 작으면 예외가 발생한다.")
    void testThrowExceptionIfListSizeIsLessThanSix() {
        List<Integer> invalidSizeNumbers = List.of(new Integer[]{1, 2, 3, 4, 5});
        assertThatThrownBy(() -> new Lotto(invalidSizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideOutOfLottoRangeNumbers")
    @DisplayName("로또 범위가 아닌 수가 있으면 예외가 발생한다.")
    void testThrowExceptionIfListHasOutOfLottoRangeNumber(List<Integer> invalidRangeNumbers) {
        assertThatThrownBy(() -> new Lotto(invalidRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBERS_INVALID_RANGE.getMessage());
    }

    private static Stream<List<Integer>> provideOutOfLottoRangeNumbers() {
        List<Integer> hasLessThanMin = List.of(new Integer[]{Rule.MIN_LOTTO_NUMBER - 1, 1, 2, 3, 4, 5});
        List<Integer> hasGreaterThanMax = List.of(new Integer[]{Rule.MAX_LOTTO_NUMBER + 1, 1, 2, 3, 4, 5});
        return Stream.of(hasLessThanMin, hasGreaterThanMax);
    }
}
