package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfitTest {
    private Profit profit;
    private MatchNumbers matchNumbers;

    @BeforeEach
    void setUp() {
        int purchasePrice = 8000;
        profit = new Profit(purchasePrice);
        matchNumbers = new MatchNumbers();
    }

    @Test
    void 일치하는_로또_번호가_3개일_때_수익률_테스트() {
        matchNumbers.calculate(List.of(
                List.of(1, 3, 5, 14, 22, 45)
        ), List.of(1, 2, 3, 4, 5, 6), 7);

        profit.calculateTotalPrize(matchNumbers);
        profit.calculateRate();

        assertEquals(62.5, profit.getRate());
    }

    @Test
    void 일치하는_로또_번호가_5개와_보너스_번호일_때_수익률_테스트() {
        matchNumbers.calculate(List.of(
                List.of(1, 2, 3, 4, 5, 6)
        ), List.of(1, 2, 3, 4, 5, 10), 6);

        profit.calculateTotalPrize(matchNumbers);
        profit.calculateRate();

        assertEquals(375000.0, profit.getRate());
    }
}
