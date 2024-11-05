package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @Test
    void 당첨_결과에_따라_통계를_업데이트한다() {
        LottoResult result = new LottoResult();

        result.updateResult(6, false);
        result.updateResult(5, true);
        result.updateResult(5, false);
        result.updateResult(4, false);

        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FOURTH)).isEqualTo(1);
    }
}
