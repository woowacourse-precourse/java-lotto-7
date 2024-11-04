package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    private final NumberValidator validator = new NumberValidator();

    @DisplayName("로또 번호가 중복되지 않으면 예외가 발생하지 않는다")
    @Test
    void 로또_번호가_중복되지_않으면_예외가_발생하지_않는다() {
        assertThatCode(() -> validator.checkNumberDuplicated(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 1~45 사이이면 예외가 발생하지 않는다")
    @Test
    void 로또_번호가_1에서_45사이_일_때_예외가_발생하지_않는다() {
        assertThatCode(() -> validator.checkNumberRange(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 6개면 예외가 발생하지 않는다")
    @Test
    void 로또_번호가_6개면_예외가_발생하지_않는다() {
        assertThatCode(() -> validator.checkNumberSize(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않으면 예외가 발생하지 않는다")
    @Test
    void 보너스_번호가_당첨_번호와_중복되지_않으면_예외가_발생하지_않는다() {
        assertThatCode(() -> validator.checkNumberDuplicatedWithWinningNumber(10, List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 중복되면 예외가 발생한다")
    @Test
    void 로또_번호가_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.checkNumberDuplicated(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void 로또_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.checkNumberSize(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다")
    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.checkNumberRange(List.of(1, 2, 3, 4, 5, 1000000)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다")
    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.checkNumberRange(List.of(-2, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.checkNumberDuplicatedWithWinningNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}