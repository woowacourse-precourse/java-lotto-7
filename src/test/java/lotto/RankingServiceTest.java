package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.service.RankingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingServiceTest {

    RankingService rankingService = new RankingService();

    @Test
    @DisplayName("로또 번호 비교함수 테스트")
    void compareLottoNumbersTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        int result = rankingService.compareLottoNumbers(lotto, winningLotto);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("로또번호 비교 후 등수에 맞게 증가하는지 테스트")
    void evaluateLottoResultTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        rankingService.evaluateLottoResult(winningLotto, 6, lotto);
        
        assertThat(Ranking.SECOND.getCount()).isEqualTo(1);
        assertThat(Ranking.FIFTH.getCount()).isEqualTo(0);
        assertThat(Ranking.FOURTH.getCount()).isEqualTo(0);
        assertThat(Ranking.THIRD.getCount()).isEqualTo(0);
        assertThat(Ranking.FIRST.getCount()).isEqualTo(0);
    }
}
