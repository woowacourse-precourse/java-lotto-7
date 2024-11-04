package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningCheckerTest {

    @Test
    void 로또_1등_확인(){
        WinningChecker checker = new WinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(Rank.FIRST, checker.checkLotto(lotto));
    }

    @Test
    void 로또_2등_확인(){
        WinningChecker checker = new WinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertEquals(Rank.SECOND, checker.checkLotto(lotto));
    }

    @Test
    void 로또_3등_확인(){
        WinningChecker checker = new WinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertEquals(Rank.THIRD, checker.checkLotto(lotto));
    }

    @Test
    void 로또_4등_확인(){
        WinningChecker checker = new WinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        assertEquals(Rank.FOURTH, checker.checkLotto(lotto));
    }

    @Test
    void 로또_5등_확인(){
        WinningChecker checker = new WinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        assertEquals(Rank.FIFTH, checker.checkLotto(lotto));
    }

    @Test
    void 로또_꽝_확인(){
        WinningChecker checker = new WinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        assertEquals(Rank.NONE, checker.checkLotto(lotto));
    }
}
