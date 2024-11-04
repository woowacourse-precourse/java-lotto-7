package lotto;

import lotto.service.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.InstanceOfAssertFactories.set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


public class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    @DisplayName("정수 변환 테스트")
    void strToIntTest() {
        String validStr = "1000";
        int result = inputParser.strToInt(validStr);

        //assertThat(result).isEqualTo(1000);
        assertEquals(result, 1000);
    }

    @Test
    @DisplayName("문자열 자르기 테스트")
    void splitToArrayTest() {
        String readData = "1,2,3,4,5,6";
        List<Integer> result = inputParser.splitToArray(readData);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("갯수 계산 테스트")
    void calculatePapersTest() {
        int readData = 9000;
        int result = inputParser.calculatePapers(readData);

        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("오름차순 정렬 테스트")
    void sortArrayTest() {
        List<Integer> setData = new ArrayList<>(List.of(42, 43, 23, 21, 8, 41));
        List<Integer> result = inputParser.sortArray(setData);

        assertThat(result).containsExactly(8, 21, 23, 41, 42, 43);
    }



}
