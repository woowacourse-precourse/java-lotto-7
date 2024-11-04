package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @DisplayName("로또 번호의 개수가 6개일 때 예외가 발생하지 않는다.")
    @Test
    void 로또_번호의_개수가_6개일_때_예외가_발생하지_않는다() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> LottoValidator.validateNumberCount(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호의 개수가 6개가 아닐 때 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_아닐_때_예외가_발생한다() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> LottoValidator.validateNumberCount(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 1부터 45 사이일 때 예외가 발생하지 않는다.")
    @Test
    void 로또_번호가_1부터_45_사이일_때_예외가_발생하지_않는다() {
        List<Integer> validNumbers = List.of(1, 10, 20, 30, 40, 45);
        assertThatCode(() -> LottoValidator.validateNumberRange(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 클 때 예외가 발생한다.")
    @Test
    void 로또_번호가_1보다_작거나_45보다_클_때_예외가_발생한다() {
        List<Integer> invalidNumbers1 = List.of(0, 2, 3, 4, 5, 6);
        List<Integer> invalidNumbers2 = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> LottoValidator.validateNumberRange(invalidNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> LottoValidator.validateNumberRange(invalidNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 중복이 없을 때 예외가 발생하지 않는다.")
    @Test
    void 로또_번호에_중복이_없을_때_예외가_발생하지_않는다() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> LottoValidator.validateNoDuplicates(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 중복이 있을 때 예외가 발생한다.")
    @Test
    void 로또_번호에_중복이_있을_때_예외가_발생한다() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> LottoValidator.validateNoDuplicates(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
    }
}
