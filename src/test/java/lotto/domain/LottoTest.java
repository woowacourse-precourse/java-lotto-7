package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 등수 테스트")
    public void getRankTest(){
        //given
        String inputWinningNumber = "1,2,3,4,5,6";
        String inputBonusNumber = "7";
        WinningNumber winningNumber = new WinningNumber(inputWinningNumber);
        Bonus bonus = new Bonus(inputBonusNumber);
        WinningLotto winningLotto = new WinningLotto(winningNumber,bonus);

        List<Integer> number1 = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(number1);
        List<Integer> number2 = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto2 = new Lotto(number2);
        List<Integer> number3 = List.of(1, 2, 3, 4, 5, 8);
        Lotto lotto3 = new Lotto(number3);
        List<Integer> number4 = List.of(1, 2, 3, 4, 8, 9);
        Lotto lotto4 = new Lotto(number4);
        List<Integer> number5 = List.of(1, 2, 3, 8, 9, 10);
        Lotto lotto5 = new Lotto(number5);
        List<Integer> number6 = List.of(8, 9, 10, 11, 12, 13);
        Lotto lotto6 = new Lotto(number6);

        //when
        Rank rank1 = lotto1.getRank(winningLotto);
        Rank rank2 = lotto2.getRank(winningLotto);
        Rank rank3 = lotto3.getRank(winningLotto);
        Rank rank4 = lotto4.getRank(winningLotto);
        Rank rank5 = lotto5.getRank(winningLotto);
        Rank rank6 = lotto6.getRank(winningLotto);

        //then
        assertEquals(rank1,Rank.FIRST);
        assertEquals(rank2,Rank.SECOND);
        assertEquals(rank3,Rank.THIRD);
        assertEquals(rank4,Rank.FOURTH);
        assertEquals(rank5,Rank.FIFTH);
        assertEquals(rank6,Rank.NON);
    }

    @Test
    @DisplayName("lotto 내부 값 테스트")
    public void getStateTest(){
        //given
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(number);
        //when
        String state = lotto.getState();
        //then
        assertEquals(state,"[1, 2, 3, 4, 5, 6]");
    }



    @Test
    @DisplayName("로또와 당첨번호 비교 후 일치되는 숫자 개수 테스트")
    public void getMatchingCountTest(){
        //given
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(number);

        //when
        int matchingCount = lotto.getMatchingCount(winningNumber);

        //then
        assertEquals(5, matchingCount);
    }

    @Test
    @DisplayName("보너스 번호 비교")
    public void getMatchingBonusTest(){
        //given
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(number);
        //when
        boolean matchingBonus1 = lotto.getMatchingBonus(6);
        boolean matchingBonus2 = lotto.getMatchingBonus(7);
        //then
        assertTrue(matchingBonus1);
        assertFalse(matchingBonus2);
    }
    @Test
    @DisplayName("로또 범위 검증")
    public void RangeTest(){
        //given
        List<Integer> number = List.of(1, 2, 3, 4, 5, 65);
        //expect
        assertThrows(IllegalArgumentException.class,()->{new Lotto(number);});
    }
}
