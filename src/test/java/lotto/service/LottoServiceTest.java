package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.LottoStatisticsDTO.RankDTO;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    private LottoStatisticsDTO lottoStatistics;

    @Test
    void 구매한_로또들의_결과를_확인한다() {
        assertSimpleTest(() -> {
            Lottos lottos = new Lottos(List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 10))
            ));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            lottoStatistics = lottoService.getStatistics(winningLotto, lottos);
            long _1Count = lottoStatistics.statistics().get(RankDTO.from(Rank._1TH));
            long _2Count = lottoStatistics.statistics().get(RankDTO.from(Rank._2TH));
            long _3Count = lottoStatistics.statistics().get(RankDTO.from(Rank._3TH));
            assertThat(_1Count).isEqualTo(1);
            assertThat(_2Count).isEqualTo(1);
            assertThat(_3Count).isEqualTo(1);
        });
    }

    @Test
    void 구매한_로또들의_수익률을_확인한다() {
        assertSimpleTest(() -> {
            Lottos lottos = new Lottos(List.of(
                    new Lotto(List.of(1, 2, 3, 10, 11, 12))
            ));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            lottoStatistics = lottoService.getStatistics(winningLotto, lottos);
            assertThat(lottoStatistics.profit()).isEqualTo(500.0);
        });
    }
}
