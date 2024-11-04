package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import lotto.enums.Prize;
import lotto.model.Lotto;
import lotto.model.LottoResultChecker;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultCheckerTest {
    private WinningNumbers winningNumbers;
    private LottoResultChecker resultChecker;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");
        resultChecker = new LottoResultChecker(winningNumbers);
    }

    @Test
    void 당첨_기준을_모두_확인한다() {
        Lottos lottos = new Lottos(5, Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // FIRST
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // THIRD
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // FOURTH
                new Lotto(Arrays.asList(1, 2, 3, 12, 13, 14)) // FIFTH
        ));
        Map<Prize, Integer> results = resultChecker.getLottosWinningResult(lottos);

        assertThat(results.get(Prize.FIRST)).isEqualTo(1);
        assertThat(results.get(Prize.SECOND)).isEqualTo(1);
        assertThat(results.get(Prize.THIRD)).isEqualTo(1);
        assertThat(results.get(Prize.FOURTH)).isEqualTo(1);
        assertThat(results.get(Prize.FIFTH)).isEqualTo(1);
    }

    @Test
    public void 상금_금액을_확인한다() {
        assertThat(Prize.FIRST.getPrizeAmount()).isEqualTo(2000000000);
        assertThat(Prize.SECOND.getPrizeAmount()).isEqualTo(30000000);
        assertThat(Prize.THIRD.getPrizeAmount()).isEqualTo(1500000);
        assertThat(Prize.FOURTH.getPrizeAmount()).isEqualTo(50000);
        assertThat(Prize.FIFTH.getPrizeAmount()).isEqualTo(5000);
    }


    @Test
    public void 당첨이_없는_결과를_확인한다() {
        Lottos lottos = new Lottos(2, Arrays.asList(
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)),
                new Lotto(Arrays.asList(14, 15, 16, 17, 18, 19))
        ));

        Map<Prize, Integer> results = resultChecker.getLottosWinningResult(lottos);

        for (Prize prize : Prize.values()) {
            assertThat(results.get(prize)).isEqualTo(0);
        }
    }
}
