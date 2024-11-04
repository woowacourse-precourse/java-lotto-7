package lotto;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class IOControllerTest extends NsTest {
    IOController ioController = new IOController();

    @Test
    void 발행된_로또_번호_출력() {
        // given
        Lotto testLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto testLotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto testLotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Lotto testLotto4 = new Lotto(List.of(19, 20, 21, 22, 23, 24));
        Lotto testLotto5 = new Lotto(List.of(25, 26, 27, 28, 29, 30));

        List<Lotto> testLottos = List.of(testLotto1, testLotto2, testLotto3, testLotto4, testLotto5);

        //when
        ioController.printLottos(testLottos);

        // then
        assertEquals(testLottos.size() + "개를 구매했습니다.\n"
            + "[1, 2, 3, 4, 5, 6]\n"
            + "[7, 8, 9, 10, 11, 12]\n"
            + "[13, 14, 15, 16, 17, 18]\n"
            + "[19, 20, 21, 22, 23, 24]\n"
            + "[25, 26, 27, 28, 29, 30]", output());
    }

    @Test
    void 당첨_번호_출력() {
        List<Integer> testLotto = List.of(1, 2, 3, 4, 5, 6);
        ioController.printLotto(testLotto);
        assertEquals("[1, 2, 3, 4, 5, 6]", output());
    }

    @Test
    void 수익률_출력() {
        double testYield  = 123.67;
        ioController.printWinningStatistics(testYield);
        assertEquals("총 수익률은 123.67%입니다.", output());
    }

    @Test
    void 당첨_통계_출력() {
        // given
        Map<Rank, Integer> testWinningStatistics = new HashMap<>();
        testWinningStatistics.put(Rank.THREE, 1);
        testWinningStatistics.put(Rank.FOUR, 0);
        testWinningStatistics.put(Rank.FIVE, 0);
        testWinningStatistics.put(Rank.FIVE_AND_BONUS, 0);
        testWinningStatistics.put(Rank.SIX, 0);

        // when
        ioController.printWinningResults(testWinningStatistics);

        // then
        assertEquals("당첨 통계\n---\n"
            + "3개 일치 (5,000원) - 1개\n"
            + "4개 일치 (50,000원) - 0개\n"
            + "5개 일치 (1,500,000원) - 0개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
            + "6개 일치 (2,000,000,000원) - 0개", output());
    }

    @Override
    protected void runMain() {
    }
}

