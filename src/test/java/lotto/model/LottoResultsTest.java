package lotto.model;

import lotto.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

public class LottoResultsTest {
    private WinningNumbers winningNumbers;
    private LottoResults lottoResults;
    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        lottoResults = new LottoResults(winningNumbers);

        lottos = new Lottos();
        lottos.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottos.addLotto(Arrays.asList(1, 2, 3, 4, 5, 9));
        lottos.addLotto(Arrays.asList(1, 2, 3, 4, 9, 10));
        lottos.addLotto(Arrays.asList(1, 2, 3, 9, 10, 11));
        lottos.addLotto(Arrays.asList(8, 9, 10, 11, 12, 13));
    }

    @Test
    public void 랭크가_매겨진_로또_결과가_정상적으로_생성되는지_확인한다() {
        lottoResults.initLottoResults(lottos);
        List<LottoResult> results = lottoResults.getLottoResults();
        assertThat(results).hasSize(6);
        assertThat(results.get(0).getLottoRank()).isEqualTo(LottoRank.FIRST.getRank());
        assertThat(results.get(1).getLottoRank()).isEqualTo(LottoRank.SECOND.getRank());
        assertThat(results.get(2).getLottoRank()).isEqualTo(LottoRank.THIRD.getRank());
        assertThat(results.get(3).getLottoRank()).isEqualTo(LottoRank.FOURTH.getRank());
        assertThat(results.get(4).getLottoRank()).isEqualTo(LottoRank.FIFTH.getRank());
        assertThat(results.get(5).getLottoRank()).isEqualTo(LottoRank.NONE.getRank());
    }
}
