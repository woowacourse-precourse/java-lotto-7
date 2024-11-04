package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultServiceTest {
    private LottoResultService lottoResultService;

    @BeforeEach
    public void setUp() {
        lottoResultService = new LottoResultService();
    }

    @Test
    public void testCalculateWinningResults_FirstPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(Rank.FIRST), "1등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_SecondPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(Rank.SECOND), "2등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_ThirdPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(Rank.THIRD), "3등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_FourthPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 9;

        Map<Rank, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(Rank.FOURTH), "4등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_FifthPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        Map<Rank, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(Rank.FIFTH), "5등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_NoWin() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(10, 20, 30, 40, 41, 42)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(0, results.getOrDefault(Rank.FIRST, 0), "1등 당첨은 없어야 합니다.");
        assertEquals(0, results.getOrDefault(Rank.SECOND, 0), "2등 당첨은 없어야 합니다.");
        assertEquals(0, results.getOrDefault(Rank.THIRD, 0), "3등 당첨은 없어야 합니다.");
        assertEquals(0, results.getOrDefault(Rank.FOURTH, 0), "4등 당첨은 없어야 합니다.");
        assertEquals(0, results.getOrDefault(Rank.FIFTH, 0), "5등 당첨은 없어야 합니다.");
    }

    @Test
    public void testCalculateTotalPrize() {
        Map<Rank, Integer> resultCount = Map.of(
                Rank.FIRST, 1, // 1등 1장
                Rank.THIRD, 2, // 3등 2장
                Rank.FOURTH, 3, // 4등 3장
                Rank.FIFTH, 4  // 5등 4장
        );

        int totalPrize = lottoResultService.calculateTotalPrize(resultCount);
        int expectedPrize = (1 * Rank.FIRST.getPrize()) +
                (2 * Rank.THIRD.getPrize()) +
                (3 * Rank.FOURTH.getPrize()) +
                (4 * Rank.FIFTH.getPrize());

        assertEquals(expectedPrize, totalPrize, "총 당첨 금액이 올바르지 않습니다.");
    }
}
