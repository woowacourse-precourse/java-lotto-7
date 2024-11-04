package lotto.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConverterTest {
    @Test
    @DisplayName("[success] 문자열을 정수로 변환한다.")
    void convertStringToInteger() {
        String testString = "10";

        int parsedInt = Converter.toInteger(testString);

        assertThat(parsedInt).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("[fail] 정수로 반환이 불가할 시 예외를 반환한다.")
    @ValueSource(strings = {"12 ", "1 2", "1.2", "1,2", "1&2", " 12"})
    void fail_IfCannotConvertToInteger(String wrongString) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> Converter.toInteger(wrongString))
                .withMessage(Exceptions.NOT_POSITIVE_INTEGER.getMessage());
    }
}
