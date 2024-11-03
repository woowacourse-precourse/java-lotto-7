package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    List<Lotto> lottos = List.of(
            new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
            new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
            new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
            new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
            new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
            new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
            new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
            new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
    );
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    @DisplayName("총 상금을 계산하여 반환")
    @Test
    void getTotalPrizeMoney() {

        int expect = 5000;
        int result = lottoService.getTotalPrizeMoney(lottos, winningNumbers, bonusNumber);

        Assertions.assertEquals(expect, result);
    }

    @DisplayName("구매 개수를 받아 로또들을 리스트로 반환")
    @Test
    void getLottos() {
        List<Lotto> lottos = lottoService.getLottos(8);

        Assertions.assertEquals(8, lottos.size());

        for (Lotto lotto : lottos) {
            Assertions.assertEquals(6, lotto.getNumbers().size());
        }
    }
}