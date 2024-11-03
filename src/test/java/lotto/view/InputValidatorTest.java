package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.view.input.InputValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @Test
    void 양의정수_10자리_이하_금액을_입력한다() {
        String testString = "50";

        assertThatCode(() -> InputValidator.validateInputInteger(testString))
                .doesNotThrowAnyException();
    }

    @Test
    void 금액_null일시_예외() {
        String testNumber = null;

        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 금액_빈_문자열일시_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20.2, -1.0, 0.5, 2.0, 2.5, 3.24321"})
    void 금액이_정수가_아니면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(testNumber))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20, -1, 0"})
    void 금액이_양수가_아니면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(testNumber))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000", "123456789123456789"})
    void 금액이_10자리를_넘어가면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(testNumber))
                .withMessage("[ERROR] 10자리 이하의 금액을 입력해주세요.");
    }

    @Test
    void 당첨번호_null일시_예외() {
        String testNumber = null;

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateGeneralValueInput(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 당첨번호_빈_문자열일시_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateGeneralValueInput(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @Test
    void 보너스번호_null일시_예외() {
        String testNumber = null;

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validateInputInteger(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 보너스번호_빈_문자열일시_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(testNumber))
                .withMessage("[ERROR] 값을 입력해주세요.");
    }
}
