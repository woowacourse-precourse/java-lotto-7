package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("PurchasePriceValidator 검증 테스트")
class PurchasePriceValidatorTest {
    private final PurchasePriceValidator validator = new PurchasePriceValidator();

    @DisplayName("로또 구입금액에 숫자가 아닌 문자가 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsNotNumeric() {
        // given
        String input = "abc";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }

    @DisplayName("로또 구입금액에 null이 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsNull() {
        // given
        String input = null;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }

}