package lotto.result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.Winning;
import lotto.service.ResultService;
import lotto.service.WinningService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    private WinningService winningService;
    private ResultService resultService;
    private Result result;
    private Winning winning;
    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        result = new Result();
        winning = new Winning();
        winningService = new WinningService(lottos, winning);
        resultService = new ResultService(lottos, winning);

        HashSet<Integer> winningSet = new HashSet<>();
        winningSet.add(1);
        winningSet.add(3);
        winningSet.add(4);
        winningSet.add(7);
        winningSet.add(9);

        winning.setHashSet(winningSet);
    }

    @Test
    @DisplayName("당첨 번호 갯수를 확인한다.")
    public void testWinningNumbersCount() {
        Lotto lotto = new Lotto(new LinkedList<>(Arrays.asList(1,2,3,4,5,6)));

        winningService.containsWinningNumber(lotto);
        int winningCount = resultService.checkWinningNumbersCount(lotto.getNumber());

        assertEquals(3, winningCount);
    }

    @Test
    @DisplayName("당첨 번호 갯수가 5개이다.")
    public void testIsWinningNumberFive() {
        Lotto lotto = new Lotto(new LinkedList<>(Arrays.asList(1,2,3,4,7,9)));

        winningService.containsWinningNumber(lotto);
        int winningCount = resultService.checkWinningNumbersCount(lotto.getNumber());

        assertTrue(resultService.isFiveWinningNumber(winningCount));
    }
}
