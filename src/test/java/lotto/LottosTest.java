package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    public void 로또_당첨_순위_확인() {
        //given
        Map<Rank, Integer> testWinningStatistics = new HashMap<>();
        testWinningStatistics.put(Rank.ETC, 1);

        WinningStatisticsDto expectedWinningStatisticsDto
                = new WinningStatisticsDto(testWinningStatistics);

        WinningLotto testWinningLotto
                = WinningLotto.of(List.of(50, 51, 52, 53, 54, 55), 56);

        //when
        Lottos testLottos = Lottos.generateLottosByCount(1);
        WinningStatisticsDto actualWinningStatisticsDto
                = testLottos.calculateWinningResults(testWinningLotto);
        //then
        assertTrue(expectedWinningStatisticsDto.getWinningStatistics().entrySet()
                .equals(actualWinningStatisticsDto.getWinningStatistics().entrySet()));
    }
}