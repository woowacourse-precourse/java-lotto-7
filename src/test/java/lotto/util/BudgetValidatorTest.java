package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import lotto.util.validator.BudgetValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
class BudgetValidatorTest {
    private BudgetValidator budgetValidator;
    @BeforeEach
    void setUp() {
        budgetValidator = new BudgetValidator();
    }
    @Nested
    class invalidInput {
        @DisplayName("정수가 아닌 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"하이", "burpee", "   안 녕 하  시  렵 니 까   ","1.1234","-10", "-1 2 3"})
        void 정수_아닌_입력(String input) {
            assertThatThrownBy(() -> budgetValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
        @DisplayName("구매 입력 범위를 초과한 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"100001","0"})
        void 구매범위를_벗어난_입력(String input) {
            assertThatThrownBy(() -> budgetValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_OUT_OF_BUDGET_RANGE.getMessage());
        }
        @DisplayName("로또의 가격으로 나누어 떨어지지 않는 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"7777", "1234", "1001"})
        void 숫자가_아닌_입력(String input) {
            assertThatThrownBy(() -> budgetValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_UNIT_OF_BUDGET.getMessage());
        }
    }
    @Nested
    class validInput {
        @ParameterizedTest
        @ValueSource(strings = {"100000", "1000", " 1   0    0  0  0  "})
        void 정상_입력(String input) {
            assertThatCode(() -> budgetValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}