package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;

    @Test
    void 로또_번들의_로또의_수와_구매_금액에_대한_로또_개수가_다르다면_예외가_발생한다() {
        int purchasePrice = 1000;
        LottoPurchasePrice lottoPurchasePrice = LottoPurchasePrice.ofPurchasePriceAndConfig(purchasePrice, CONFIG);
        List<Lotto> lottos = List.of();

        assertThatThrownBy(() -> LottoBundle.ofLottosAndPurchasePrice(lottos, lottoPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_BUNDLE_LOTTOS_COUNT_INVALID.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }


    @DisplayName("주어진 로또들과 동일한 값을 반환해야 한다.")
    @Test
    void getLottos() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> expectedLottos = List.of(Lotto.ofNumbersAndConfig(numbers, CONFIG));
        LottoPurchasePrice lottoPurchasePrice =
                LottoPurchasePrice.ofPurchasePriceAndConfig(CONFIG.getLottoPrice(), CONFIG);

        // when
        LottoBundle lottoBundle = LottoBundle.ofLottosAndPurchasePrice(expectedLottos, lottoPurchasePrice);
        List<Lotto> actualLottos = lottoBundle.getLottos();

        // then
        assertThat(actualLottos).usingRecursiveComparison().isEqualTo(expectedLottos);
    }

    /*
    1. 로또들의 순위를 매긴다.
    2. 로또들의 상금 총합을 계산한다.
    3. 로또 수익률을 계산한다.
    4. 로또 결과를 생성하여 반환한다.
     */
    @DisplayName("정확하게 로또 당첨 카운트와 수익률을 계산해야 한다.")
    @Test
    void makeLottoResult() {
        // given
        LottoPurchasePrice lottoPurchasePrice = createPurchasePrice(CONFIG.getLottoPrice());
        WinningLotto winningLotto = createWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = createBonusNumber(10, winningLotto);
        List<Lotto> lottos = List.of(createLotto(List.of(1, 2, 3, 7, 8, 9)));

        Map<LottoRank, Integer> expectedLottoRankCount = initLottoRankCount();
        expectedLottoRankCount.put(LottoRank.FIFTH_PLACE, 1);
        LottoResult expectedLottoResult = LottoResult.ofRankCountAndProfitRate(expectedLottoRankCount, 500.0);

        // when
        LottoBundle lottoBundle = LottoBundle.ofLottosAndPurchasePrice(lottos, lottoPurchasePrice);
        LottoResult actualLottoResult = lottoBundle.makeLottoResult(winningLotto, bonusNumber);

        // then
        assertThat(actualLottoResult).isEqualTo(expectedLottoResult);
    }

    private LottoPurchasePrice createPurchasePrice(int purchasePrice) {
        return LottoPurchasePrice.ofPurchasePriceAndConfig(purchasePrice, CONFIG);
    }

    private WinningLotto createWinningLotto(List<Integer> winningNumbers) {
        return WinningLotto.ofNumbersAndConfig(winningNumbers, CONFIG);
    }

    private BonusNumber createBonusNumber(int bonusNumber, WinningLotto winningLotto) {
        return BonusNumber.ofNumberAndWinningLottoAndConfig(bonusNumber, winningLotto, CONFIG);
    }

    private Lotto createLotto(List<Integer> numbers) {
        return Lotto.ofNumbersAndConfig(numbers, CONFIG);
    }

    private Map<LottoRank, Integer> initLottoRankCount() {
        return Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(lottoRank -> lottoRank, lottoRank -> 0));
    }
}
