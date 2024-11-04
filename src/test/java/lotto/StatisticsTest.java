package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    @Test
    void 등수가_몇회인지_알_수_있다() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.FIRST, Rank.SECOND);
        Statistics statistics = new Statistics(ranks);

        assertThat(statistics.getFrequencyOf(Rank.FIRST)).isEqualTo(2);
        assertThat(statistics.getFrequencyOf(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.getFrequencyOf(Rank.THIRD)).isEqualTo(0);
    }

    @Test
    void 수익을_계산할_수_있다() {
        List<Rank> ranks = List.of(Rank.FOURTH, Rank.FIFTH, Rank.FIFTH);
        Statistics statistics = new Statistics(ranks);
        Money expected = new Money(60000);

        assertThat(statistics.getProfit()).isEqualTo(expected);
    }
}
