package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParseUtilTest {

    @Test
    void 구분자로_문자열_분리() {
        List<String> result = ParseUtil.splitByDelimiters("1,2,3,4,5,6", ",");
        List<String> expected = List.of("1", "2", "3", "4", "5", "6");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 문자열_리스트를_정수_리스트로_변환() {
        List<String> stringList = List.of("1", "2", "3", "4", "5", "6");
        List<Integer> result = ParseUtil.parseToIntegerList(stringList);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 공백_제거() {
        String input = "   1  ,  2,   3   , 4  , 5,6    ";
        String result = ParseUtil.removeSpace(input);
        String expected = "1,2,3,4,5,6";
        assertThat(result).isEqualTo(expected);
    }
}