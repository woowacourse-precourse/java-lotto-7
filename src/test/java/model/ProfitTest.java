package model;

import lotto.model.Profit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProfitTest {
    private Profit profit;

    @BeforeEach
    void setUp() {
        profit = new Profit();
    }

    @Test
    void constructor_ShouldInitializeProfitAndRateToZero() {
        // when
        int initialProfit = profit.getProfit();
        double initialRate = profit.getProfitRate();

        // then
        assertThat(initialProfit).isEqualTo(0);
        assertThat(initialRate).isEqualTo(0.0);
    }

    @Test
    void addProfit_ShouldIncreaseProfitCorrectly() {
        // given
        profit.addProfit(1000);

        // when
        int updatedProfit = profit.getProfit();

        // then
        assertThat(updatedProfit).isEqualTo(1000);

        // when
        profit.addProfit(500);
        updatedProfit = profit.getProfit();

        // then
        assertThat(updatedProfit).isEqualTo(1500);
    }

    @Test
    void setProfitRate_ShouldUpdateProfitRateCorrectly() {
        // when
        profit.setProfitRate(75.5);

        // then
        assertThat(profit.getProfitRate()).isEqualTo(75.5);
    }
}
