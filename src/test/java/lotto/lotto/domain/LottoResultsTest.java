package lotto.lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.lotto.domain.value.LottoRank;
import lotto.lotto.service.LottoRankCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private List<LottoResult> results;
    private LottoRankCalculator lottoRankCalculator;
    private LottoWinning lottoWinning;

    @BeforeEach
    void setUp() {
        LottoResult result1 = LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoResult result2 = LottoResult.create(new Lotto(List.of(11, 12, 13, 14, 15, 16)));

        lottoWinning = LottoWinning.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        results = List.of(result1, result2);
        lottoRankCalculator = new LottoRankCalculator();
    }

    @Test
    @DisplayName("LottoResults객체를 생성한다")
    void createLottoResultsTest() {
        // when
        LottoResults lottoResults = LottoResults.of(results);

        // then
        Assertions.assertThat(lottoResults.getId()).isInstanceOf(String.class);
        Assertions.assertThat(lottoResults.getResults()).isEqualTo(results);
    }

    @Test
    @DisplayName("LottoResults의 result들의 rank를 계산하여 새 객체로 반환한다.")
    void updateLottoResultsRankTest() {
        // when
        LottoResults lottoResults = LottoResults.of(results);
        LottoResults updatedLottoResults = lottoResults.updateAllLottoRanks(lottoRankCalculator, lottoWinning);

        // then
        Assertions.assertThat(updatedLottoResults).isInstanceOf(LottoResults.class);
    }

    @Test
    @DisplayName("LottoResults의 result들의 rank를 계산하여 Map으로 반환한다.")
    void winningInfoCreateTest() {
        // when
        LottoResults lottoResults = LottoResults.of(results);
        LottoResults updatedLottoResults = lottoResults.updateAllLottoRanks(lottoRankCalculator, lottoWinning);

        // then
        Assertions.assertThat(updatedLottoResults.getWinningInfo()).isInstanceOf(Map.class);
        Assertions.assertThat(updatedLottoResults.getWinningInfo().get(LottoRank.MATCHED6)).isEqualTo(1L);
        Assertions.assertThat(updatedLottoResults.getWinningInfo().get(LottoRank.FAIL)).isEqualTo(1L);
    }

    @Test
    @DisplayName("LottoResults의 lotto 당첨금을 계산한다.")
    void calculateLottoResultsRankTest() {
        // when
        LottoResults lottoResults = LottoResults.of(results);
        LottoResults updatedLottoResults = lottoResults.updateAllLottoRanks(lottoRankCalculator, lottoWinning);

        // then
        Assertions.assertThat(updatedLottoResults.calculateTotalWinningAmount()).isEqualTo(LottoRank.MATCHED6.getValue());
    }
}