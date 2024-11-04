package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private final Validator validator = new Validator();

    @DisplayName("문자를 입력할 경우 예외가 발생한다.")
    @Test
    void 문자를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateCanBeParsedToLong("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수를 입력할 경우 예외가 발생한다.")
    @Test
    void 음수를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePositiveValue(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("너무 큰 수를 입력할 경우 예외가 발생한다.")
    @Test
    void 너무_큰_수를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateCanBeParsedToInteger("9223372036854775807"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateDivisibleBy(1500, 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 가격이 지정된 범위를 넘는 경우 예외가 발생한다.")
    @Test
    void 지정된_범위를_넘는_구매_가격_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateNumberHaveValidRange(1500000, 1000, 1000000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 우승 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_우승_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateIncludeDuplicateNumber(List.of(1, 2, 3, 4, 5), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 우승 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_우승_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateNumberHaveValidRange(50, 1, 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validateNumberHaveValidRange(50, 1, 45))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
