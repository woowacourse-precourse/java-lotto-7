package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {

    private final int NORMAL_BONUS = 7;
    private final List<Integer> NORMAL_LIST = List.of(1, 2, 3, 4, 5, 6);
    Bonus bonus = new Bonus(NORMAL_BONUS, NORMAL_LIST);

    @Test
    void 보너스가_중복될_경우_예외발생() {
        assertThatThrownBy(() -> {
            bonus.validateDuplicates(1, List.of(1, 2, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스가_중복되지_않는_경우_통과() {
        bonus.validateDuplicates(45, List.of(1, 2, 3, 4, 5, 6));
    }

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
