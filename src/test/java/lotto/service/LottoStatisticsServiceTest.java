package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsServiceTest {

    private final LottoStatisticsService lottoStatisticsService;

    LottoStatisticsServiceTest() {
        this.lottoStatisticsService = new LottoStatisticsService();
    }

    @Test
    @DisplayName("getStatistics는 의도한대로 작동한다.")
    public void getStatistics_ReturnCorrectly() {
        // given
        List<Lotto> lottos = List.of(
                generateFirstRankingLotto(),
                generateSecondRankingLotto(),
                generateThirdRankingLotto(),
                generateFourthRankingLotto(),
                generateFifthRankingLotto(),
                generateOtherRankingLotto()
        );
        FirstRankLotto firstRankLotto = generateFirstRankLotto();

        // when
        LottoStatistics statistics = lottoStatisticsService.getStatistics(lottos, firstRankLotto);
        Map<LottoRank, Integer> matchedByRank = statistics.getMatchedByRank();

        // then
        assertThat(matchedByRank.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(matchedByRank.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(matchedByRank.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(matchedByRank.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(matchedByRank.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(matchedByRank.get(LottoRank.OTHERS)).isEqualTo(1);
    }

    private static FirstRankLotto generateFirstRankLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        return new FirstRankLotto(numbers, bonusNumber);
    }

    private static Lotto generateFirstRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return new Lotto(numbers);
    }

    private static Lotto generateSecondRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);
        return new Lotto(numbers);
    }

    private static Lotto generateThirdRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        return new Lotto(numbers);
    }

    private static Lotto generateFourthRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 7, 8);
        return new Lotto(numbers);
    }

    private static Lotto generateFifthRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 7, 8, 9);
        return new Lotto(numbers);
    }

    private static Lotto generateOtherRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 7, 8, 9, 10);
        return new Lotto(numbers);
    }
}
