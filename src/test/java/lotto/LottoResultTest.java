package lotto;

import static lotto.constants.WinnerConstants.FIRST_WINNER;
import static lotto.constants.WinnerConstants.SECOND_WINNER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @Test
    void 여섯개_매칭_보너스_번호_불포함() {
        LottoResult lottoResult = new LottoResult(5);
        boolean isBonusMatched = false;
        lottoResult.updateLottoResult(FIRST_WINNER.getMatchCount(), isBonusMatched);

        assertThat(lottoResult.getPrizeMatchResults())
                .containsEntry(FIRST_WINNER.getRank(), 1);
    }

    @Test
    void 여섯개_매치_보너스_번호_포함() {
        LottoResult lottoResult = new LottoResult(5);
        boolean isBonusMatched = true;
        lottoResult.updateLottoResult(SECOND_WINNER.getMatchCount(), isBonusMatched);

        assertThat(lottoResult.getPrizeMatchResults())
                .containsEntry(SECOND_WINNER.getRank(), 1);
    }

    @Test
    void 로또_수익률_계산() {
        Map<Integer, Integer> prizeMatchResults = Map.of(4, 1, 5, 1);
        LottoResult lottoResult = new LottoResult(prizeMatchResults, 5);
        assertThat(lottoResult.calculateRateOfReturn())
                .isEqualTo(1100);
    }
}
