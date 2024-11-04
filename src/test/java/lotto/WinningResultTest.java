package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class WinningResultTest {

    @Test
    public void testCalculateRankCount() {
        WinningResult winningResult = new WinningResult();
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6)); // 1등
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 7)); // 2등
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 8)); // 3등
        lottoNumbers.add(List.of(1, 2, 3, 4, 9, 10)); // 4등
        lottoNumbers.add(List.of(1, 2, 3, 11, 12, 13)); // 5등
        winningResult.setNumbers(winningNumber, bonusNum, lottoNumbers);

        int[] rankCount = winningResult.calculateRankCount();

        assertEquals(1, rankCount[WinningResult.LottoRank.FIRST.ordinal()]);
        assertEquals(1, rankCount[WinningResult.LottoRank.SECOND.ordinal()]);
        assertEquals(1, rankCount[WinningResult.LottoRank.THIRD.ordinal()]);
        assertEquals(1, rankCount[WinningResult.LottoRank.FOURTH.ordinal()]);
        assertEquals(1, rankCount[WinningResult.LottoRank.FIFTH.ordinal()]);
    }

    @Test
    public void testCalculateProfitRate() {
        WinningResult winningResult = new WinningResult();
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6)); // 1등
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 7)); // 2등
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 8)); // 3등
        lottoNumbers.add(List.of(1, 2, 3, 4, 9, 10)); // 4등
        lottoNumbers.add(List.of(1, 2, 3, 11, 12, 13)); // 5등
        winningResult.setNumbers(winningNumber, bonusNum, lottoNumbers);

        int[] rankCount = winningResult.calculateRankCount();
        double profitRate = winningResult.calculateProfitRate(rankCount, lottoNumbers.size() * 1000); // total as number of tickets * cost per ticket

        assertTrue(profitRate > 0);
    }

    @Test
    public void testCountMatches() {
        WinningResult winningResult = new WinningResult();
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> ticket = List.of(1, 2, 3, 4, 5, 7);
        winningResult.setWinningNumber(winningNumber); // winningNumber 설정

        int matchCount = winningResult.countMatches(ticket);

        assertEquals(5, matchCount);
    }

    @Test
    public void testLottoRankValueOf() {
        WinningResult.LottoRank rank1 = WinningResult.LottoRank.valueOf(6, false);
        WinningResult.LottoRank rank2 = WinningResult.LottoRank.valueOf(5, true);
        WinningResult.LottoRank rank3 = WinningResult.LottoRank.valueOf(5, false);
        WinningResult.LottoRank rank4 = WinningResult.LottoRank.valueOf(4, false);
        WinningResult.LottoRank rank5 = WinningResult.LottoRank.valueOf(3, false);
        WinningResult.LottoRank rankNone = WinningResult.LottoRank.valueOf(2, false);

        assertEquals(WinningResult.LottoRank.FIRST, rank1);
        assertEquals(WinningResult.LottoRank.SECOND, rank2);
        assertEquals(WinningResult.LottoRank.THIRD, rank3);
        assertEquals(WinningResult.LottoRank.FOURTH, rank4);
        assertEquals(WinningResult.LottoRank.FIFTH, rank5);
        assertEquals(WinningResult.LottoRank.NONE, rankNone);
    }
}
