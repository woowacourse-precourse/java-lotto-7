package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

        Map<Integer, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(6), "1등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_SecondPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Integer, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(5), "2등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_ThirdPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Integer, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(5), "3등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_FourthPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 9;

        Map<Integer, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(4), "4등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_FifthPlace() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        Map<Integer, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, results.get(3), "5등 당첨은 1장이어야 합니다.");
    }

    @Test
    public void testCalculateWinningResults_NoWin() {
        List<Lotto> purchasedLottos = List.of(new Lotto(Arrays.asList(10, 20, 30, 40, 41, 42)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Integer, Integer> results = lottoResultService.calculateWinningResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(0, results.get(6), "1등 당첨은 없어야 합니다.");
        assertEquals(0, results.get(5), "2등 당첨은 없어야 합니다.");
        assertEquals(0, results.get(4), "4등 당첨은 없어야 합니다.");
        assertEquals(0, results.get(3), "5등 당첨은 없어야 합니다.");
    }

    @Test
    public void testCalculateTotalPrize() {
        Map<Integer, Integer> resultCount = Map.of(
                6, 1, // 1등 1장
                5, 2, // 3등 2장
                4, 3, // 4등 3장
                3, 4  // 5등 4장
        );

        int totalPrize = lottoResultService.calculateTotalPrize(resultCount);
        int expectedPrize = (1 * 2_000_000_000) + (2 * 1_500_000) + (3 * 50_000) + (4 * 5_000);

        assertEquals(expectedPrize, totalPrize, "총 당첨 금액이 올바르지 않습니다.");
    }
}
