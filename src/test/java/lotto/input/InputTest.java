package lotto.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.domain.User;
import lotto.message.InputMessage;
import lotto.service.InputService;
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
    @DisplayName("검증 시, 모든 기준을 충족하는 문자열이라면 통과한다.")
    public void testNumberInputValidate() {
        assertTrue(InputValidate.run("1000"));
        assertTrue(InputValidate.run("500000"));
        assertTrue(InputValidate.run("30000000"));
        assertTrue(InputValidate.run("2345000"));
    }

    @Test
    @DisplayName("검증 시, 모든 기준을 충족하는 문자열이 아니라면 통과하지 못한다.")
    /*
    1. isNumeric : 양수 문자열인지 확인한다.
    2. isParsableAsInteger : Integer형으로 형변환이 가능한지 확인한다.
    3. isLessThanFirstPrizeAmount : 로또 구입 금액이 1등 당첨금보다 적은 액수인지 확인한다.
    4. isDivisibleBy1000 : 1000으로 나누어 떨어지는 숫자인지 확인한다.
     */
    public void testNotInputValidate() {
        assertFalse(InputValidate.run(""));     // isNumeric
        assertFalse(InputValidate.run(" "));    // isNumeric
        assertFalse(InputValidate.run("abc"));  // isNumeric
        assertFalse(InputValidate.run("100000000000")); // isParsableAsInteger
        assertFalse(InputValidate.run("2500000000"));   // isLessThanFirstPrizeAmount
        assertFalse(InputValidate.run("1500"));// isDivisibleBy1000
    }

    @Test
    @DisplayName("구입금액으로 구매할 수 있는 로또 갯수를 출력한다.")
    public void testPurchasableQuantityBasedOnMoney() {
        // given
        User user = new User();
        user.setMoney("10000");

        // when
        int lottoCount = InputService.getLottoPurchaseAmount(user);

        // then
        assertEquals(lottoCount, 10);
    }
}
