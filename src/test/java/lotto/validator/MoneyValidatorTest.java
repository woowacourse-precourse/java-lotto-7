package lotto.validator;

import lotto.Exception.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.utils.LottoRules.LOTTO_PRICE;
import static lotto.utils.LottoRules.MAX_LOTTO_PURCHASE_COUNT;
import static org.junit.jupiter.api.Assertions.*;

class MoneyValidatorTest {
    private final MoneyValidator validator = new MoneyValidator();

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - 빈값")
    @EmptySource
    void empty(String empty) {
        assertThrows(MoneyException.class, () -> {
            validator.validate(empty);
        });
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 예외 - NAN")
    @ValueSource(strings = {"12s", "1..2", "300s"})
    void nan(String notANumberText) {
        assertThrows(MoneyException.class, () -> {
            validator.validate(notANumberText);
        });
    }

    @Test
    @DisplayName("구매 금액 예외 - 범위 초과")
    void range() {
        assertThrows(MoneyException.class, () -> {
            validator.validate(String.valueOf(LOTTO_PRICE * (MAX_LOTTO_PURCHASE_COUNT + 1)));
        });
        assertThrows(MoneyException.class, () -> {
            validator.validate(String.valueOf(0));
        });
    }

    @Test
    @DisplayName("구매 금액 예외 - 단위 불일치")
    void unit() {
        assertThrows(MoneyException.class, () -> {
            validator.validate(String.valueOf(LOTTO_PRICE - ((float) LOTTO_PRICE / 3)));
        });
    }
}