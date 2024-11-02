package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoParserTest {

    @Test
    @DisplayName("쉼표로 구분된 숫자로 구성된 문자열이 올바르게 숫자 리스트로 파싱된다.")
    void parseValidInput() {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when
        List<Integer> pickedNumbers = LottoParser.parse(input);

        // then
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(pickedNumbers, expected);
    }

}