package lotto.service;

import java.util.Arrays;
import lotto.domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRevenueCalculatorTest {
    @Test
    public void 총_수입_계산_테스트() throws Exception {
        //given
        LottoRevenueCalculator lottoRevenueCalculator = new LottoRevenueCalculator();
        int[] rankCounts = new int[LottoRank.values().length];
        rankCounts[1] = 1;
        rankCounts[4] = 1;
        long expected = LottoRank.SECOND.getPrize() + LottoRank.FIFTH.getPrize();
        //when
        long totalRevenue = lottoRevenueCalculator.calculateTotalRevenue(rankCounts);
        //then
        Assertions.assertThat(totalRevenue).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"'0,0,0,0,1,0',50.0, 10000",
            "'1,0,0,0,0,0',20000000.0, 10000",
            "'0,0,0,0,2,0',100.0, 10000",
            "'0,0,0,0,1,0',62.5, 8000",
            "'0,0,2,0,2,0',8852.9, 34000",
            "'2,0,0,0,0,0',11_764_705.8, 34000",
    })
    public void 총_수익률_계산_테스트(String inputRankCounts, float expected, int inputMoney) throws Exception {
        //given
        int[] rankCounts = Arrays.stream(inputRankCounts.split(",")).mapToInt(Integer::parseInt).toArray();
        LottoRevenueCalculator lottoRevenueCalculator = new LottoRevenueCalculator();
        //when
        float RateOfRevenue = lottoRevenueCalculator.calculateRateOfRevenue(rankCounts, inputMoney);
        //then
        Assertions.assertThat(RateOfRevenue).isEqualTo(expected);
    }
}