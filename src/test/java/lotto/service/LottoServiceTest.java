package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
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
