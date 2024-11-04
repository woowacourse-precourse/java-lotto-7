package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultChecker;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoGenerator lottoGenerator;
    private LottoResultChecker lottoResultChecker;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        lottoResultChecker = new LottoResultChecker();
        lottoService = new LottoService(lottoGenerator, lottoResultChecker);
    }

    @Test
    void calculateScores_shouldReturnCorrectScore() {
        int bonusNum = 7;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );

        List<Score> scores = lottoService.calculateScores(lottos, winningLotto, bonusNum);
        assertThat(scores).containsExactly(Score.SIX_CORRECT, Score.FIVE_CORRECT_BONUS_CORRECT, Score.NONE);
    }
}
