package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.exception.ExceptionMessages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

    @ParameterizedTest
    @MethodSource("amountAndSumOfPrize")
    void 매개변수로_받은_금액을_바탕으로_수익률을_반환한다(int amount, long sumOfPrize, double rateOfReturn) {
        Money money = new Money(amount);
        assertThat(money.calcRateOfReturn(sumOfPrize)).isEqualTo(rateOfReturn);
    }

    static Stream<Arguments> amountAndSumOfPrize() {
        return Stream.of(
                Arguments.of(5000, 5000L, 100.0),
                Arguments.of(5000, 50000L, 1000.0),
                Arguments.of(5000, 1500000L, 30000.0),
                Arguments.of(5000, 30000000L, 600000.0)
        );
    }
}
