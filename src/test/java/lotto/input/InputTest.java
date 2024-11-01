package lotto.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.message.InputMessage;
import lotto.validate.InputValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    @DisplayName("구입금액을 입력하라는 메시지가 정상출력된다.")
    public void testDisplayRequestInputAmount() {
        // given
        String message = InputMessage.REQUEST_INPUT_AMOUNT.getMessage();

        // then
        assertEquals(message, "구입금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("구입금액은 숫자 문자열만 가능하다.")
    public void testValidateRequestNumberInput() {
        // given
        String input = "123";

        // when
        boolean result = InputValidate.isNumeric(input);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("구입금액은 숫자 문자열이 아니라면 불가능하다.")
    public void testValidateRequestNotNumberInput() {
        // given
        String input = "test";

        // when
        boolean result = InputValidate.isNumeric(input);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("구입금액을 문자형으로 형 변환이 가능하다.")
    public void testValidateIntegerInput() {
        assertTrue(InputValidate.isParsableAsInteger("0"));
        assertTrue(InputValidate.isParsableAsInteger("100000"));
        assertTrue(InputValidate.isParsableAsInteger("50000000"));
        assertTrue(InputValidate.isParsableAsInteger("2000000000"));
    }

    @Test
    @DisplayName("구입금액을 문자형으로 형 변환이 불가능하다.")
    public void testValidateLongerInput() {
        assertFalse(InputValidate.isParsableAsInteger("10000000000"));
        assertFalse(InputValidate.isParsableAsInteger("300000000000000"));
        assertFalse(InputValidate.isParsableAsInteger("50000000000000000"));
        assertFalse(InputValidate.isParsableAsInteger("10000000000000000000"));
    }

    @Test
    @DisplayName("로또 구입금액이 1등 당첨금보다 적다.")
    public void testPurchaseAmountLessThanFirstPrize() {
        assertTrue(InputValidate.isLessThanFirstPrizeAmount(0));
        assertTrue(InputValidate.isLessThanFirstPrizeAmount(25000));
        assertTrue(InputValidate.isLessThanFirstPrizeAmount(300000));
    }

    @Test
    @DisplayName("로또 구입금액이 1등 당첨금보다 많을 수 없다.")
    public void testPurchaseAmountMoreThanFirstPrize() {
        assertFalse(InputValidate.isLessThanFirstPrizeAmount(2000500000));
        assertFalse(InputValidate.isLessThanFirstPrizeAmount(2000100000));
    }

    @Test
    @DisplayName("로또 구입금액은 1000원단위만 가능하다.")
    public void testPurchaseAmountDivisibleBy1000() {
        assertTrue(InputValidate.isDivisibleBy1000(1000));
        assertTrue(InputValidate.isDivisibleBy1000(25000));

        assertFalse(InputValidate.isDivisibleBy1000(1500));
        assertFalse(InputValidate.isDivisibleBy1000(31200));
    }


    @Test
    @DisplayName("검증 시, 숫자 문자열이라면 통과한다.")
    public void testNumberInputValidate() {
        assertTrue(InputValidate.run("0"));
        assertTrue(InputValidate.run("123"));
        assertTrue(InputValidate.run("10000"));
        assertTrue(InputValidate.run("50000"));
    }

    @Test
    @DisplayName("검증 시, 숫자 문자열이 아니라면 통과 못한다.")
    public void testNotNumberInputValidate() {
        assertFalse(InputValidate.run("abc"));
        assertFalse(InputValidate.run("test123"));
        assertFalse(InputValidate.run(""));
        assertFalse(InputValidate.run(" "));
    }
}
