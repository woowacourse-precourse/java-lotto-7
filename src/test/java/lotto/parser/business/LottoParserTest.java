package lotto.parser.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class LottoParserTest {

    @Test
    void 올바른_형식의_숫자목록을_반환한다() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";

        List<Integer> result = LottoParser.parseWinningNumbers(winningNumbers);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result, "파싱된 당첨 번호는 예상 목록과 일치해야 합니다.");
    }

    @Test
    void 공백이_포함된_숫자문자열을_올바르게_처리한다() {
        String winningNumbers = " 1 , 2 ,   3, 4 ,5,6 ";

        List<Integer> result = LottoParser.parseWinningNumbers(winningNumbers);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result, "파서는 입력의 공백을 올바르게 처리해야 합니다.");
    }
}