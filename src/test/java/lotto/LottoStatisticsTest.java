package lotto;

import lotto.model.Lotto;
import lotto.service.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static lotto.constant.LottoMatchConstant.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStatisticsTest {
    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final int winningBonusNumber = 7;
    private final LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, winningBonusNumber);

    @DisplayName("로또 번호 3개가 일치하면 당첨 통계가 업데이트된다.")
    @Test
    void 사용자_로또_3개일치_업데이트() {
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 11, 12, 13)));
        LinkedHashMap<String, Integer> statistics = lottoStatistics.calculateUserLottoStatistics(userLottos);

        assertThat(statistics.get(MATCH_3.getMatch())).isEqualTo(1);
        assertThat(statistics.get(MATCH_4.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5_WITH_BONUS.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_6.getMatch())).isEqualTo(0);
    }

    @DisplayName("로또 번호 4개가 일치하면 당첨 통계가 업데이트된다.")
    @Test
    void 사용자_로또_4개일치_업데이트() {
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 12, 13)));
        LinkedHashMap<String, Integer> statistics = lottoStatistics.calculateUserLottoStatistics(userLottos);

        assertThat(statistics.get(MATCH_3.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_4.getMatch())).isEqualTo(1);
        assertThat(statistics.get(MATCH_5.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5_WITH_BONUS.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_6.getMatch())).isEqualTo(0);
    }

    @DisplayName("로또 번호 4개가 일치하면 당첨 통계가 업데이트된다.")
    @Test
    void 사용자_로또_5개일치_업데이트() {
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 13)));
        LinkedHashMap<String, Integer> statistics = lottoStatistics.calculateUserLottoStatistics(userLottos);

        assertThat(statistics.get(MATCH_3.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_4.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5.getMatch())).isEqualTo(1);
        assertThat(statistics.get(MATCH_5_WITH_BONUS.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_6.getMatch())).isEqualTo(0);
    }

    @DisplayName("로또 번호 5개 + 보너스가 일치하면 당첨 통계가 업데이트된다.")
    @Test
    void 사용자_로또_5개_보너스일치_업데이트() {
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        LinkedHashMap<String, Integer> statistics = lottoStatistics.calculateUserLottoStatistics(userLottos);

        assertThat(statistics.get(MATCH_3.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_4.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5_WITH_BONUS.getMatch())).isEqualTo(1);
        assertThat(statistics.get(MATCH_6.getMatch())).isEqualTo(0);
    }

    @DisplayName("로또 번호 6개가 일치하면 당첨 통계가 업데이트된다.")
    @Test
    void 사용자_로또_6개일치_업데이트() {
        List<Lotto> userLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LinkedHashMap<String, Integer> statistics = lottoStatistics.calculateUserLottoStatistics(userLottos);

        assertThat(statistics.get(MATCH_3.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_4.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_5_WITH_BONUS.getMatch())).isEqualTo(0);
        assertThat(statistics.get(MATCH_6.getMatch())).isEqualTo(1);
    }
}
