package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoConfiguration;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssueServiceTest {

    private LottoIssueService lottoIssueService;

    @BeforeEach
    void beforeEach() {
        lottoIssueService = new LottoIssueService();
    }

    @DisplayName("금액에_따라_로또_발행")
    @Test
    void 금액에_따라_로또_발행() {
        int expectedLottoCount = 10;
        PurchasePrice inputPurchasePrice = new PurchasePrice(LottoConfiguration.LOTTO_PRICE * expectedLottoCount);

        List<Lotto> actualLotto = lottoIssueService.issueLotto(inputPurchasePrice);

        assertThat(actualLotto.size()).isEqualTo(expectedLottoCount);
    }
}