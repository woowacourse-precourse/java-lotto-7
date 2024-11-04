package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningResultTest {
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();
    }

    @Test
    void 로또_결과_테스트() {
        //당첨 번호
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //보너스 번호
        int bonusNumber = 7;

        //로또 구매 번호
        List<List<Integer>> soldLotto = List.of(
                List.of(1, 2, 3, 4, 5, 6),   //1등
                List.of(1, 2, 3, 4, 5, 7),   //2등
                List.of(1, 2, 3, 4, 5, 40),  //3등
                List.of(1, 2, 3, 4, 39, 40), //4등
                List.of(1, 2, 3, 38, 39, 40),//5등
                List.of(1, 2, 41, 42, 43, 44)//꽝
        );

        winningResult.calculateWinningResult(soldLotto, winningNumbers, bonusNumber);

        assertEquals(1, winningResult.winningResult.get(WinningResult.Result.FIRST));
        assertEquals(1, winningResult.winningResult.get(WinningResult.Result.SECOND));
        assertEquals(1, winningResult.winningResult.get(WinningResult.Result.THIRD));
        assertEquals(1, winningResult.winningResult.get(WinningResult.Result.FOURTH));
        assertEquals(1, winningResult.winningResult.get(WinningResult.Result.FIFTH));
    }

    @Test
    void 수익률_계산_테스트() {
        winningResult.winningResult.put(WinningResult.Result.FIRST, 1);
        winningResult.winningResult.put(WinningResult.Result.SECOND, 2);
        winningResult.winningResult.put(WinningResult.Result.THIRD, 3);
        winningResult.winningResult.put(WinningResult.Result.FOURTH, 4);
        winningResult.winningResult.put(WinningResult.Result.FIFTH, 5);

        int purchaseMoney = 100000;

        double returnResult = winningResult.getReturnResult(purchaseMoney);

        double expected = (double) (2000000000 + 30000000 * 2 + 1500000 * 3 + 50000 * 4 + 5000 * 5) / 100000 * 100;

        assertEquals(expected, returnResult, 0.1);
    }
}