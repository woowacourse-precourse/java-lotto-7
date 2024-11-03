package lotto.service;

import lotto.domain.PurchasedLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService(new DefaultLottoResultCalculator(), new RandomUniqueLottoNumGenerator());

    @Test
    void 로또번호_발행() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    PurchasedLotto purchasedLotto = lottoService.issueLottoNumAsPurchaseQuantity(3);
                    assertThat(purchasedLotto.getPurchasedLottos().size()).isEqualTo(3);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }
}
