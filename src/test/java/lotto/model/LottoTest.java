package lotto.model;

import lotto.utils.LottoRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 MAX 보다 큰 숫자가 들어오면 예외가 발생한다.")
    void inValidRangeNumbersTest() {
        List<Integer> numbers = LottoRules.pickRandomNumbers();
        numbers.set(0, LottoRules.LOTTO_MAX_NUMBER + 1);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 MIN 보다 작은 숫자가 들어오면 예외가 발생한다.")
    void inValidRangeNumbersTest2() {
        List<Integer> numbers = LottoRules.pickRandomNumbers();
        numbers.set(0, LottoRules.LOTTO_MIN_NUMBER - 1);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 빈 값인 경우 처리")
    @EmptySource
    void inValidRangeNumbersTest(List<Integer> empty) {
        assertThatThrownBy(() -> new Lotto(empty))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
