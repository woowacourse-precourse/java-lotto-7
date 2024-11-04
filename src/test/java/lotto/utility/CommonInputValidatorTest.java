package lotto.utility;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommonInputValidatorTest {

    @DisplayName("비어있는 입력값 검증")
    @Test
    public void 비어있는_입력값_검증() {
        String input = " ";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonInputValidator.isBlank(input))
                .withMessage(CommonInputValidator.EMPTY_INPUT);
    }

    @DisplayName("숫자가 아닌 입력값 검증")
    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(strings = {"\\n", "일곱"})
    public void 숫자가_아닌_입력값_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonInputValidator.isNonNumeric(input))
                .withMessage(CommonInputValidator.NON_NUMERIC_INPUT);
    }

    @DisplayName("범위를 벗어난 입력값 검증")
    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(strings = {"99999999999999999", "-999999999999999"})
    public void 범위를_벗어난_입력값_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonInputValidator.isOutOfParseRange(input))
                .withMessage(CommonInputValidator.OUT_OF_PARSE_RANGE);
    }

    @DisplayName("비어있는 요소를 가진 리스트형 입력값 검증")
    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(strings = {",1,2,3,4,5", "1,2,3,4,5,", "1,,2,3,4,5,6"})
    public void 비어있는_요소를_가진_리스트형_입력값_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonInputValidator.hasBlankElement(input, ","))
                .withMessage(CommonInputValidator.EMPTY_INPUT);
    }

    @DisplayName("숫자가 아닌 요소를 가진 리스트형 입력값 검증")
    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(strings = {"일,2,3,4,5,6", "1,2,\\n3,4,5,6", "1,2,3,4,5,&6"})
    public void 숫자가_아닌_요소를_가진_리스트형_입력값_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonInputValidator.existNonNumericElement(input, ","))
                .withMessage(CommonInputValidator.NON_NUMERIC_INPUT);
    }

    @DisplayName("범위를 벗어난 요소를 가진 리스트형 입력값 검증")
    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(strings = {"99999999999999,2,3,4,5,6", "-99999999999999,2,3,4,5,6"})
    public void 범위를_벗어난_요소를_가진_리스트형_입력값_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommonInputValidator.existOutOfParseRangeElement(input, ","))
                .withMessage(CommonInputValidator.OUT_OF_PARSE_RANGE);
    }
}