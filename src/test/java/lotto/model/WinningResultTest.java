package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    @Test
    @DisplayName("로또 수익률이 올바르게 계산되는지 확인하는 테스트")
    void calculateProfitRate() {
        WinningResult winningResult = new WinningResult();
        int purchaseAmount = 10000;
        double profitRate;
        double expectedProfitRate;

        //5등 당첨 한개 추가
        Rank rank = Rank.FIFTH;
        winningResult.add(rank);
        //만원 어치 구매해서 5등 한개 당첨
        profitRate = winningResult.calculateProfitRate(purchaseAmount);
        expectedProfitRate = (5000.0 / purchaseAmount) * 100;
        assertEquals(expectedProfitRate, profitRate);

        //4등 당첨 한개 추가
        rank = Rank.FOURTH;
        winningResult.add(rank);
        //만원 어치 구매해서 5등 한개, 4등 한개 당첨
        profitRate = winningResult.calculateProfitRate(purchaseAmount);
        expectedProfitRate = (55000.0 / purchaseAmount) * 100;
        assertEquals(expectedProfitRate, profitRate);
    }
}
