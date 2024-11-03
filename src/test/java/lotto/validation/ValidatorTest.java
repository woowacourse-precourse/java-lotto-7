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

    @Test
    @DisplayName("문자열배열 크기가 매개변수 size와 같지 않으면 예외 발생 테스트")
    void sizeEqual() {
        int size = 3;
        String[] numbers = new String[size];

        numbers[0] = "1";
        numbers[1] = "2";
        numbers[2] = "3";

        assertThatThrownBy(() -> {
            Validator.sizeEqual(numbers, 4);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("list에 모든 숫자가 매개변수 min,max 범위밖이면 예외 발생 테스트")
    void allNumberRange() {
        BigDecimal min = new BigDecimal(1);
        BigDecimal max = new BigDecimal(45);
        List<BigDecimal> numbers = new ArrayList<>();

        numbers.add(new BigDecimal(100));
        numbers.add(new BigDecimal(2));
        numbers.add(new BigDecimal(3));
        numbers.add(new BigDecimal(4));
        numbers.add(new BigDecimal(5));

        assertThatThrownBy(() -> {
            Validator.allNumberRange(min, max, numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    }
}
