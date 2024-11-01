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
                .withMessage("[ERROR] 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void failIfInputIntegerIsBlank(String testString) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testString))
                .withMessage("[ERROR] 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20.2, -1.0, 0.5, 2.0, 2.5, 3.24321"})
    void failIfInputIntegerIsNotInteger(String testString) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testString))
                .withMessage("[ERROR] 정수를 입력해주세요.");
    }
}
