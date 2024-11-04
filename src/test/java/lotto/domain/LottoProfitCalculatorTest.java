package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoProfitCalculatorTest {

    private final LottoProfitCalculator calculator = new LottoProfitCalculator();

    @DisplayName("당첨 결과가 주어지면 수익을 계산해야 한다.")
    @Test
    public void shouldCalculateProfit_givenWinningResults() {
        //given
        List<Rank> winningResults = List.of(Rank.FIFTH, Rank.SECOND, Rank.MISS);
        
        //when
        BigDecimal profit = calculator.getProfit(winningResults);
        
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
        BigDecimal profit = calculator.getProfit(winningResults);
        
        //then
        BigDecimal multiplicand = BigDecimal.valueOf(lottoQuantity);
        assertThat(profit).isEqualTo(Rank.FIRST.getPrize().multiply(multiplicand));
    }

    @DisplayName("당첨금과 지불액에 대한 수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"90000,1125", "34000, 425", "3000,37.5", "0,0"})
    public void shouldCalculateProfitRate_givenProfitAndPayment(long actualProfit, String expected) {
        //given
        int payment = 8000;
        BigDecimal profit = BigDecimal.valueOf(actualProfit);
        BigDecimal expectedRate = new BigDecimal(expected);

        //when
        BigDecimal profitRate = calculator.getProfitRate(profit, payment);

        //then
        assertEquals(profitRate.compareTo(expectedRate), 0);
    }

    @DisplayName("수익률을 계산할 때 유효하지 않은 구매 금액이 주어지면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100, Integer.MIN_VALUE})
    public void shouldThrowException_whenCalculateProfitRate_givenInvalidPayment(int payment) {
        //given
        BigDecimal profit = BigDecimal.valueOf(8000L);

        //when &then
        assertThrows(IllegalArgumentException.class,
            () -> calculator.getProfitRate(profit, payment));
    }

    @DisplayName("수익률을 계산할 때 유효하지 않은 당첨금이 주어지면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(longs = {-1, -100, Integer.MIN_VALUE})
    public void shouldThrowException_whenCalculateProfitRate_givenInvalidPayment(long invalidAmount) {
        //given
        BigDecimal profit = BigDecimal.valueOf(invalidAmount);
        int payment = 8000;

        //when &then
        assertThrows(IllegalArgumentException.class,
            () -> calculator.getProfitRate(profit, payment));
    }
}