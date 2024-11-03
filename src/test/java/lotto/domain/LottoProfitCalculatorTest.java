package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoProfitCalculatorTest {

    private final LottoProfitCalculator calc = new LottoProfitCalculator();

    @DisplayName("당첨 결과가 주어지면 수익을 계산해야 한다.")
    @Test
    public void shouldCalculateProfit_givenWinningResults() {
        //given
        List<Rank> winningResults = List.of(Rank.FIFTH, Rank.SECOND, Rank.MISS);
        
        //when
        BigDecimal profit = calc.calculateProfit(winningResults);
        
        //then
        assertThat(profit).isEqualTo(
            Rank.FIFTH.getPrize().add(Rank.SECOND.getPrize()).add(Rank.MISS.getPrize())
        );
    }
    
    @DisplayName("당첨 수익이 엄청 큰 경우도 계산할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 100, 10_000})
    public void shouldCalculateProfit_whenProfitIsHuge(int lottoQuantity) {
        //given
        List<Rank> winningResults = new ArrayList<>(Collections.nCopies(lottoQuantity, Rank.FIRST));
        
        //when
        BigDecimal profit = calc.calculateProfit(winningResults);
        
        //then
        BigDecimal multiplicand = BigDecimal.valueOf(lottoQuantity);
        assertThat(profit).isEqualTo(Rank.FIRST.getPrize().multiply(multiplicand));
    }
    
    
}