package lotto.util.calculator;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[유닛 테스트] - 수익률 계산")
class InvestmentReturnCalculatorTest {

    private final EnumMap<LottoRank, Integer> rankCountMap = new EnumMap<>(LottoRank.class);

    @BeforeEach
    void setRankCountMap() {
        rankCountMap.put(LottoRank.UN_RANK, 0);
        rankCountMap.put(LottoRank.FIFTH_RANK, 1);
        rankCountMap.put(LottoRank.FOURTH_RANK, 0);
        rankCountMap.put(LottoRank.THIRD_RANK, 0);
        rankCountMap.put(LottoRank.SECOND_RANK, 0);
        rankCountMap.put(LottoRank.FIRST_RANK, 0);
    }

    @Test
    @DisplayName("수익률 계산 - 당첨된 금액과 횟수를 전달받아 수익률 계산")
    void lotteryPrizeAndWinningCount_calculateInvestmentReturn() {
        //given & when
        double investmentReturn = InvestmentReturnCalculator.calculate(rankCountMap, 8);

        //then
        assertThat(investmentReturn).isEqualTo(62.5);
    }
}