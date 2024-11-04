package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import lotto.utils.ProfitCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    private LottoResult lottoResult;

    @BeforeEach
    void init() {
        lottoResult = LottoResult.create();
    }

    @DisplayName("5등 당첨 1회 및 8000원의 복권을 샀을 경우, 수익률은 62.5 이어야 한다.")
    @Test
    void fifth_place_test() {
        //given
        lottoResult.increaseWinningCount(WinningPrice.FIFTH_PLACE);
        Map<WinningPrice, Integer> result = lottoResult.getResult();
        int purchaseAmount = 8_000;
        String expectedRate = "62.5";
        //when
        String rate = ProfitCalculator.rate(result, purchaseAmount);
        //then
        assertThat(rate).isEqualTo(expectedRate);
    }

    @DisplayName("5등 당첨 5회 및 8000원의 복권을 샀을 경우, 수익률은 312.5 이어야 한다.")
    @Test
    void fifth_place_3_time_test() {
        //given
        for (int i = 0; i < 5; i++) {
            lottoResult.increaseWinningCount(WinningPrice.FIFTH_PLACE);
        }
        Map<WinningPrice, Integer> result = lottoResult.getResult();
        int purchaseAmount = 8_000;
        String expectedRate = "312.5";
        //when
        String rate = ProfitCalculator.rate(result, purchaseAmount);
        //then
        assertThat(rate).isEqualTo(expectedRate);
    }

    @DisplayName("1등 당첨 및 1000원의 복권을 샀을 경우, 수익률은 200,000,000.0 이어야 한다.")
    @Test
    void first_place_test() {
        //given
        lottoResult.increaseWinningCount(WinningPrice.FIRST_PLACE);
        Map<WinningPrice, Integer> result = lottoResult.getResult();
        int purchaseAmount = 1_000;
        String expectedRate = "200,000,000.0";
        //when
        String rate = ProfitCalculator.rate(result, purchaseAmount);
        //then
        assertThat(rate).isEqualTo(expectedRate);
    }
}
