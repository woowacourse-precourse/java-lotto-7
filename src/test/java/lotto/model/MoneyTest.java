package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.Constants;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    private final long NORMAL_INPUT = Constants.LOTTO_PRICE.getLong();
    Money money = new Money(NORMAL_INPUT);

    @ParameterizedTest
    @ValueSource(longs = {100000000000000L, 0, -1, -1929310})
    void 설정범위를_벗어날_경우_예외발생(long input) {
        assertThatThrownBy(() -> {
            money.validateRange(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(longs = {1000000000, 1, 2891201})
    void 설정범위일_경우_통과(long input) {
        money.validateRange(input);
    }

    @ParameterizedTest
    @ValueSource(longs = {1234, 1001, 102939100, 1, 200})
    void 거스름돈이_남는_경우_예외발생(long input) {
        assertThatThrownBy(() -> {
            money.validateNoRemainder(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(longs = {1000, 13289321000L, 100000})
    void 거스름돈이_없는_경우_통과(long input) {
        money.validateNoRemainder(input);
    }
}
