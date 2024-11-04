package lotto.util;

import lotto.util.validator.BonusValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusValidatorTest {
    private BonusValidator validator;

    @BeforeEach
    void setUp() {
        validator = new BonusValidator();
    }

    @Nested
    @DisplayName("정상 입력 테스트")
    class ValidInputTests {

        @Test
        @DisplayName("올바른 보너스 번호를 입력하면 해당 숫자를 반환한다")
        void validateValidBonusNumber() {
            assertThat(validator.validate("45")).isEqualTo(45);
            assertThat(validator.validate("1")).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("비정상 입력 테스트")
    class InvalidInputTests {

        @Test
        @DisplayName("보너스 번호가 1-45 범위를 벗어나면 예외가 발생한다")
        void validateBonusNumberRange() {
            assertThatThrownBy(() -> validator.validate("46"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage());

            assertThatThrownBy(() -> validator.validate("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage());
        }

        @Test
        @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다")
        void validateNonNumericBonusNumber() {
            assertThatThrownBy(() -> validator.validate("abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}