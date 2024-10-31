package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "8000", "100000"})
    @DisplayName("구입 금액에 따라 로또 발행 개수를 확인한다.")
    void validateLottoCount(String input) {
        int lottoPrice = 1000;
        int purchaseAmount = LottoPurchaseAmount.from(input).getPurchaseAmount();
        int lottoCount = LottoCount.from(purchaseAmount).getLottoCount();

        assertThat(lottoCount).isEqualTo(purchaseAmount / lottoPrice);
    }

}