package lotto;

import java.util.HashMap;
import lotto.domain.calculator.Calculator;
import lotto.domain.calculator.ProfitCalculator;
import lotto.dto.ProfitDto;
import lotto.dto.data.Receipt;
import lotto.utils.LottoMatchStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new ProfitCalculator();
    }

    @Test
    void 구매_금액이_당첨_금액보다_클때() {
        //given
        HashMap<LottoMatchStatus, Integer> map = new HashMap<>();
        map.put(LottoMatchStatus.THREE_MATCH_RESULT, 1);

        ProfitDto profitDto = new ProfitDto(map, new Receipt(8000));

        //when
        double result = (double) calculator.calculate(profitDto);

        //then
        Assertions.assertEquals(result, 62.5);
    }

    @Test
    void 구매_금액이_당첨_금액보다_작을때() {
        //given
        HashMap<LottoMatchStatus, Integer> map = new HashMap<>();
        map.put(LottoMatchStatus.FOUR_MATCH_RESULT, 1);

        ProfitDto profitDto = new ProfitDto(map, new Receipt(8000));

        //when
        double result = (double) calculator.calculate(profitDto);

        //then
        Assertions.assertEquals(result, 625);
    }
}