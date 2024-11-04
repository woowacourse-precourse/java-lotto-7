package lotto.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.dto.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculateServiceTest {

    private CalculateService calculateService;
    private final Map<LottoResult, Integer> drawResult = new HashMap<>();

    @BeforeEach
    void init(){
        calculateService = new CalculateService();
        drawResult.put(new LottoResult(3,false), 1);
        drawResult.put(new LottoResult(1,true), 1);
    }

    @ParameterizedTest
    @CsvSource({
            "2000,250",
            "5000,100",
            "10000,50"
    })
    void 수익률_계산(int amount, int expected){
        BigDecimal expectedRatio = BigDecimal.valueOf(expected);
        BigDecimal ratio = calculateService.calculateRatio(amount, drawResult);
        Assertions.assertThat(ratio).isEqualTo(expectedRatio);
    }
}