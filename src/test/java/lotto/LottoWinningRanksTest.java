package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWinningRanksTest {
    @Test
    void 당첨_순위는_금액을_반환할_수_있다() {
        //given
        long expectedLottoCount = 2000000000;
        String expectedPrizeMoneyText = "2,000,000,000";
        final LottoWinningRanks lottoWinningRanks = LottoWinningRanks.FIRST;

        //when
        long prizeMoney = lottoWinningRanks.getMoney();
        String prizeMoneyText = lottoWinningRanks.getMoneyString();

        //then
        assertThat(prizeMoney).isEqualTo(expectedLottoCount);
        assertThat(prizeMoneyText).isEqualTo(expectedPrizeMoneyText);
    }
}