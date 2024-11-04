package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoWinningResultTest {
    @Test
    void 등수별_당첨건수를_관리_한다() {
        LottoWinningResult result = new LottoWinningResult();
        result.setWinningInfo(LottoWinningStandard.FIRST_PRIZE, 2);

        assertThat(result.getWinningInfoValueByKey(LottoWinningStandard.FIRST_PRIZE))
                .isEqualTo(2);
    }
}
