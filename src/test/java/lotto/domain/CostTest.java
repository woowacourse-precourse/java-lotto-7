package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessages.COST_POSITIVE_INTEGER_ERROR_MESSAGE;

import static lotto.exception.ErrorMessages.DIVISIBLE_BY_THOUSAND_COST_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CostTest {
    @Test
    @DisplayName("구입 금액이 문자일 경우")
    void 로또_구입_금액_TEST(){
        assertThatThrownBy(()-> new Cost("장진영"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COST_POSITIVE_INTEGER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액이 음수일 경우")
    void 로또_구입_금액_TEST2(){
        assertThatThrownBy(()-> new Cost("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COST_POSITIVE_INTEGER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않는 경우")
    void 로또_구입_금액_TEST3(){
        assertThatThrownBy(()-> new Cost("1100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DIVISIBLE_BY_THOUSAND_COST_ERROR_MESSAGE);
    }

}