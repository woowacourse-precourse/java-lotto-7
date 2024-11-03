package lotto.utilities;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 유효한_문자열이_정수로_변환된다() {
        String validNumber = "123";
        Integer expected = 123;

        Integer result = Parser.parseNumberToInt(validNumber);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 유효하지_않은_문자열이_입력되면_예외가_발생한다() {
        String invalidNumber = "123a";

        assertThatThrownBy(() -> Parser.parseNumberToInt(invalidNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_INT_NUMBER.getMessage());
    }

    @Test
    void 문자열_리스트가_정수_리스트로_변환된다() {
        List<String> validNumbers = Arrays.asList("1", "2", "3");
        List<Integer> expected = Arrays.asList(1, 2, 3);

        List<Integer> result = Parser.parseNumbersToInt(validNumbers);

        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    void 문자열_리스트에_유효하지_않은_숫자가_있으면_예외가_발생한다() {
        List<String> invalidNumbers = Arrays.asList("1", "two", "3");

        assertThatThrownBy(() -> Parser.parseNumbersToInt(invalidNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_INT_NUMBER.getMessage());
    }
}
