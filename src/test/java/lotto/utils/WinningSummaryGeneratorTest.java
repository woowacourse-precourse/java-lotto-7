package lotto.utils;

import static lotto.constant.WinningPrize.FIFTH_PRIZE;
import static lotto.constant.WinningPrize.FIRST_PRIZE;
import static lotto.constant.WinningPrize.FOURTH_PRIZE;
import static lotto.constant.WinningPrize.SECOND_PRIZE;
import static lotto.constant.WinningPrize.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.WinningStat;
import lotto.dto.WinningSummary;
import org.junit.jupiter.api.Test;

public class WinningSummaryGeneratorTest {
    @Test
    void 통계_정보를_통해_WinningSummary_를_생성() {
        // given
        List<WinningStat> winningStats = List.of(new WinningStat(3, false, FIFTH_PRIZE.getPrizeAmount(), 0),
                new WinningStat(4, false, FOURTH_PRIZE.getPrizeAmount(), 0),
                new WinningStat(5, false, THIRD_PRIZE.getPrizeAmount(), 0),
                new WinningStat(5, true, SECOND_PRIZE.getPrizeAmount(), 1),
                new WinningStat(6, false, FIRST_PRIZE.getPrizeAmount(), 1));

        // when
        WinningSummary actual = WinningSummaryGenerator.generate(winningStats);
        WinningSummary expected = new WinningSummary(
                List.of("3개 일치 (5,000원) - 0개", "4개 일치 (50,000원) - 0개", "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개", "6개 일치 (2,000,000,000원) - 1개" ), winningStats);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
