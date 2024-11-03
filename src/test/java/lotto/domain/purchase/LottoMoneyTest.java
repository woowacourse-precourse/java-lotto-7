package lotto.domain.purchase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoMoneyTest {
    @ParameterizedTest
    @DisplayName("1000으로 나누어떨어지지 않으면 IllegalArgumentException을 반환하는지 확인")
    @MethodSource("generateInvalidMoneyValue")
    void testThrowIllegalArgumentException(int moneyValue) {
        assertThatThrownBy(() -> LottoMoney.of(moneyValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateInvalidMoneyValue() {
        return Stream.of(
                Arguments.of(1, 10, 100, 1001)
        );
    }

    @ParameterizedTest
    @DisplayName("getMoney를 통해 생성시 사용한 값을 반환하는지 확인")
    @MethodSource("generateValidMoneyValue")
    void getValue(int moneyValue) {
        LottoMoney money = LottoMoney.of(moneyValue);
        int actual = money.getValue();

        assertThat(actual).isEqualTo(moneyValue);
    }

    private static Stream<Arguments> generateValidMoneyValue() {
        return Stream.of(
                Arguments.of(0, 1000, 10000, 20000)
        );
    }

    @Test
    @DisplayName("같은 값으로 생성하면 equals와 hashcode가 같은지 확인")
    void testEqualsAndHashCode() {
        int sameValue = 10000;
        LottoMoney money = LottoMoney.of(sameValue);
        LottoMoney anotherMoney = LottoMoney.of(sameValue);

        assertThat(money)
                .isEqualTo(anotherMoney)
                .hasSameHashCodeAs(anotherMoney);
    }
}