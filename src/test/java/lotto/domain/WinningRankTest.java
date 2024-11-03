package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {

    private static Object[][] rankTestData() {
        return new Object[][] {
                { WinningRank.NONE, 0, 0, -1, null },
                { WinningRank.SECOND, 5, 30_000_000, 1, "5개 일치, 보너스 볼 일치 (30,000,000원)" },
                { WinningRank.THIRD, 5, 1_500_000, -1, "5개 일치 (1,500,000원)" }
        };
    }

    @ParameterizedTest
    @MethodSource("rankTestData")
    void 당첨_등수의_정보를_확인한다(WinningRank rank, int matchCount, int prize, int bonusNumMatch, String resultMessage) {
        assertThat(rank.getMatchCount()).isEqualTo(matchCount);
        assertThat(rank.getPrize()).isEqualTo(prize);
        assertThat(rank.getBonusNumMatch()).isEqualTo(bonusNumMatch);
        assertThat(rank.getResultMessage()).isEqualTo(resultMessage);
    }
}
