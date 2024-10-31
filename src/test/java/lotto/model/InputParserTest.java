package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.util.message.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    public void setUp() {
        inputParser = new InputParser();
    }

    @Test
    public void 정상적인_구입_금액이_들어온_경우_예외_발생_안함() {
        String validInput = "8000";
        int purchaseAmount = inputParser.parsePurchaseAmount(validInput);
        assertEquals(8000, purchaseAmount);
    }

    @Test
    public void 구입_금액으로_문자가_들어온_경우_예외_발생() {
        String invalidInput = "abc";
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parsePurchaseAmount(invalidInput)
        );
        assertEquals(ErrorMessage.NUMBER_FORMAT_ERROR, exception.getMessage());
    }

    @Test
    public void 구입_금액으로_음수값이_들어온_경우_예외_발생() {
        String negativeInput = "-1000";
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parsePurchaseAmount(negativeInput)
        );
        assertEquals(ErrorMessage.NEGATIVE_AMOUNT_ERROR, exception.getMessage());
    }

    @Test
    public void 구입_금액으로_1000원으로_나누어_떨어지지_않는_수가_들어온_경우_예외_발생() {
        String nonDivisibleInput = "1500";
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parsePurchaseAmount(nonDivisibleInput)
        );
        assertEquals(ErrorMessage.AMOUNT_UNIT_ERROR, exception.getMessage());
    }
}