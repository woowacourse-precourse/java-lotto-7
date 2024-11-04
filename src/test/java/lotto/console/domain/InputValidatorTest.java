package lotto.console.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("참 | 0 혹은 양수인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "1000", "10000", "100000"})
    void should_ReturnTrue_When_CheckMoneyIsNumeric(String input) {
        assertThat(InputValidator.MONEY.check(input)).isTrue();
    }

    @DisplayName("거짓 | 0 혹은 양수가 아닌 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "a", "1.1", "1,000"})
    void should_ReturnFalse_When_CheckMoneyIsNotNumeric(String input) {
        assertThat(InputValidator.MONEY.check(input)).isFalse();
    }
}