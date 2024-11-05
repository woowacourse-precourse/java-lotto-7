package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.domain.WinningStatistics.calculateEarningRate;
import static lotto.domain.WinningStatistics.checkWinningResult;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest extends NsTest {

    @Test
    void 당첨결과를_정확하게_확인하는지_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Budget testbudget = new Budget("3000");
                    Purchaser purchaser = new Purchaser(testbudget);
                    WinningNumbers testWinningNumbers = new WinningNumbers("1,2,3,4,5,6");
                    BonusNumber testBonusNumber = new BonusNumber("7", testWinningNumbers);

                    checkWinningResult(purchaser, testWinningNumbers, testBonusNumber);

                    assertThat(WinningInfo.FIFTH.getWinningTicketCount()).isEqualTo(1);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 수익률_계산이_정확한지_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Budget testbudget = new Budget("3000");
                    Purchaser purchaser = new Purchaser(testbudget);
                    WinningNumbers testWinningNumbers = new WinningNumbers("1,2,3,4,5,6");
                    BonusNumber testBonusNumber = new BonusNumber("7", testWinningNumbers);
                    checkWinningResult(purchaser, testWinningNumbers, testBonusNumber);

                    assertThat(calculateEarningRate(testbudget)).isEqualTo((double) 5000 / 3000 * 100);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    protected void runMain() {
    }
}