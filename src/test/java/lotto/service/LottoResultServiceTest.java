package lotto.service;

import lotto.model.Lotto;
import lotto.model.WinningStatistic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultServiceTest {

    private LottoResultService lottoResultService;
    private Lotto winningLotto;

    @BeforeEach
    public void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoResultService = new LottoResultService(Arrays.asList(
                winningLotto,
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 13, 14, 15, 16))
        ), winningLotto, 0);
    }

    @Test
    public void testCountMatchingNumbers_AllMatch() {
        Lotto testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = lottoResultService.countMatchingNumbers(testLotto, winningLotto);
        assertEquals(6, matchCount, "모든 번호가 일치해야 합니다.");
    }

    @Test
    public void testCountMatchingNumbers_NoMatch() {
        Lotto testLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        int matchCount = lottoResultService.countMatchingNumbers(testLotto, winningLotto);
        assertEquals(0, matchCount, "일치하는 번호가 없어야 합니다.");
    }

    @Test
    public void testCountMatchingNumbers_PartialMatch() {
        Lotto testLotto = new Lotto(Arrays.asList(1, 2, 13, 14, 15, 16));
        int matchCount = lottoResultService.countMatchingNumbers(testLotto, winningLotto);
        assertEquals(2, matchCount, "2개의 번호가 일치해야 합니다.");
    }

    @Test
    public void 정상적_당첨통계객체_생성_확인(){
        List<WinningStatistic> statistics = lottoResultService.generateWinningStatistics();
        for(WinningStatistic winningStatistic : statistics){
            System.out.println(winningStatistic.presentStatus());
        }
    }
}
