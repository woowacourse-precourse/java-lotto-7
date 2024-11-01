package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Test
    void 빈문자열_예외() {
        assertThatThrownBy(() -> InputParser.parseInt(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_A_NUMBER.format());
    }

    @Test
    void 숫자가_아닌_것이_입력된_예외() {
        assertThatThrownBy(() -> InputParser.parseInt("123 abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_A_NUMBER.format());
    }

    @Test
    void 정수범위_벗어난_예외() {
        assertThatThrownBy(() -> InputParser.parseInt("10000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.format(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void 쉼표로_구분되지_않은_배열이_들어온_예외() {
        assertThatThrownBy(() -> InputParser.parseIntList("1:3.4,7", ","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DELIMITER.format(","));
    }
}
