package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @ParameterizedTest
    @CsvSource({"1000", "10000", "123000"})
    void 천원_단위로_입력될_경우_정상적으로_객체가_생성된다(int input) {
        new Money(input);
    }

    @ParameterizedTest
    @CsvSource({"1001", "10300", "120"})
    void 천원_단위로_입력되지_않을_경우_예외가_발생한다(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_MONEY_INPUT.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"-11", "-1300", "-12123"})
    void 음수가_입력될_경우_예외가_발생한다(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_MONEY_INPUT.getMessage());
    }

    @Test
    void 숫자0_입력될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_MONEY_INPUT.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1000,1", "13000,13", "120000,120"})
    void 입력된_돈에_따라_알맞은_quantity가_반환된다(int input, int expected) {
        Money money = new Money(input);
        assertThat(money.getQuantity()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1000,1000", "13000,13000", "120000,120000"})
    void 입력된_돈에_따라_알맞은_money가_반환된다(int input, int expected) {
        Money money = new Money(input);
        assertThat(money.getMoney()).isEqualTo(expected);
    }
}
