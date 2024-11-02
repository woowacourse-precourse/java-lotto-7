package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import lotto.enums.WinningType;
import java.util.Arrays;
import java.util.List;

class WinningStatisticTest {

    @Test
    void 로또_목록과_당첨_번호로_당첨_통계를_생성한다() {

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); 
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); 
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)); 
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 12, 13)); 
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13));

        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5));

        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6","7");

        WinningStatistic winningStatistic = WinningStatistic.createWinningStatistic(winningNumbers, lottos);


        List<WinningType> expectedStatistics = Arrays.asList(
            WinningType.FIRST_PLACE,
            WinningType.SECOND_PLACE,
            WinningType.THIRD_PLACE,
            WinningType.FOURTH_PLACE,
            WinningType.FIFTH_PLACE
        );

        assertThat(winningStatistic.getWinningStatistic()).containsExactlyElementsOf(expectedStatistics);
    }
}