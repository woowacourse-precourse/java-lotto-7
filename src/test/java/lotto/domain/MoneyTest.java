package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-50000, -100000, -10000})
    void 입력받은_금액이_음수인_경우_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new Money(amount)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.AMOUNT_CANNOT_BE_NEGATIVE_DIGIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {50000, 100000, 10000})
    void 입력받은_금액이_음수가_아닌_경우_예외가_발생하지_않는다(int amount) {
        assertThatCode(() -> new Money(amount)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {55500, 10010, 10001})
    void 입력받은_금액이_로또_가격으로_나누어_떨어지지_않는_경우_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new Money(amount)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.AMOUNT_CANNOT_DIVISIBLE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {55000, 10000, 32000})
    void 입력받은_금액이_로또_가격으로_나누어_떨어지는_경우_예외가_발생하지_않는다(int amount) {
        assertThatCode(() -> new Money(amount)).doesNotThrowAnyException();
    }
}
