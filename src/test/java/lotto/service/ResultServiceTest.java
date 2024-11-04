package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultServiceTest {

    private final ResultService resultService = new ResultService();
    private final LottoService lottoService = new LottoService();
    private final WinningLottoService winningLottoService = new WinningLottoService();
    private static final int PRICE = LottoService.PRICE;

    @Test
    void 숫자가_아닌_값이_포함된_입력_예외_확인() {
        String invalidInput = "1, 2, a, 4, 5, 6";

        assertThrows(IllegalArgumentException.class, () -> winningLottoService.parseLotto(invalidInput),
                "[ERROR] 숫자가 아닌 값이 포함되어있습니다.");
    }

    @Test
    void 결과_계산_테스트() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(List.of(1, 2, 3, 20, 21, 22)) // 5등
        );

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        Result result = resultService.calculateResult(userLottos, winningLotto);

        Map<Rank, Integer> matchCount = result.getMatchCount();
        assertEquals(1, matchCount.get(Rank.FIRST), "1등 개수가 맞지 않습니다.");
        assertEquals(1, matchCount.get(Rank.SECOND), "2등 개수가 맞지 않습니다.");
        assertEquals(1, matchCount.get(Rank.THIRD), "3등 개수가 맞지 않습니다.");
        assertEquals(1, matchCount.get(Rank.FOURTH), "4등 개수가 맞지 않습니다.");
        assertEquals(1, matchCount.get(Rank.FIFTH), "5등 개수가 맞지 않습니다.");
        assertEquals(0, matchCount.get(Rank.NONE), "낙첨 개수가 맞지 않습니다.");
    }

    @Test
    void 총_상금_계산_테스트() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7))  // 2등
        );

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Result result = resultService.calculateResult(userLottos, winningLotto);

        int totalPrize = Rank.FIRST.getPrize() + Rank.SECOND.getPrize();
        assertEquals(totalPrize, result.getTotalPrize(), "총 상금이 올바르게 계산되어야 합니다.");
    }

    @Test
    void 수익률_계산_테스트() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등 당첨용
                new Lotto(List.of(7, 8, 9, 10, 11, 12)) // 낙첨용
        );

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Result result = resultService.calculateResult(userLottos, winningLotto);

        int totalSpent = userLottos.size() * PRICE;
        double expectedProfitRate = (double) Rank.FIRST.getPrize() / totalSpent * 100;

        assertEquals(expectedProfitRate, result.getProfitRate(), 0.01, "수익률이 올바르게 계산되어야 합니다.");
    }
}
