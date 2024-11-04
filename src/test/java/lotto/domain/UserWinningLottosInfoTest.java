package lotto.domain;

import static lotto.global.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserWinningLottosInfoTest {

    @DisplayName("getWinningCountByLottoRank_메서드_테스트_01")
    @Test
    void 로또_등수에_따라_당첨개수를_반환한다() {
        UserWinningLottosInfo userWinningLottosInfo = new UserWinningLottosInfo(
                Arrays.asList(FIRST, FIRST, SECOND, THIRD, THIRD, THIRD), 120000);

        assertThat(userWinningLottosInfo.getWinningCountByLottoRank(THIRD))
                .isEqualTo(3);
        assertThat(userWinningLottosInfo.getWinningCountByLottoRank(SECOND))
                .isEqualTo(1);
        assertThat(userWinningLottosInfo.getWinningCountByLottoRank(FIRST))
                .isEqualTo(2);
    }

    @DisplayName("getProfitRate_메서드_테스트_01")
    @Test
    void 수익률을_계산한다() {
        UserWinningLottosInfo userWinningLottosInfo = new UserWinningLottosInfo(Arrays.asList(FIFTH, FOURTH), 120000);

        assertThat(userWinningLottosInfo.getProfitRate())
                .isEqualTo(45.8);
    }
}
