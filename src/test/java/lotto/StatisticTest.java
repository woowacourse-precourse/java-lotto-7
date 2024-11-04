package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StatisticTest {

    @Test
    void 등수가_몇회인지_알_수_있다() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.FIRST, Rank.SECOND);
        Statistic statistic = new Statistic(ranks);

        assertThat(statistic.getFrequencyOf(Rank.FIRST)).isEqualTo(2);
        assertThat(statistic.getFrequencyOf(Rank.SECOND)).isEqualTo(1);
        assertThat(statistic.getFrequencyOf(Rank.THIRD)).isEqualTo(0);
    }

    @Test
    void 수익을_계산할_수_있다() {
        List<Rank> ranks = List.of(Rank.FOURTH, Rank.FIFTH, Rank.FIFTH);
        Statistic statistic = new Statistic(ranks);
        Money expected = new Money(60000);

        assertThat(statistic.getProfit()).isEqualTo(expected);
    }
}
