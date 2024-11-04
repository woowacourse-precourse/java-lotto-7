package lotto.util;

import lotto.message.InputErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    public void 유효한_구매금액_파싱_테스트() {
        int amount = inputParser.parseBuy("5000");
        assertEquals(5000, amount);
    }

    @Test
    public void 유효하지_않은_구매금액_파싱_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputParser.parseBuy("-1000"));
        assertEquals(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage(), exception.getMessage());
    }

    @Test
    public void 유효한_당첨번호_파싱_테스트() {
        Set<Integer> winningNumbers = inputParser.parseWinningNumbers("1,2,3,4,5,6");
        assertEquals(Set.of(1, 2, 3, 4, 5, 6), winningNumbers);
    }

    @Test
    public void 유효한_보너스번호_파싱_테스트() {
        int bonusNumber = inputParser.parseBonusNumber("7");
        assertEquals(7, bonusNumber);
    }

    @Test
    public void 유효하지_않은_보너스번호_파싱_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputParser.parseBonusNumber("abc"));
        assertEquals(InputErrorMessage.NON_NUMERIC_BONUS_NUMBER.getMessage(), exception.getMessage());
    }
}
