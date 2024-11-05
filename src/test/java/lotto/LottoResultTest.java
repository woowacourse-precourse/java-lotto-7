package lotto;

import lotto.model.LottoResult;
import lotto.enumerate.MatchedCountKeyEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void 로또_결과_객체를_생성한다() {
        lottoResult = new LottoResult();
    }

    @Test
    void 숫자가_3개가_일치하는_경우의_개수를_1씩_증가시킨다() {
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(3, false);
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(3, true);

        assertThat(lottoResult.getMatchedCount().get(MatchedCountKeyEnum.THREE_MATCHED.getKey())).isEqualTo(2);
    }

    @Test
    void 숫자가_4개가_일치하는_경우의_개수를_1씩_증가시킨다() {
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(4, false);
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(4, true);

        assertThat(lottoResult.getMatchedCount().get(MatchedCountKeyEnum.FOUR_MATCHED.getKey())).isEqualTo(2);
    }

    @Test
    void 숫자가_5개가_일치하고_보너스_숫자가_다를_경우의_개수를_1씩_증가시킨다() {
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(5, false);
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(5, false);

        assertThat(lottoResult.getMatchedCount().get(MatchedCountKeyEnum.FIVE_MATCHED.getKey())).isEqualTo(2);
    }

    @Test
    void 숫자가_5개가_일치하고_보너스_숫자가_일치하는_경우의_개수를_1씩_증가시킨다() {
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(5, true);
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(5, true);

        assertThat(lottoResult.getMatchedCount().get(MatchedCountKeyEnum.FIVE_WITH_BONUS_MATCHED.getKey())).isEqualTo(2);
    }

    @Test
    void 숫자가_6개가_일치하는_경우의_개수를_1씩_증가시킨다() {
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(6, false);
        lottoResult.increaseCountByNumberMatchedAndBonusMatched(6, true);

        assertThat(lottoResult.getMatchedCount().get(MatchedCountKeyEnum.SIX_MATCHED.getKey())).isEqualTo(2);
    }
}
