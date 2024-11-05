package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountValidatorTest {

    @ParameterizedTest
    @DisplayName("구입 금액이 정수가 아니면 예외를 발생한다.")
    @ValueSource(strings = {"a", "?", "1.3", "가", "1a"})
    void amountTest1(String amount) {
        Validator validator = new AmountValidator();

        assertThatThrownBy(() -> validator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외를 발생한다.")
    void amountTest2() {
        Validator validator = new AmountValidator();
        String amount = "8600";

        assertThatThrownBy(() -> validator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}