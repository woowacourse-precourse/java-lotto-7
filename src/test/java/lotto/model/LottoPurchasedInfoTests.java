package lotto.model;

import static lotto.util.constants.LottoConstants.LOTTO_TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchasedInfoTests {

    private LottoPurchasedInfo lottoPurchasedInfo;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    @BeforeEach
    void setup() {
        List<Lotto> purchasedSample = List.of(
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)));

        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;

        lottoPurchasedInfo = new LottoPurchasedInfo(purchasedSample, purchasedSample.size()*LOTTO_TICKET_PRICE);
        lottoPurchasedInfo.getWinningResult(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("당첨된 복권의 개수를 등수별로 그룹화")
    void groupByLottoRankTest() {
        Map<LottoRank, Long> expected = Map.of(LottoRank.NONE, 1L, LottoRank.FIFTH, 1L);
        Map<LottoRank, Long> result = lottoPurchasedInfo.getWinningResult(winningNumbers, bonusNumber);

        assertEquals(result, expected);
    }

    @Test
    @DisplayName("당첨된 복권으로 얻은 수익의 총합을 계산")
    void calculateTotalProfitTest() {
        Long expected = 5000L;

        assertEquals(lottoPurchasedInfo.calculateTotalProfit(), expected);
    }

    @Test
    @DisplayName("당첨된 복권으로 얻은 총 수익률을 계산")
    void calculateProfitPercentageTest() {
        Double expected = 250.0;

        Double result = lottoPurchasedInfo.calculateProfitPercentage();
        assertEquals(result, expected);
    }
}