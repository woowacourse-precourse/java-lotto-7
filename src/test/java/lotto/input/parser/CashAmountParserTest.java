package lotto.input.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashAmountParserTest {
    private CashAmountParser cashAmountParser;

    @BeforeEach
    void setUp() {
        cashAmountParser = new CashAmountParser();
    }

    @Test
    void 금액_입력에_음수값이_오면_예외가_발생한다() {
        String input = "-1000";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cashAmountParser.parse(input));
    }

    @Test
    void 금액_입력에_숫자가_아닌_값이_오면_예외가_발생한다() {
        String input = "notNumber";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cashAmountParser.parse(input));
    }

    @Test
    void 금액_입력이_가능한_범위를_초과하면_예외가_발생한다() {
        String input = String.valueOf((long) Integer.MAX_VALUE + 1);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cashAmountParser.parse(input));
    }

    @Test
    void 천_단위_입력이_아니면_예외가_발생한다() {
        String input = "1001";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cashAmountParser.parse(input));
    }

    @Test
    void 정상적인_입력이_들어오면_구매_가능한_갯수를_반환한다() {
        String input = "1000";
        int expected = 1;
        Assertions.assertEquals(expected, cashAmountParser.parse(input));
    }
}
