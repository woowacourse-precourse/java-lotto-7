package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.LottoValueConstant.LOTTO_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningCheckerTest {

    private WinningChecker winningChecker;
    private Lotto winningLotto;
    private Bonus bonus;

    @BeforeEach
    public void setUp() {
        winningChecker = new WinningChecker();
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonus = new Bonus(7, winningLotto);
    }

    @Test
    @DisplayName("당첨 결과 계산 테스트")
    public void testCheckWinning() {
        // 사용자 로또 티켓 목록
        List<List<Integer>> userLottos = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6), // 1등
                Arrays.asList(1, 2, 3, 4, 5, 7), // 2등 (보너스 번호 일치)
                Arrays.asList(1, 2, 3, 4, 5, 10), // 3등
                Arrays.asList(1, 2, 3, 4, 11, 12), // 4등
                Arrays.asList(1, 2, 3, 13, 14, 15), // 5등
                Arrays.asList(8, 9, 10, 11, 12, 13) // 꽝
        );

        Map<String, Integer> expectedRankCount = LottoRank.LottoRankCollector();
        expectedRankCount.put("FIRST", 1);
        expectedRankCount.put("SECOND", 1);
        expectedRankCount.put("THIRD", 1);
        expectedRankCount.put("FOURTH", 1);
        expectedRankCount.put("FIFTH", 1);

        Map<String, Integer> actualRankCount = winningChecker.checkWinning(bonus, winningLotto, userLottos);

        assertEquals(expectedRankCount, actualRankCount, "당첨 결과가 예상과 일치해야 합니다.");
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    public void testCalculateReturn() {
        Map<String, Integer> rankCount = new HashMap<>();
        rankCount.put("FIRST", 1); // 1등 1개
        rankCount.put("SECOND", 1); // 2등 1개
        rankCount.put("THIRD", 1); // 3등 1개
        rankCount.put("FOURTH", 1); // 4등 1개
        rankCount.put("FIFTH", 1); // 5등 1개

        int numberOfTickets = 6;

        double expectedReturnRate = ((double) LottoRank.FIRST.getPrize() * 1 +
                LottoRank.SECOND.getPrize() * 1 +
                LottoRank.THIRD.getPrize() * 1 +
                LottoRank.FOURTH.getPrize() * 1 +
                LottoRank.FIFTH.getPrize() * 1) / (numberOfTickets * LOTTO_PRICE) * 100;

        double actualReturnRate = WinningChecker.calculateReturn(rankCount, numberOfTickets);

        System.out.println(expectedReturnRate);

        String expect = String.format("%.2f", expectedReturnRate);
        String actual = String.format("%.2f",actualReturnRate);

        assertEquals(expect, actual,"수익률이 예상과 일치해야 합니다.");
    }
}

