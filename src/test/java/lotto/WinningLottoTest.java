package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    public void 당첨_번호_일치_여부_확인() {
    	//given
        List<Integer> testWinningNumber = List.of(1, 2, 3, 4, 5, 6);
        int testBonusNumber = 7;

        WinningLotto testWinningLotto = WinningLotto.of(testWinningNumber, testBonusNumber);
        int testNumber = 3;
        boolean expectedResult = true;

    	//when
        boolean actualResult = testWinningLotto.isWinningNumber(testNumber);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void 보너스_번호_일치_여부_확인() {
        //given
        List<Integer> testWinningNumber = List.of(1, 2, 3, 4, 5, 6);
        int testBonusNumber = 7;

        WinningLotto testWinningLotto = WinningLotto.of(testWinningNumber, testBonusNumber);
        int testNumber = 7;
        boolean expectedResult = true;

        //when
        boolean actualResult = testWinningLotto.isBonusNumber(testNumber);

        //then
        assertEquals(expectedResult, actualResult);
    }
}