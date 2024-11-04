package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import lotto.Model.Service.EarningRate;
import lotto.Model.Ranking;

import java.util.EnumMap;
import java.util.Map;

class EarningRateTest {

    @Test
    void returnEarningRate_calculatesCorrectRate() {
        Map<Ranking, Integer> resultSet = new EnumMap<>(Ranking.class);
        resultSet.put(Ranking.FIRST, 1);
        resultSet.put(Ranking.SECOND, 0);
        resultSet.put(Ranking.THIRD, 0);
        resultSet.put(Ranking.FOURTH, 0);
        resultSet.put(Ranking.FIFTH, 0);

        double revenue = EarningRate.returnEarningRate(1, resultSet);
        assertThat(revenue).isEqualTo(2000000.0);
    }

    @Test
    void returnEarningRate_returnsZeroForNoWinningTickets() {
        Map<Ranking, Integer> resultSet = new EnumMap<>(Ranking.class);
        resultSet.put(Ranking.FIRST, 0);
        resultSet.put(Ranking.SECOND, 0);
        resultSet.put(Ranking.THIRD, 0);
        resultSet.put(Ranking.FOURTH, 0);
        resultSet.put(Ranking.FIFTH, 0);

        double revenue = EarningRate.returnEarningRate(10, resultSet);
        assertThat(revenue).isEqualTo(0.0);
    }
}

