package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AdditionalApplicationTest {
    @Test
    void shouldValidateInputInteger() {
        String testString = "50";

        assertThatCode(() -> Application.validateInputInteger(testString))
                .doesNotThrowAnyException();

    }

    @Test
    void failIfInputIntegerIsNull() {
        String testString = null;

        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testString))
                .withMessage("[ERROR] 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void failIfInputIntegerIsBlank(String testString) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testString))
                .withMessage("[ERROR] 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20.2, -1.0, 0.5, 2.0, 2.5, 3.24321"})
    void 금액이_정수가_아니면_예외(String testString) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testString))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20, -1, 0"})
    void 금액이_양수가_아니면_예외(String testString) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testString))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000", "123456789123456789"})
    void 금액이_10자리를_넘어가면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 10자리 이하의 금액을 입력해주세요.");
    }



}
