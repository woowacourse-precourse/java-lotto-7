package lotto.model;

import java.util.List;
import lotto.enums.WinningType;
import org.junit.jupiter.api.Test;

class WinningStatisticTest {

    @Test
    void 로또_목록과_당첨_번호로_당첨_통계를_생성한다() {

        Lottos lottos;
        lottos = Lottos.createLottos(4);

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");

        WinningStatistic winningStatistic =
            WinningStatistic.createWinningStatistic(winningNumbers, lottos);

        List<WinningType> actualStatistics = winningStatistic.getWinningStatistic();
        System.out.println("결과:" + actualStatistics);
    }
}
