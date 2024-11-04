package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private static final List<Integer> FIVE_NUMBER = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> DUPLICATED_NUMBER = Arrays.asList(1, 1, 2, 3, 4, 5);
    private static final List<Integer> OUT_OF_RANGE = Arrays.asList(1, 2, 3, 4, 5, 46);

    @BeforeEach
    void setUp() {
        WinningNumbers.resetWinningNumbers();
    }

    @Test
    void 번호가_6개가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.initialInstance(FIVE_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_번호가_있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.initialInstance(DUPLICATED_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위를_벗어난_번호가_있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.initialInstance(OUT_OF_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
