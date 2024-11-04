package lotto.service;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningChecker;
import lotto.repository.InMemoryLottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoDrawServiceTest {

    private LottoDrawService lottoDrawService;
    private InMemoryLottoRepository lottoRepository;

    @BeforeEach
    public void setUp() {
        lottoDrawService = new LottoDrawService();
        lottoRepository = new InMemoryLottoRepository();
    }

    @Test
    @DisplayName("checkWinning 메소드 테스트")
    public void testCheckWinning() {
        Bonus bonus = new Bonus(7, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<List<Integer>> userLottoNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6), // 1등
                Arrays.asList(1, 2, 3, 4, 5, 7), // 2등
                Arrays.asList(1, 2, 3, 4, 5, 10) // 3등
        );

        lottoRepository.saveBonusNumbers(bonus);
        lottoRepository.saveWinningNumbers(winningLotto);
        lottoRepository.saveUserLottoNumbers(userLottoNumbers);

        Map<String, Integer> expectedResults = LottoRank.LottoRankCollector();
        expectedResults.put("FIRST", 1);
        expectedResults.put("SECOND", 1);
        expectedResults.put("THIRD", 1);

        Map<String, Integer> actualResults = lottoDrawService.checkWinning(lottoRepository);

        assertEquals(expectedResults, actualResults, "당첨 결과가 틀렸습니다.");
    }

    @Test
    @DisplayName("calculateRate 메소드 테스트")
    public void testCalculateRate() {
        Map<String, Integer> matchingResult = new HashMap<>();
        matchingResult.put("FIRST", 1);
        matchingResult.put("SECOND", 0);
        matchingResult.put("THIRD", 1);
        matchingResult.put("FOURTH", 0);
        matchingResult.put("FIFTH", 0);

        int numberOfTickets = 2;

        double expectedRate = new WinningChecker().calculateReturn(matchingResult, numberOfTickets);

        double actualRate = lottoDrawService.calculateRate(matchingResult, numberOfTickets);

        assertEquals(expectedRate, actualRate, "수익률이 틀렸습니다.");
    }
}
