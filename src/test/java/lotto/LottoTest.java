package lotto;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.model.domain.Lotto;
import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LottoTest {

    static Stream<List<Integer>> lottoNumberRangeTest() {
        return Stream.of(Arrays.asList(0, 1, 2, 3, 4, 5), // 0 포함
                Arrays.asList(-1, 1, 2, 3, 4, 5), // 음수 포함
                Arrays.asList(1, 2, 3, 4, 5, 50), // 50 포함
                Arrays.asList(1, 2, 3, 4, 5, 46)  // 46 포함
        );
    }

    @Test
    void 로또_번호와_보너스_번호_중복() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 5;
        assertThrows(IllegalArgumentException.class, () -> Validator.validateDuplicateNumber(numbers, bonus));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThrows(IllegalArgumentException.class, () -> Validator.validateDuplicateNumber(numbers));
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개를 초과하면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumberCount(numbers));
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수_미만() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumberCount(numbers));
    }

    @DisplayName("로또 숫자의 범위가 잘못된 경우 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("lottoNumberRangeTest")
    void 로또_번호의_범위_테스트(List<Integer> testNumber) {
        assertThatThrownBy(() -> {
            for (Integer number : testNumber) {
                Validator.validateRange(number);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
