package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningStatisticsTest {
    private WinningStatistics winningStatistics;

    @BeforeEach
    public void setUp() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningStatistics = new WinningStatistics(List.of(), winningLotto, bonusNumber);
    }

    @Test
    public void 일등_당첨을_확인한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningCategory actual = winningStatistics.getWinningCategory(myLotto);
        assertEquals(WinningCategory.SIX_MATCH, actual);
    }

    @Test
    public void 이등_당첨을_확인한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningCategory actual = winningStatistics.getWinningCategory(myLotto);
        assertEquals(WinningCategory.FIVE_MATCH_WITH_BONUS, actual);
    }

    @Test
    public void 삼등_당첨을_확인한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        WinningCategory actual = winningStatistics.getWinningCategory(myLotto);
        assertEquals(WinningCategory.FIVE_MATCH, actual);
    }

    @Test
    public void 사등_당첨을_확인한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 20, 10));
        WinningCategory actual = winningStatistics.getWinningCategory(myLotto);
        assertEquals(WinningCategory.FOUR_MATCH, actual);
    }

    @Test
    public void 오등_당첨을_확인한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 30, 20, 10));
        WinningCategory actual = winningStatistics.getWinningCategory(myLotto);
        assertEquals(WinningCategory.THREE_MATCH, actual);
    }

    @Test
    public void 낙첨을_확인한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 40, 30, 20, 10));
        WinningCategory actual = winningStatistics.getWinningCategory(myLotto);
        assertEquals(WinningCategory.NO_WIN, actual);
    }

    @Test
    public void 여러_장의_로또의_당첨_개수를_계산한다() {
        List<Lotto> myLottos = getLottos();
        winningStatistics.countWinningCategory(myLottos);
        Map<WinningCategory, Integer> result = winningStatistics.getStatistics();

        assertEquals(result.get(WinningCategory.SIX_MATCH), 1);
        assertEquals(result.get(WinningCategory.FIVE_MATCH_WITH_BONUS), 1);
        assertEquals(result.get(WinningCategory.FIVE_MATCH), 1);
        assertEquals(result.get(WinningCategory.FOUR_MATCH), 1);
        assertEquals(result.get(WinningCategory.THREE_MATCH), 2);
    }

    private List<Lotto> getLottos() {
        Lotto myLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));  // 1등
        Lotto myLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));  // 2등
        Lotto myLotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));  // 3등
        Lotto myLotto4 = new Lotto(List.of(1, 2, 3, 4, 20, 10));  // 4등
        Lotto myLotto5 = new Lotto(List.of(1, 2, 3, 30, 20, 10));  // 5등
        Lotto myLotto6 = new Lotto(List.of(10, 20, 30, 4, 5, 6));  // 5등

        return List.of(myLotto1, myLotto2, myLotto3, myLotto4, myLotto5, myLotto6);
    }
}
