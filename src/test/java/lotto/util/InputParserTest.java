package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    @DisplayName("로또 번호를 입력할 때 숫자를 입력하지 않으면 예외가 발생한다.")
    void 로또_번호를_입력할_때_숫자를_입력하지_않으면_예외가_발생한다() {
        String input = "1,2,삼,4,5,6";

        assertThrows(IllegalArgumentException.class,
                () -> InputParser.parseStringToInt(input));
    }

}