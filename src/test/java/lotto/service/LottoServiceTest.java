package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.PrizeTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @BeforeEach
    @DisplayName("당첨 카운트 초기화")
    void resetWinningCounts() throws Exception {
        for (PrizeTable prizeTable : PrizeTable.values()) {
            Field field = prizeTable.getClass().getDeclaredField("winningCount");
            field.setAccessible(true);
            field.set(prizeTable, 0);
        }
    }

    @Test
    @DisplayName("총 상금을 계산하여 반환")
    void 로또_서비스_테스트_총상금_반환() {
        List<Lotto> lottos = mockLottos();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int expect = 5000;

        int result = lottoService.getTotalPrizeMoney(lottos, winningNumbers, bonusNumber);

        assertEquals(expect, result);
    }

    @Test
    @DisplayName("구매 개수를 받아 로또들을 리스트로 반환")
    void 로또_서비스_테스트_로또_리스트_반환() {
        int purchaseMoney = 8000;
        int expectedLottoCount = purchaseMoney / Lotto.PRICE;

        List<Lotto> lottos = lottoService.getLottos(purchaseMoney);

        assertEquals(expectedLottoCount, lottos.size());

        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
        }
    }

    private List<Lotto> mockLottos() {
        return List.of(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
        );
    }
}
