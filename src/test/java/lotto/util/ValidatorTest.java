package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 입력 테스트")
    public void isEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.isEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
