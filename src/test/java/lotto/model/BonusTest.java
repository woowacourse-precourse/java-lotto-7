package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.Constants;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {
    private final int NORMAL_INPUT = Constants.MIN_LOTTO_NUMBER.getNumber();
    Bonus bonus = new Bonus(NORMAL_INPUT);

    @ParameterizedTest
    @ValueSource(ints = {100, 1000000, 0, -1, -1929310})
    void 설정범위를_벗어날_경우_예외발생(int input) {
        assertThatThrownBy(() -> {
            bonus.validateRange(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {45, 1, 22})
    void 설정범위일_경우_통과(int input) {
        bonus.validateRange(input);
    }
}
