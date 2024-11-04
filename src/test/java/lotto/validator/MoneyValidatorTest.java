package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyValidatorTest {
    private final MoneyValidator validator = new MoneyValidator();

    @DisplayName("돈 입력이 올바른 숫자일 때 예외가 발생하지 않는다")
    @Test
    void 돈_입력이_옳바른_숫자일_때_예외가_발생하지_않는다() {
        assertThatCode(() -> validator.validateNumeric("1000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("돈 입력이 1000으로 나누어 떨어질 때 올바르게 작동한다")
    @Test
    void 돈_입력이_로또_가격으로_나누어_떨어지면_예외가_발생하지_않는다() {
        assertThatCode(() -> validator.validateDivideWithLottoPrice(2000, 1000))
                .doesNotThrowAnyException();
    }

    @DisplayName("돈 입력이 숫자가 아니면 예외를 발생한다")
    @Test
    void 돈_입력이_숫자가_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> validator.validateNumeric("notInteger"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 입력이 0 이하면 예외를 발생한다")
    @Test
    void 돈_입력이_0_이하면_예외를_발생한다() {
        assertThatThrownBy(() -> validator.validateNumeric("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈 입력이 2147483647 이상이면 예외를 발생한다")
    @Test
    void 돈_입력이_2147483647_이상이면_예외를_발생한다() {
        assertThatThrownBy(() -> validator.validateNumeric("2111111111111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDivideWithLottoPrice() {
        assertThatThrownBy(() -> validator.validateDivideWithLottoPrice(1001, 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}