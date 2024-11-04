package lotto.models;

import lotto.utils.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsCalculatorTest {

    private Statistics statistics;
    private StatisticsCalculator statisticsCalculator;

    @BeforeEach
    void setUp() {
        statistics = new Statistics();
        statisticsCalculator = new StatisticsCalculator(statistics);
    }

    @Test
    void 세_개_일치하는_로또가_존재할_때_통계가_정확히_증가하는지_확인한다() {
        List<List<Integer>> allIssuedLotto = List.of(
                List.of(1, 2, 3, 10, 20, 30)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 40, 41, 42);
        int bonusNumber = 45;

        statisticsCalculator.calculateStatistics(allIssuedLotto, winningNumbers, bonusNumber);

        assertEquals(1, statistics.getCount(Prize.THREE), "Prize THREE count should be incremented by 1.");
    }

    @Test
    void 네_개_일치하는_로또가_존재할_때_통계가_정확히_증가하는지_확인한다() {
        List<List<Integer>> allIssuedLotto = List.of(
                List.of(1, 2, 3, 4, 20, 30)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 41, 42);
        int bonusNumber = 45;

        statisticsCalculator.calculateStatistics(allIssuedLotto, winningNumbers, bonusNumber);

        assertEquals(1, statistics.getCount(Prize.FOUR), "Prize FOUR count should be incremented by 1.");
    }

    @Test
    void 다섯_개_일치하고_보너스_일치하지_않는_경우_통계가_정확히_증가하는지_확인한다() {
        List<List<Integer>> allIssuedLotto = List.of(
                List.of(1, 2, 3, 4, 5, 30)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 42);
        int bonusNumber = 45;

        statisticsCalculator.calculateStatistics(allIssuedLotto, winningNumbers, bonusNumber);

        assertEquals(1, statistics.getCount(Prize.FIVE), "Prize FIVE count should be incremented by 1.");
    }

    @Test
    void 다섯_개_일치하고_보너스_일치하는_경우_통계가_정확히_증가하는지_확인한다() {
        List<List<Integer>> allIssuedLotto = List.of(
                List.of(1, 2, 3, 4, 5, 30)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 42);
        int bonusNumber = 30;

        statisticsCalculator.calculateStatistics(allIssuedLotto, winningNumbers, bonusNumber);

        assertEquals(1, statistics.getCount(Prize.FIVE_AND_BONUS), "Prize FIVE_AND_BONUS count should be incremented by 1.");
    }

    @Test
    void 여섯_개_일치하는_로또가_존재할_때_통계가_정확히_증가하는지_확인한다() {
        List<List<Integer>> allIssuedLotto = List.of(
                List.of(1, 2, 3, 4, 5, 6)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 30;

        statisticsCalculator.calculateStatistics(allIssuedLotto, winningNumbers, bonusNumber);

        assertEquals(1, statistics.getCount(Prize.SIX), "Prize SIX count should be incremented by 1.");
    }
}
