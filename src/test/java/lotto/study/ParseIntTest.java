package lotto.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParseIntTest {
    @Test
    @DisplayName("Integer.parseInt는 문자열을 정수로 변환한다")
    void parseIntConvertsStringToInteger() {
        String number = "1000";

        int result = Integer.parseInt(number);

        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("Integer.parseInt는 숫자가 아닌 문자열에 대해 NumberFormatException을 발생시킨다")
    @SuppressWarnings("ConstantConditions")
    void parseIntThrowsExceptionForNonNumeric() {
        String notANumber = "abc";

        assertThatThrownBy(() -> Integer.parseInt(notANumber))
            .isInstanceOf(NumberFormatException.class);
    }
}
