package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("1등 당첨 통계 계산 테스트")
    void 일등_당첨_통계_계산_테스트() {
        List<Lotto> lottoTickets = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> statistics = Application.calculateStatistics(lottoTickets, winningNumbers, bonusNumber);

        Map<Rank, Integer> expectedStatistics = new EnumMap<>(Rank.class);
        expectedStatistics.put(Rank.FIRST, 1);

        assertThat(statistics).isEqualTo(expectedStatistics);
    }

    @Test
    @DisplayName("2등 당첨 통계 계산 테스트")
    void 이등_당첨_통계_계산_테스트() {
        List<Lotto> lottoTickets = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> statistics = Application.calculateStatistics(lottoTickets, winningNumbers, bonusNumber);

        Map<Rank, Integer> expectedStatistics = new EnumMap<>(Rank.class);
        expectedStatistics.put(Rank.SECOND, 1);

        assertThat(statistics).isEqualTo(expectedStatistics);
    }

    @Test
    @DisplayName("3등 당첨 통계 계산 테스트")
    void 삼등_당첨_통계_계산_테스트() {
        List<Lotto> lottoTickets = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> statistics = Application.calculateStatistics(lottoTickets, winningNumbers, bonusNumber);

        Map<Rank, Integer> expectedStatistics = new EnumMap<>(Rank.class);
        expectedStatistics.put(Rank.THIRD, 1);

        assertThat(statistics).isEqualTo(expectedStatistics);
    }

    @Test
    @DisplayName("4등 당첨 통계 계산 테스트")
    void 사등_당첨_통계_계산_테스트() {
        List<Lotto> lottoTickets = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11))
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> statistics = Application.calculateStatistics(lottoTickets, winningNumbers, bonusNumber);

        Map<Rank, Integer> expectedStatistics = new EnumMap<>(Rank.class);
        expectedStatistics.put(Rank.FOURTH, 1);

        assertThat(statistics).isEqualTo(expectedStatistics);
    }

    @Test
    @DisplayName("5등 당첨 통계 계산 테스트")
    void 오등_당첨_통계_계산_테스트() {
        List<Lotto> lottoTickets = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 20, 21, 22))
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> statistics = Application.calculateStatistics(lottoTickets, winningNumbers, bonusNumber);

        Map<Rank, Integer> expectedStatistics = new EnumMap<>(Rank.class);
        expectedStatistics.put(Rank.FIFTH, 1);

        assertThat(statistics).isEqualTo(expectedStatistics);
    }

    @Test
    @DisplayName("당첨되지 않은 경우 통계 계산 테스트")
    void 당첨되지_않은_경우_통계_계산_테스트() {
        List<Lotto> lottoTickets = List.of(
                new Lotto(Arrays.asList(10, 20, 30, 40, 41, 42))
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> statistics = Application.calculateStatistics(lottoTickets, winningNumbers, bonusNumber);

        Map<Rank, Integer> expectedStatistics = new EnumMap<>(Rank.class);
        expectedStatistics.put(Rank.NONE, 1);

        assertThat(statistics).isEqualTo(expectedStatistics);
    }

    @Test
    @DisplayName("당첨 통계가 있는 경우 수익률을 올바르게 계산")
    public void 수익률_계산_테스트_당첨_있는_경우() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        statistics.put(Rank.FIFTH, 1);  // 3개 일치 (5,000원) - 1개
        statistics.put(Rank.FOURTH, 0);
        statistics.put(Rank.THIRD, 0);
        statistics.put(Rank.SECOND, 0);
        statistics.put(Rank.FIRST, 0);

        int purchaseAmount = 8000;

        double expectedYield = 62.5;

        double actualYield = Application.calculateYield(statistics, purchaseAmount);
        assertThat(actualYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("당첨 통계가 없는 경우 수익률을 올바르게 계산")
    public void 수익률_계산_테스트_당첨_없는_경우() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        statistics.put(Rank.FIFTH, 0);
        statistics.put(Rank.FOURTH, 0);
        statistics.put(Rank.THIRD, 0);
        statistics.put(Rank.SECOND, 0);
        statistics.put(Rank.FIRST, 0);

        int purchaseAmount = 8000;

        double expectedYield = 0.0;

        double actualYield = Application.calculateYield(statistics, purchaseAmount);
        assertThat(actualYield).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("여러 등수에서 당첨된 경우 수익률을 올바르게 계산")
    public void 수익률_계산_테스트_여러_등수_당첨_경우() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        statistics.put(Rank.FIFTH, 2);
        statistics.put(Rank.FOURTH, 1);
        statistics.put(Rank.THIRD, 0);
        statistics.put(Rank.SECOND, 0);
        statistics.put(Rank.FIRST, 0);

        int purchaseAmount = 10000;

        double expectedYield = 600.0;

        double actualYield = Application.calculateYield(statistics, purchaseAmount);
        assertThat(actualYield).isEqualTo(expectedYield);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
