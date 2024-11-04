package lotto;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("로또 구입 금액에 따라 올바른 개수의 로또가 생성된다.")
    @Test
    void purchaseLottos_createsCorrectNumberOfLottos() {
        int purchaseAmount = 5000;  // 5장 구매 가능
        int expectedNumberOfLottos = 5;

        assertThat(lottoService.purchaseLottos(purchaseAmount))
                .hasSize(expectedNumberOfLottos)
                .allMatch(lotto -> lotto.getNumbers().size() == 6); // 각 로또에 6개의 숫자가 있어야 함
    }
}
