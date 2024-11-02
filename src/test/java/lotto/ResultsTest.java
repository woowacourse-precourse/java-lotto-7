package lotto;

import java.util.List;
import lotto.common.LottoResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @DisplayName("당첨금액 종합 테스트")
    @Test
    void 당첨_금액_합계_테스트() {
        final List<LottoResult> lottoResults = List.of(LottoResult.FIRST, LottoResult.SECOND, LottoResult.NONE);
        final Results results = new Results(lottoResults);

        Assertions.assertEquals(results.getSum(),
                LottoResult.FIRST.getWinningAmount() + LottoResult.SECOND.getWinningAmount());
    }
}