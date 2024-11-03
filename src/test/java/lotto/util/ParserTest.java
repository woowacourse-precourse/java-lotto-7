package lotto.util;

import static lotto.config.ErrorMessageConstant.NON_NUMERIC_MESSAGE;
import static lotto.util.Parser.parseToInteger;
import static lotto.util.Parser.parseToIntegerList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    void 정수_입력() {
        String input = "1";
        assertDoesNotThrow(() ->
                parseToInteger(input)
        );
    }

    @Test
    void 정수_입력_실패() {
        String input = "a";
        assertThatThrownBy(() -> parseToInteger(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_NUMERIC_MESSAGE);
    }

    @Test
    void 정수_리스트_입력() {
        List<String> input = List.of("1", "2", "3");
        assertDoesNotThrow(() ->
                parseToIntegerList(input)
        );
    }

    @Test
    void 정수_리스트_입력_실패() {
        List<String> input = List.of("1", "2", "a");
        assertThatThrownBy(() -> parseToIntegerList(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_NUMERIC_MESSAGE);
    }
}