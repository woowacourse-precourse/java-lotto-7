package lotto.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Util.Parser;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ParserTest {
    @Test
    public void testParserLottoNumbers() {
        Parser parser = new Parser();
        String inputValue = "1,2,3,4,5,6";

        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = parser.parseLottoNumbers(inputValue);

        assertEquals(expected, result, "[ERROR] 숫자로 제대로 변환 되지 않았습니다.");

        System.out.println("변환되었습니다");
    }
}
