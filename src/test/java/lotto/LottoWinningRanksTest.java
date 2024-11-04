package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWinningRanksTest {
    @Test
    void 당첨_순위는_금액을_반환할_수_있다() {
        //given
        final long expectedLottoCount = 2000000000;
        final String expectedPrizeMoneyText = "2,000,000,000";
        final LottoWinningRanks lottoWinningRanks = LottoWinningRanks.FIRST;

        //when
        final long prizeMoney = lottoWinningRanks.getMoney();
        final String prizeMoneyText = lottoWinningRanks.getMoneyString();

        //then
        assertThat(prizeMoney).isEqualTo(expectedLottoCount);
        assertThat(prizeMoneyText).isEqualTo(expectedPrizeMoneyText);
    }

    @Test
    void 당첨_순위는_순위를_정할_수_있다() {
        //given
        final LottoWinningRanks expectedLottoWinningRanks = LottoWinningRanks.SECOND;
        final int sameCount = 5;
        final boolean isBonusMatched = true;

        //when
        final LottoWinningRanks lottoWinningRanks = LottoWinningRanks.getRank(sameCount, isBonusMatched);

        //then
        assertThat(lottoWinningRanks).isEqualTo(expectedLottoWinningRanks);
    }
}