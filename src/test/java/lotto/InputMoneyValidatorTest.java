package lotto;

import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputMoneyValidatorTest {
    
    @DisplayName("1000원 단위의 돈이 아닐경우 예외처리")
    @Test
    void getMoneyThousandUnit() {
        String money = "10800";

        assertThatThrownBy(() -> new InputMoneyValidator()
                .validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getMoneyOnlyNumber() {
        String money = "1000j";

        assertThatThrownBy(() -> new InputMoneyValidator()
                .validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}