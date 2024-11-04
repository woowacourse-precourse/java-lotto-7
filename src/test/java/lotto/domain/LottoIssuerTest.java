package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @DisplayName("구입 금액에 맞게 로또 발행에 성공한다.")
    @Test
    void 구입_금액_로또_발행_성공() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(14000);
        LottoNumberGenerator lottoNumberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

        Lottos lottos = LottoIssuer.issue(purchaseAmount, lottoNumberGenerator);

        assertThat(lottos.getLottos()).hasSize(14);
    }

}