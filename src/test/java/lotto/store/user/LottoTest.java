package lotto.store.user;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호의_개수가_맞다면_예외가_발생하지_않는다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> Lotto.from(numbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨_번호의_개수가_맞지_않으면_예외가_발생한다(String value) {
        List<Integer> numbers = Arrays.stream(value.split(","))
            .map(Integer::parseInt)
            .toList();

        assertThatThrownBy(() -> Lotto.from(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 당첨_번호의_범위가_맞으면_예외가_발생하지_않는다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);

        assertDoesNotThrow(() -> Lotto.from(numbers));
    }

    @Test
    void 당첨_번호의_범위가_맞지_않으면_예외가_발생하지_않는다() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> Lotto.from(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호가_중복되지_않으면_예외가_발생하지_않는다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> Lotto.from(numbers));
    }

    @Test
    void 당첨_번호가_중복되면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 2, 4, 5, 5);

        assertThatThrownBy(() -> Lotto.from(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
    }

    @Test
    void 당첨_번호에_보너스_번호가_중복되지_않으면_예외가_발생하지_않는다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = Lotto.from(numbers);

        //when & then
        assertDoesNotThrow(() -> winningNumbers.validateDuplicateByBonusNumber(7));
    }

    @Test
    void 당첨_번호에_보너스_번호가_중복되어_있으면_예외가_발생한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = Lotto.from(numbers);

        //when & then
        assertThatThrownBy(() -> winningNumbers.validateDuplicateByBonusNumber(6))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호에 포함되어 있는 숫자입니다.");
    }
}
