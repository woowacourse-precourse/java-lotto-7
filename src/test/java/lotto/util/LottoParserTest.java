package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoParserTest {

    @Test
    void 문자열_파싱하다() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when
        List<Integer> parsingNumbers = LottoParser.parsingNumber(numbers);

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), parsingNumbers);
    }
}