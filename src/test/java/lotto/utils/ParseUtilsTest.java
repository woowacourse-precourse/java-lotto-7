package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ParseUtilsTest {

    @Test
    void 공백_제거_테스트() {
        String[] inputs = {" 1 ", " 2", "3 "};
        List<String> expected = Arrays.asList("1", "2", "3");

        List<String> result = ParseUtils.removeWhitespace(inputs);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void 문자열_리스트_정수형_리스트로_변경() {
        List<String> inputs = Arrays.asList("1", "2", "3");
        List<Integer> expected = Arrays.asList(1, 2, 3);

        List<Integer> result = ParseUtils.convertToNumbers(inputs);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
