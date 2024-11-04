package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @DisplayName("보너스 번호는 1~45 사이의 양의 정수여야 하며 당첨 번호와 중복되선 안 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1", "46", "5"})
    void validateBonusNumber(String bonusNumber) {
        String winningNumber = "1,2,3,4,5,6";

        assertThatThrownBy(() -> {
            BonusNumberValidator.validateBonusNumber(winningNumber, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}