package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankingTest {

    @DisplayName("당첨 번호와 일치하는 개수에 따라 당첨순위를 반환한다")
    @Test
    void getRanking() {
        // given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 14, 15, 20));
        List<Integer> winningNumber = List.of(1, 3, 5, 20, 41, 45);
        boolean hasBonus = false;

        int matchCount = lotto.countMatchingNumbers(winningNumber);

        // when
        LottoRanking ranking = LottoRanking.getRanking(matchCount, hasBonus);

        // then
        Assertions.assertThat(ranking).isEqualTo(LottoRanking.FOURTH);
    }
}
