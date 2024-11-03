package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "10000, 10",
            "20000, 20"
    })
    void 천원단위로_개수_반환하다(int price, int expected) {
        assertEquals(expected, LottoParser.parsingPrice(price));
    }
}