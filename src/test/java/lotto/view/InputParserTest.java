package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.view.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {
    static final String LOTTO_NUMBER = "1,2,3,4,5,6";
    static final String NUMBER_WITH_BLANK = "1,2, 3,4,5 ,6";
    static final List<Integer> EXPECTED_LOTTO_NUMBER = List.of(1, 2, 3, 4, 5, 6);

    static final String BONUS_NUMBER = "7";
    static final int EXPECTED_BONUS_NUMBER = 7;

    static final String ALPHABET_INPUT = "1,2,3,4,5,a";
    static final String SPECIAL_CHARACTER_INPUT = "1,2,3,4,5,/";

    static final String ALPHABET = "a";
    static final String SPECIAL_CHARACTER = "/";

    @Test
    @DisplayName("6자리 로또 번호 파싱 테스트")
    void testParseLottoNumber() {
        //given,when
        List<Integer> result = InputParser.parseLottoNumbers(LOTTO_NUMBER);
        //then
        assertEquals(result, EXPECTED_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("공백이 있는 로또 번호 파싱 테스트")
    void testParseNumberWithBlank() {
        //given,when
        List<Integer> result = InputParser.parseLottoNumbers(NUMBER_WITH_BLANK);
        //then
        assertEquals(result, EXPECTED_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("보너스 번호 파싱 테스트")
    void testParseNumber() {
        //given,when
        int result = InputParser.parseNumber(BONUS_NUMBER);
        //then
        assertEquals(result, EXPECTED_BONUS_NUMBER);
    }

    @ParameterizedTest
    @DisplayName("알파벳과 특수문자가 들어간 로또번호 예외 처리 테스트 ")
    @ValueSource(strings = {ALPHABET_INPUT, SPECIAL_CHARACTER_INPUT})
    void testNonNumericLottoNumber(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseLottoNumbers(input));
    }

    @ParameterizedTest
    @DisplayName("알파벳과 특수문자가 들어간 보너스 번호 예외 처리 테스트 ")
    @ValueSource(strings = {ALPHABET, SPECIAL_CHARACTER})
    void testNonNumericBonusNumber(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseNumber(input));
    }
}