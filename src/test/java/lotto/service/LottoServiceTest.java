package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.TestNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("8,000원을 투자해 5,000원의 이익이 발생하면 수익률은 62.5%이다.")
    void 수익률을_계산한다() {
        // given
        BigDecimal purchaseAmount = BigDecimal.valueOf(8_000);
        LottoPurchaseInfo purchaseInfo = new LottoPurchaseInfo(purchaseAmount, List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResult lottoResult = new LottoResult();
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        rankCounts.put(LottoRank.NONE, 0);
        rankCounts.put(LottoRank.FIFTH, 1);
        rankCounts.put(LottoRank.FOURTH, 0);
        rankCounts.put(LottoRank.THIRD, 0);
        rankCounts.put(LottoRank.SECOND, 0);
        rankCounts.put(LottoRank.FIRST, 0);
        lottoResult.getRankCounts()
                   .putAll(rankCounts);

        // when
        BigDecimal returnOnInvestment = lottoService.calculateReturnOnInvestment(purchaseInfo, lottoResult);

        // then
        assertThat(returnOnInvestment).isEqualTo("62.5");
    }

    @Test
    @DisplayName("꽝 7개, 5등 당첨 1개")
    void 로또_결과를_계산한다() {
        // given
        Map<LottoRank, Integer> expectedRankCounts = new EnumMap<>(LottoRank.class);
        expectedRankCounts.put(LottoRank.NONE, 7);
        expectedRankCounts.put(LottoRank.FIFTH, 1);
        expectedRankCounts.put(LottoRank.FOURTH, 0);
        expectedRankCounts.put(LottoRank.THIRD, 0);
        expectedRankCounts.put(LottoRank.SECOND, 0);
        expectedRankCounts.put(LottoRank.FIRST, 0);

        List<List<Integer>> testNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(testNumbers);
        BigDecimal purchaseQuantity = BigDecimal.valueOf(testNumbers.size());
        Lottos lottos = Lottos.of(purchaseQuantity, testNumberGenerator);

        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // When
        LottoResult lottoResult = lottoService.calculateLottoResult(lottos, userLotto, bonusNumber);

        // Then
        assertThat(lottoResult.getRankCounts()).isEqualTo(expectedRankCounts);
    }

    @Test
    @DisplayName("구입 금액이 8,000원이면 로또 수량은 8개이다.")
    void 구입_금액에_따른_로또_수량_계산() {
        // given
        BigDecimal purchaseAmount = BigDecimal.valueOf(8000);

        // when
        BigDecimal purchaseQuantity = lottoService.calculatePurchaseQuantity(purchaseAmount);

        // then
        assertThat(purchaseQuantity).isEqualTo("8");
    }
}
