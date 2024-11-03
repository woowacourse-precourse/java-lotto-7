package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoUtilTest {
    @Test
    void 당첨번호_파싱() {
        String input = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = LottoUtil.parseWinningNumbers(input);

        assertEquals(expectedNumbers, winningNumbers);
    }

    @Test
    void 보너스_번호_파싱() {
        String inputBonusNumber = "7";
        int expectedNumber = 7;

        int resultBonusNumber = LottoUtil.parseAndValidateBonusNumber(inputBonusNumber);

        assertEquals(expectedNumber, resultBonusNumber);
    }

    @Test
    void 보너스_번호가_1_45이내의_정수형이_아닌_경우_예외() {
        String inputBonusNumber = "46";

        assertThrows(IllegalArgumentException.class, () ->
                LottoUtil.parseAndValidateBonusNumber(inputBonusNumber)
        );

    }
}