package lotto.model;

import static lotto.util.LottoConstants.LOTTO_TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticTests {

    private LottoStatistic lottoStatistic;
    private List<Lotto> sample;

    @BeforeEach
    void setup() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoStatistic = new LottoStatistic(winningNumbers, bonusNumber);
        sample = List.of(
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43))
        );
    }

    @Test
    @DisplayName("당첨된 복권의 개수를 등수별로 그룹화")
    void countByLottoRankTest() {
        Map<LottoRank, Integer> expected = Map.of(LottoRank.NONE, 1, LottoRank.FIFTH, 1);
        Map<LottoRank, Integer> result = lottoStatistic.countByLottoRank(sample);

        assertEquals(result, expected);
    }

    @Test
    @DisplayName("당첨된 복권으로 얻은 수익의 총합을 계산")
    void calculateTotalRewardsTest() {
        Long expected = 5000L;

        lottoStatistic.countByLottoRank(sample);
        assertEquals(lottoStatistic.calculateTotalRewards(), expected);
    }

    @Test
    @DisplayName("당첨된 복권으로 얻은 총 수익률을 계산")
    void calculateProfitPercentageTest() {
        Double expected = 250.0;

        lottoStatistic.countByLottoRank(sample);
        Double result = lottoStatistic.calculateProfitPercentage(sample.size() * LOTTO_TICKET_PRICE);
        assertEquals(result, expected);
    }
}