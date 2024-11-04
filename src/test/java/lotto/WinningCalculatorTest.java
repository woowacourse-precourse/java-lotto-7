package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningCalculatorTest {

    private WinningLotto mockWinningLotto;
    private LottoStore mockLottoStore;
    private Customer mockCustomer;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        mockWinningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // Mock LottoStore 생성
        mockLottoStore = new LottoStore() {
            @Override
            public int calculateLottoCount(int money) {
                return 5; // 필요한 로또 개수를 반환
            }

            @Override
            public List<Lotto> sell(int count) {
                return Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                        new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4등
                        new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)) // 5등
                );
            }
        };
        mockCustomer = new Customer(0);
        mockCustomer.purchaseLottoFrom(mockLottoStore);
    }

    @Test
    @DisplayName("각 당첨 등급별로 당첨 횟수 계산")
    void 각_등급별로_당첨되면_등급별_당첨_횟수가_1이_나온다() {

        WinningCalculator calculator = new WinningCalculator();
         Map<LottoRank, Integer> actualCounts = calculator.calculateWinningCountsByRank(mockWinningLotto, mockCustomer);

        Map<LottoRank, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put(LottoRank.FIRST, 1);
        expectedCounts.put(LottoRank.SECOND, 1);
        expectedCounts.put(LottoRank.THIRD, 1);
        expectedCounts.put(LottoRank.FOURTH, 1);
        expectedCounts.put(LottoRank.FIFTH, 1);

        assertEquals(expectedCounts, actualCounts);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void 주어진_당첨_결과에_따라_수익률이_계산된다() {
        // 당첨 결과 설정
        Map<LottoRank, Integer> winningCountsByRank = new HashMap<>();
        winningCountsByRank.put(LottoRank.FIRST, 0);  // 1등 1개
        winningCountsByRank.put(LottoRank.SECOND, 0); // 2등 0개
        winningCountsByRank.put(LottoRank.THIRD, 0);  // 3등 0개
        winningCountsByRank.put(LottoRank.FOURTH, 1); // 4등 1개
        winningCountsByRank.put(LottoRank.FIFTH, 0);  // 5등 0개

        int purchasedMoney = 5000;
        WinningCalculator calculator = new WinningCalculator();
        double actualProfitRate = calculator.calculateProfitRate(winningCountsByRank, purchasedMoney);

        double expectedProfitRate = 1000.0;
        assertEquals(expectedProfitRate, actualProfitRate);
    }

}
