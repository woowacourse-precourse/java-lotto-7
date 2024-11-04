package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceValidatorTest {

    @Test
    @DisplayName("입력 안했을 때")
    void noInputTest() {
        assertThat(PurchasePriceValidator.validate("")).isFalse();
    }

    @Test
    @DisplayName("공백을 입력했을 때")
    void blankInputTest() {
        assertThat(PurchasePriceValidator.validate(" ")).isFalse();
    }

    @Test
    @DisplayName("1000원보다 낮은 가격 입력했을 때")
    void lowerThanAtLeastTest() {
        assertThat(PurchasePriceValidator.validate("900")).isFalse();
    }

    @Test
    @DisplayName("int 자료형 범위 밖의 값을 입력했을 때")
    void overflowTest() {
        assertThat(PurchasePriceValidator.validate("10000000000")).isFalse();
    }

    @Test
    @DisplayName("1000으로 나눠지지 않는 수 입력했을 때")
    void cantBeDividedTest() {
        assertThat(PurchasePriceValidator.validate("1500")).isFalse();
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력했을 때")
    void notANumberTest() {
        assertThat(PurchasePriceValidator.validate("1,")).isFalse();
    }
    @Test
    @DisplayName("똑바로 된 값을 입력했을 때")
    void validateTest() {
        assertThat(PurchasePriceValidator.validate("1000")).isTrue();
    }
}