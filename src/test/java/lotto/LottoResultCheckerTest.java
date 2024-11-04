package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultCheckerTest {
    @Test
    void checkRanking_6개_번호_일치() {
        LottoResultChecker resultChecker = new LottoResultChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(resultChecker.checkRanking(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(MatchCountMessage.SIX_MATCH);
    }

    @Test
    void checkRanking_5개_번호_일치_보너스_번호_일치() {
        LottoResultChecker resultChecker = new LottoResultChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(resultChecker.checkRanking(List.of(1, 2, 3, 4, 5, 7))).isEqualTo(MatchCountMessage.FIVE_MATCH_WITH_BONUS);
    }


}