package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 당첨_결과를_정상적으로_계산한다() {
        LottoResult lottoResult = new LottoResult();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5개 일치
        Rank rank = lottoResult.determineRank(lotto, winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}
