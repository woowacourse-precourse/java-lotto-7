package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.common.config.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoCheckerTest {
    private LottoChecker lottoChecker;
    private Lotto winning;
    private int bonus;

    @BeforeEach
    void setUp() {
        lottoChecker = new LottoChecker();
        winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonus = 7;
        lottoChecker.setWinningNumbers(winning, bonus);
    }

    @Test
    void 한개_로또_번호_체크_정상_동작() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        MatchResult result = lottoChecker.checkOneLotto(lotto);
        assertThat(result.getRank()).isEqualTo(LottoRank.MATCH_6);
    }

    @Test
    void 여러개_로또_번호_체크_정상_동작() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> lottos = List.of(lotto1, lotto2);
        List<MatchResult> result = lottoChecker.checkLottos(lottos);
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getRank()).isEqualTo(LottoRank.MATCH_6);
        assertThat(result.get(1).getRank()).isEqualTo(LottoRank.MATCH_5_BONUS);
    }
}
