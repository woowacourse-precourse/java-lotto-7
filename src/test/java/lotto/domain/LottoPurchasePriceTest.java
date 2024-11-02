package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.api.Test;

public class LottoPurchasePriceTest {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;

    @Test
    void 로또_구입_금액이_로또_가격으로_나누어떨어지지_않는다면_예외가_발생한다() {
        int purchasePrice = CONFIG.getLottoPrice() - 1;

        assertThatThrownBy(() -> LottoPurchasePrice.ofPurchasePriceAndConfig(purchasePrice, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_구입_금액이_최대_로또_구입금액_이상이라면_예외가_발생한다() {
        int purchasePrice = CONFIG.getLottoPurchasePriceMax();

        assertThatThrownBy(() -> LottoPurchasePrice.ofPurchasePriceAndConfig(purchasePrice, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_PURCHASE_PRICE_MORE_THAN_MAX.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_구입_금액이_최소_로또_구입금액_미만이라면_예외가_발생한다(){
        int purchasePrice = CONFIG.getLottoNumberMin()-1;

        assertThatThrownBy(() -> LottoPurchasePrice.ofPurchasePriceAndConfig(purchasePrice, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_PURCHASE_PRICE_LESS_THAN_MIN.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }
}
