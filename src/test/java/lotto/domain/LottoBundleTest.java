package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;
    private static final String ERROR_PREFIX = "[ERROR]";

    @Test
    void 로또_번들의_로또의_수와_구매_금액에_대한_로또_개수가_다르다면_예외가_발생한다(){
        int purchasePrice = 1000;
        LottoPurchasePrice lottoPurchasePrice = LottoPurchasePrice.ofPurchasePriceAndConfig(purchasePrice, CONFIG);
        List<Lotto> lottos = List.of();

        assertThatThrownBy(() -> LottoBundle.ofLottosAndPurchasePrice(lottos, lottoPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_BUNDLE_LOTTOS_COUNT_INVALID.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }
}
