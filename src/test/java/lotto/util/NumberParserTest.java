package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.view.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {
    static final String LOTTO_NUMBER = "1,2,3,4,5,6";
    static final String NUMBER_WITH_BLANK = "1,2, 3,4,5 ,6";
    static final List<Integer> EXPECTED_LOTTO_NUMBER = List.of(1, 2, 3, 4, 5, 6);

    static final String BONUS_NUMBER = "7";
    static final int EXPECTED_BONUS_NUMBER = 7;

    @Test
    @DisplayName("6자리 로또 번호 파싱 테스트")
    void testParseLottoNumber() {
        //given,when
        List<Integer> result = NumberParser.parseLottoNumbers(LOTTO_NUMBER);
        //then
        assertEquals(result, EXPECTED_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("공백이 있는 로또 번호 파싱 테스트")
    void testParseNumberWithBlank() {
        //given,when
        List<Integer> result = NumberParser.parseLottoNumbers(NUMBER_WITH_BLANK);
        //then
        assertEquals(result, EXPECTED_LOTTO_NUMBER);
    }

    @Test
    void testParseBonusNumber() {
        //given,when
        int result = NumberParser.parseBonusNumber(BONUS_NUMBER);
        //then
        System.out.println(result);
        assertEquals(result, EXPECTED_BONUS_NUMBER);
    }

}