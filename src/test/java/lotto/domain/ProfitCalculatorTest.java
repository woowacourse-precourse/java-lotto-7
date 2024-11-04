package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "5000, 8000, 62.5",
            "0, 5000, 0.0"
    })
    void 수익률계산_유효한입력_정확한수익률반환(int prize, int money, double expectedProfit) {
        //when
        double profit = ProfitCalculator.calculateProfitRate(prize, money);

        //then
        Assertions.assertEquals(expectedProfit, profit);
    }

}