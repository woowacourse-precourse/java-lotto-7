package lotto.util;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConvertorTest {
    @Test
    @DisplayName("Integer 범위를 넘은 수가 입력될 경우")
    void integerOverflowTest() {
        List<String> exceptionData = List.of("2147483648", "2147483649", "21474836472147");
        ValidationProcess.createThrownBy(exceptionData, Convertor::stringToInt, ErrorMessage.WITHIN_RANGE);
    }

    @Test
    @DisplayName("Long 범위를 넘은 수가 입력될 경우")
    void longOverflowTest() {
        List<String> exceptionData = List.of("9223372036854775808","92233720368547758072","9223372036854775802317");
        ValidationProcess.createThrownBy(exceptionData, Convertor::stringToLong, ErrorMessage.AMOUNT_LIMIT);

    }
}
