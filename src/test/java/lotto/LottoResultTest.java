package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRanking;
import lotto.model.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 번호 개수 확인한다")
    void 당첨_번호와_일치하는_번호_개수_확인한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        int matchCount = lottoResult.matchNumber(lotto, winningNumbers);
        assertEquals(3, matchCount);
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 일치하는지 확인한다")
    void 로또_번호가_당첨_번호와_일치하는지_확인한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean result = lottoResult.isMatch(3, lotto);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 포함되어 있는지 확인한다")
    void 보너스_번호가_로또_번호에_포함되어_있는지_확인한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean result = lottoResult.matchBonusNumber(lotto, 6);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("당첨금이 정확히 추가되는지 확인한다")
    void 당첨금이_정확히_추가되는지_확인한다() {
        LottoRanking ranking = LottoRanking.FIFTH;
        lottoResult.addResult(lottoResult.getLottoRankingSet(), ranking);
        assertEquals(ranking.getWinningAmount(), lottoResult.getTotalPrice());
        assertEquals(1, ranking.getWinCount());
    }

    @Test
    @DisplayName("수익률 계산이 올바르게 되는지 확인한다")
    void 수익률_계산이_올바르게_되는지_확인한다() {
        LottoRanking ranking = LottoRanking.THIRD;
        lottoResult.addResult(lottoResult.getLottoRankingSet(), ranking);
        double profitRate = lottoResult.getProfitRate(5000);
        assertEquals(30000.0, profitRate);
    }

    @Test
    @DisplayName("여러개의 로또를 가지고 당첨 결과 계산한다")
    void 여러개의_로또_당첨_결과_계산() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = lottoResult.winning(lottos, winningNumbers, bonusNumber);

        assertEquals(1, result.getLottoRankingSet().get(0).getWinCount());
        assertEquals(0, result.getLottoRankingSet().get(1).getWinCount());
    }
}