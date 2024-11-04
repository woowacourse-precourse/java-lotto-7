package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParseTest {

    @DisplayName("문자열 파싱 테스트")
    @Test
    void testSplitNumbers() {
        String buffer = "1,2,3,4,5,6";
        String[] expected = {"1", "2", "3", "4", "5", "6"};
        String[] result = Parse.splitNumbers(buffer);

        assertEquals(Arrays.toString(expected), Arrays.toString(result), "실제 결과가 예상 결과와 다릅니다");
    }

    @DisplayName("문자열 List<Integer> 로 변경하는 테스트")
    @Test
    void testConvertToIntegerList() {
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = Parse.convertToIntegerList(numbers);

        assertEquals(expected, result, "실제 결과가 예상 결과와 다릅니다");
    }

    @DisplayName("파싱 메소드들을 합쳤을 때 올바른 결과가 나오는지 테스트")
    @Test
    void testWinningNumbers() {
        String buffer = "1,2,3,4,5,6";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = Parse.winningNumbers(buffer);

        assertEquals(expected, result, "실제 결과가 예상 결과와 다릅니다");
    }
}
