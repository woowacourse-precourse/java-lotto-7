package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import lotto.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    private LottoCalculator calculator;
    private Map<Rank, Integer> lottoResult;

    @BeforeEach
    void setUp() {
        calculator = new LottoCalculator();
        lottoResult = new EnumMap<>(Rank.class);
    }

    @Test
    void testGetLottoAmount() {
        calculator.setPayment(8000);
        int lottoAmount = calculator.getLottoAmount();
        assertThat(lottoAmount).isEqualTo(8);
    }

    @Test
    void testGetEarningRateFrom() {
        calculator.setPayment(8000);

        lottoResult.put(Rank.FIFTH, 1);
        calculator.setLottoResult(lottoResult);

        float earningRate = calculator.getEarningRateFrom();

        assertThat(earningRate).isEqualTo(62.5f);
    }
}