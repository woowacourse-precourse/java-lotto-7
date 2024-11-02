package lotto.model;

import static lotto.constant.ErrorMessage.NEGATIVE_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("== Money 테스트 ==")
public class MoneyTest {
    @Nested
    @DisplayName("-- 기능 테스트 --")
    class FeatureTest {
        @ParameterizedTest
        @DisplayName("수익률")
        @MethodSource("earningRateArguments")
        void 수익률(int investedMoney, int earnedMoney, double earningRate) {
            Money invested = new Money(investedMoney);
            Money earned = new Money(earnedMoney);

            assertThat(invested.getEarningRate(earned)).isEqualTo(earningRate);
        }

        static Stream<Arguments> earningRateArguments() {
            return Stream.of(
                    Arguments.of(1000, 5000, 500),
                    Arguments.of(8000, 5000, 62.5),
                    Arguments.of(10000, 5000, 50),
                    Arguments.of(10000, 0, 0)
            );
        }
    }

    @Nested
    @DisplayName("-- 예외 테스트 --")
    class ExceptionTest {
        @ParameterizedTest
        @DisplayName("음수")
        @ValueSource(ints = {-1, -42, -333})
        void 수익률(int money) {
            assertThatThrownBy(() -> new Money(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEGATIVE_MONEY.getMessage());
        }
    }
}
