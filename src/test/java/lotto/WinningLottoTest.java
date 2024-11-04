package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("로또와 매치할경우 정상적으로 매치한 랭크를 리턴한다.(1등 리턴)")
    @Test
    void test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        Rank result = winningLotto.match(lotto);
        Rank expectedRank = Rank.FIRST;

        assertEquals(expectedRank, result);
    }


    @DisplayName("로또와 매치할경우 정상적으로 매치한 랭크를 리턴한다.(2등 리턴)")
    @Test
    void test1() {
        Lotto lotto = new Lotto(List.of(7, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(8, 2, 3, 4, 5, 6), 7);

        Rank result = winningLotto.match(lotto);
        Rank expectedRank = Rank.SECOND;

        assertEquals(expectedRank, result);
    }

    @DisplayName("로또와 매치할경우 정상적으로 매치한 랭크를 리턴한다.(3등 리턴)")
    @Test
    void test2() {
        Lotto lotto = new Lotto(List.of(7, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(8, 2, 3, 4, 5, 6), 13);

        Rank result = winningLotto.match(lotto);
        Rank expectedRank = Rank.THIRD;

        assertEquals(expectedRank, result);
    }

    @DisplayName("로또와 매치할경우 정상적으로 매치한 랭크를 리턴한다.(4등 리턴)")
    @Test
    void test3() {
        Lotto lotto = new Lotto(List.of(7, 2, 3, 4, 5, 9));
        WinningLotto winningLotto = new WinningLotto(List.of(8, 2, 3, 4, 5, 6), 13);

        Rank result = winningLotto.match(lotto);
        Rank expectedRank = Rank.FOURTH;

        assertEquals(expectedRank, result);
    }

    @DisplayName("로또와 매치할경우 정상적으로 매치한 랭크를 리턴한다.(5등 리턴)")
    @Test
    void test4() {
        Lotto lotto = new Lotto(List.of(7, 2, 3, 4, 22, 9));
        WinningLotto winningLotto = new WinningLotto(List.of(8, 2, 3, 4, 5, 6), 13);

        Rank result = winningLotto.match(lotto);
        Rank expectedRank = Rank.FIFTH;

        assertEquals(expectedRank, result);
    }

    @DisplayName("로또와 매치할경우 정상적으로 매치한 랭크를 리턴한다.(NONE 리턴)")
    @Test
    void test5() {
        Lotto lotto = new Lotto(List.of(13, 22, 24, 32, 37, 41));
        WinningLotto winningLotto = new WinningLotto(List.of(8, 2, 3, 4, 5, 6), 13);

        Rank result = winningLotto.match(lotto);
        Rank expectedRank = Rank.NONE;

        assertEquals(expectedRank, result);
    }

}
