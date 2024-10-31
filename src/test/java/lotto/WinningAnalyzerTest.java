package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningAnalyzerTest {

    //테스트를 위해 lotto의 생성자 private -> public
    @DisplayName("로또들의 일치결과를 알려준다.")
    @Test
    void test_2() {
        Lotto userLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto userLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lottos lottos = new Lottos(List.of(userLotto2, userLotto1));
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = BonusBall.of(7, winningBalls);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(winningBalls, bonusBall);

        Map<Rank, Integer> result = winningAnalyzer.getResult(lottos);

        assertEquals(1, result.get(Rank.SECOND));
        assertEquals(1, result.get(Rank.THIRD));
    }

    @DisplayName("이천원 로또를 사고 당첨금 오천원의 수익률을 반환한다")
    @Test
    void test_3() {
        Lotto userLotto1 = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        Lotto userLotto2 = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Lottos lottos = new Lottos(List.of(userLotto2, userLotto1));
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = BonusBall.of(7, winningBalls);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(winningBalls, bonusBall);

        Float returnRate = winningAnalyzer.calculateReturnRate(lottos);

        assertEquals(250F, returnRate);
    }
}
