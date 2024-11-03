package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호, 보너스 중복 검증")
    public void winningLottoTest() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        Bonus bonus = new Bonus("6");

         //expect
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(winningNumber, bonus));
    }

    @Test
    @DisplayName("로또와 당첨번호 비교 후 일치되는 숫자 개수 테스트")
    public void getMatchingCountTest() {
        //given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        Bonus bonus = new Bonus("7");

        WinningLotto lotto = new WinningLotto(winningNumber, bonus);
        //when
        int matchingCount = lotto.getMatchingCount(list);
        //then
        assertEquals(6, matchingCount);
    }
}