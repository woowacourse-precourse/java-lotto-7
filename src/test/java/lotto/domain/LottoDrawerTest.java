package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lotto.LottoDrawer;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.NumbersGenerator;
import lotto.domain.lotto.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawerTest {

    @DisplayName("올바른 개수의 랜덤 로또를 발행한다.")
    @Test
    void generateLottosTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
        NumbersGenerator fixedNumbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        LottoDrawer lottoDrawer = new LottoDrawer(purchaseAmount, fixedNumbersGenerator);

        LottoTicket lottoTicket = lottoDrawer.generateLottos();

        lottoTicket.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6))
        );
    }
}
