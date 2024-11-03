package lotto.validation;

import static org.assertj.core.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    @DisplayName("문자열이 비어있으면 예외 발생 테스트")
    void isEmpty() {
        String empty = "";

        assertThatThrownBy(() -> {
            Validator.isEmpty(empty);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열이 모두 숫자로 구성되있지 않으면 예외 발생 테스트")
    void isDigitOnly() {
        String digit = "F123";

        assertThatThrownBy(() -> {
            Validator.isDigitOnly(digit);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("문자열배열이 모두 숫자가 아니면 예외 발생 테스트")
    void allDigits() {
        String[] numbers = new String[3];

        numbers[0] = "race";
        numbers[1] = "1";
        numbers[2] = "2";

        assertThatThrownBy(() -> {
            Validator.allDigits(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    }
}
