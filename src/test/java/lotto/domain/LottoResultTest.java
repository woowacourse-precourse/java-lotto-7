package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private Lotto lotto;

    @BeforeEach
    public void setUp() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lotto = new Lotto(winningNumbers);
        lotto.addBonusNumber("7");
    }

    @Test
    public void testLottoResultCreation() {

        List<PurchaseLotto> purchaseLottos = List.of(
                new PurchaseLotto(List.of(1, 2, 3, 4, 5, 6)),
                new PurchaseLotto(List.of(1, 2, 3, 4, 5, 7)),
                new PurchaseLotto(List.of(1, 2, 3, 4, 5, 8))
        );

        LottoResult lottoResult = new LottoResult(purchaseLottos, lotto);

        Map<WinningType, Integer> result = lottoResult.getLottoResult();
        assertThat(result.get(WinningType.SIX_MATCH)).isEqualTo(1);
        assertThat(result.get(WinningType.FIVE_MATCH_WITH_BONUS)).isEqualTo(1);
        assertThat(result.get(WinningType.FIVE_MATCH)).isEqualTo(1);
    }

    @Test
    public void testCalculateTotalPrize() {

        List<PurchaseLotto> purchaseLottos = List.of(
                new PurchaseLotto(List.of(1, 2, 3, 4, 5, 6)),
                new PurchaseLotto(List.of(1, 2, 3, 4, 5, 7)),
                new PurchaseLotto(List.of(1, 2, 3, 4, 5, 8))
        );

        LottoResult lottoResult = new LottoResult(purchaseLottos, lotto);

        int totalPrize = lottoResult.calculateTotalPrize();
        int expectedPrize = WinningType.SIX_MATCH.getPrize() + WinningType.FIVE_MATCH_WITH_BONUS.getPrize() + WinningType.FIVE_MATCH.getPrize();
        assertThat(totalPrize).isEqualTo(expectedPrize);
    }

}