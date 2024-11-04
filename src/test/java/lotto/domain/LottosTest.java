package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 개수에 맞게 로또를 발행하는지 확인한다.")
    void validateLottoTotalCount() {
        int purchaseAmount = LottoPurchaseAmount.from("8000").getPurchaseAmount();
        int lottoCount = LottoCount.from(purchaseAmount).getLottoCount();
        int lottoListSize = Lottos.from(lottoCount).getLottos().size();

        assertThat(lottoListSize).isEqualTo(lottoCount);
    }

}