package lotto.model;

import static lotto.constant.LottoValue.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalystTest {
    private Analyst analyst;

    @BeforeEach
    public void setUp() {
        analyst = new Analyst();
    }

    @Test
    public void 각_랭크_로또가_하나씩_주어지면_결과값을_각_랭크를_하나씩_반환한다() {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.add(new LottoResult(rank));
        }

        int[] winLottoCount = analyst.calculateWinLottoCount(lottoResults);

        assertThat(winLottoCount).containsExactly(1, 1, 1, 1, 1, 1);    }

    @Test
    public void 로또가_없을_때_0을_반환한다() {
        List<LottoResult> lottoResults = Arrays.asList();

        double yield = analyst.calculateYield(lottoResults);

        assertThat(yield).isEqualTo(0.0);
    }

    @Test
    public void 각_랭크_로또가_하나씩_주어지면_수익률을_반환한다() {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.add(new LottoResult(rank));
        }

        double yield = analyst.calculateYield(lottoResults);

        double expectedYield = ((double) (2000000000 + 30000000 + 1500000 + 50000 + 5000) / (6 * LOTTO_PRICE.getValue()) * 100);

        assertThat(yield).isEqualTo(expectedYield);
    }
}
