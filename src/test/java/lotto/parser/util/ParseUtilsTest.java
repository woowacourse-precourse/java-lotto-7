package lotto.parser.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ParseUtilsTest {

    @Test
    void 공백_제거_테스트() {
        String[] inputs = {" 1 ", " 2", "3 "};
        List<String> expected = Arrays.asList("1", "2", "3");

        List<String> result = ParseUtils.removeWhitespaceAndFormat(inputs);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void 문자열_리스트_정수형_리스트로_변환() {
        List<String> inputs = Arrays.asList("1", "2", "3");
        List<Integer> expected = Arrays.asList(1, 2, 3);

        List<Integer> result = ParseUtils.convertToNumbers(inputs);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void 문자열_정수형으로_변환() {
        String input = "5";

        int result = ParseUtils.convertToNumber(input);

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void 문자_변환_예외_테스트() {
        String input = "a";

        Assertions.assertThatThrownBy(() -> ParseUtils.convertToNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 형식만 입력 가능합니다. 잘못된 형식: a");
    }
}
