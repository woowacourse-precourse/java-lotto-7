package lotto.domain;

import lotto.exception.money.DivideMoneyException;
import lotto.exception.money.MaximunMoneyException;
import lotto.exception.money.ZeroMoneyException;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("구입 금액 검증")
class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {1_000, 100_000})
    @DisplayName("1,000원으로 나누어 떨어지는지")
    void validMoney(int inputMoney) {
        assertThat(Money.from(inputMoney)).isInstanceOf(Money.class);
    }

    @ParameterizedTest(name = "{index} : {3}")
    @MethodSource("generateExceptionData")
    @DisplayName("예외 검증")
    void invalidMoney(int inputMoney, Class expectedExceptionClass, String errorMessage, String message) {
        assertThatThrownBy(() -> {
            Money.from(inputMoney);
        }).isInstanceOf(expectedExceptionClass)
                .hasMessage(errorMessage);
    }

    static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of(0, ZeroMoneyException.class,
                        ErrorMessage.PURCHASE_MONEY_MINIMUM, "0원일 때"),
                Arguments.of(100, DivideMoneyException.class,
                        ErrorMessage.PURCHASE_MONEY_DIVIDE, "1,000원으로 나누어 떨어지지 않을 때"),
                Arguments.of(1_001, DivideMoneyException.class,
                        ErrorMessage.PURCHASE_MONEY_DIVIDE, "1,000원으로 나누어 떨어지지 않을 때"),
                Arguments.of(100_001, MaximunMoneyException.class,
                        ErrorMessage.PURCHASE_MONEY_MAXIMUM, "100,000원 이상일 때"),
                Arguments.of(200_000, MaximunMoneyException.class,
                        ErrorMessage.PURCHASE_MONEY_MAXIMUM, "100,000원 이상일 때")
        );
    }
}