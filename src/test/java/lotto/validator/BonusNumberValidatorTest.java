package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final Lotto mockWinningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private BonusNumberValidator validator;

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void bonusNumberOutOfRangeTest(int value) {
        validator = new BonusNumberValidator(mockWinningNumbers, value);

        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void bonusNumberDuplicatedTest() {
        validator = new BonusNumberValidator(mockWinningNumbers, 1);

        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}