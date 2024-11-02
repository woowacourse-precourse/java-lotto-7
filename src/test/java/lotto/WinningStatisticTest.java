package lotto;


import lotto.controller.ResultController;
import lotto.domain.Prize;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticTest {
    private final ResultController resultController = new ResultController();

    @Test
    void 등수별_당첨_횟수_합산() {
        List<Prize> prizeStatus = Stream.of(
                Prize.FIRST, Prize.FIRST, Prize.FIRST,
                Prize.SECOND,
                Prize.THIRD, Prize.THIRD, Prize.THIRD, Prize.THIRD, Prize.THIRD,
                Prize.FOURTH, Prize.FOURTH)
                .collect(Collectors.toCollection(ArrayList::new));

        Map<Prize, Integer> statistic = resultController.makeWinningStatistic(prizeStatus);
        assertThat(statistic.get(Prize.FIRST)).isEqualTo(3);
        assertThat(statistic.get(Prize.SECOND)).isEqualTo(1);
        assertThat(statistic.get(Prize.THIRD)).isEqualTo(5);
        assertThat(statistic.get(Prize.FOURTH)).isEqualTo(2);
        assertThat(statistic.get(Prize.FIFTH)).isEqualTo(0);
    }

    @Test
    void 수익률_계산() {
        int buyingAmount = 8000;
        Map<Prize, Integer> statistic2 = resultController.makeWinningStatistic(
                Stream.of(Prize.FIFTH)
                        .collect(Collectors.toCollection(ArrayList::new)));
        assertThat(resultController.calculateEarningRatio(statistic2, buyingAmount)).isEqualTo("62.5");
    }

}
