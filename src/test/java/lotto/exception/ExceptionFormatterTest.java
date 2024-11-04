package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionFormatterTest {
    private ExceptionFormatter formatter = new ExceptionFormatter();

    @Test
    @DisplayName("예외 메시지 앞에 [ERROR]를 붙임")
    void test1() {
        String message = "ABC";

        String result = formatter.format(new RuntimeException(message));

        assertTrue(result.startsWith("[ERROR]"));
        assertTrue(result.contains(message));
    }

}