package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.enums.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDispenserTest {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;
    private static final LottoDispenser LOTTO_DISPENSER = LottoDispenser.fromConfig(CONFIG);
    private static final List<List<Integer>> RANDOM_NUMBERS = List.of(
            List.of(1, 2, 3, 4, 5, 6), List.of(1, 3, 5, 7, 9, 11), List.of(2, 4, 6, 8, 10, 12));


    @DisplayName("issueLottoBundle() 기능 테스트")
    @Test
    void issueLottoBundle() {
        // given
        int lottoCount = 3;
        List<Lotto> lottos = generateLottos(lottoCount);
        LottoPurchasePrice lottoPurchasePrice =
                LottoPurchasePrice.ofPurchasePriceAndConfig(CONFIG.getLottoPrice() * lottoCount, CONFIG);
        LottoBundle expectedLottoBundle = LottoBundle.ofLottosAndPurchasePrice(lottos, lottoPurchasePrice);

        // when
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoBundle actualLottoBundle = LOTTO_DISPENSER.issueLottoBundle(lottoPurchasePrice);

            // then
            assertThat(actualLottoBundle).isEqualTo(expectedLottoBundle);


        }, RANDOM_NUMBERS.get(0), RANDOM_NUMBERS.get(1), RANDOM_NUMBERS.get(2));

    }

    private List<Lotto> generateLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.ofNumbersAndConfig(RANDOM_NUMBERS.get(i), CONFIG))
                .collect(Collectors.toList());
    }
}
