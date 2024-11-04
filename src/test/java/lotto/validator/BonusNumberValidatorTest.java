package lotto.validator;

import lotto.common.ErrorMessage;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class BonusNumberValidatorTest {
    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 공백을_입력하면_예외_발생(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.BLANK_OR_NULL_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1000000000000000000000000000"})
    void 오버플로우이거나_문자를_입력하면_예외_발생(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER_TYPE);
    }
}