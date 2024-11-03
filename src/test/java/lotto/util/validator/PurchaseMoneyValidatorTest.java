package lotto.util.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseMoneyValidatorTest {

    /**
     * 통합 기능 테스트
     * 2 Test case
     */
    @Test
    @DisplayName("올바른 숫자가 들어온 경우")
    void check_Normal_Case(){
        // given
        String target = "10000";

        // when
        PurchaseMoneyValidator.validatePurchaseMoney(target);
    }

    @Test
    @DisplayName("비정상적인 숫자가 들어온 경우")
    void check_Abnormal_Case(){
        // given
        String target = "10001";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                // when
                ()->PurchaseMoneyValidator.validatePurchaseMoney(target));
    }

    /**
     * 단위 기능 테스트
     * 8 Test case
     */
    @Test
    @DisplayName("비어있는 입력값이 들어오는 경우")
    void check_Empty_value(){
        // given
        String testTarget = "";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                // when
                () -> PurchaseMoneyValidator.validateEmptyValue(testTarget));
    }

    @Test
    @DisplayName("앞에 불필요한 공백이 포함된 경우")
    void check_Whitespace_Head(){
        // given
        String testTarget = " 1000";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PurchaseMoneyValidator.validateWhitespaceAtHeadOrTail(testTarget));
    }

    @Test
    @DisplayName("뒤에 불필요한 공백이 포함된 경우")
    void check_Whitespace_Tail(){
        // given
        String testTarget = "1000 ";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PurchaseMoneyValidator.validateWhitespaceAtHeadOrTail(testTarget));
    }

    @Test
    @DisplayName("가운데 공백이 끼어있는 경우")
    void check_Whitespace_Middle(){
        // given
        String testTarget = "100 000";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PurchaseMoneyValidator.validateEachCharacterIsDigit(testTarget,null));
    }

    @Test
    @DisplayName("맨 앞에 - 가 붙어있는 경우(음수 확인)")
    void check_Minus_Sign(){
        // given
        String testTarget = "-1000";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PurchaseMoneyValidator.validateEachCharacterIsDigit(testTarget,null));
    }

    @Test
    @DisplayName("가운데에 , 구분자가 있는 경우")
    void check_Money_Delimiter(){
        // given
        String testTarget = "3,000";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PurchaseMoneyValidator.validateEachCharacterIsDigit(testTarget,null));
    }

    @Test
    @DisplayName("맨 앞에 0으로 시작하는 경우")
    void check_Not_Divide_BY_ZERO(){
        // given
        String testTarget = "001000";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PurchaseMoneyValidator.validateStartWithZero(testTarget,null));
    }

    @Test
    @DisplayName("숫자가 1000으로 나뉘어 떨어지지 않는 경우")
    void check_Not_Divide_BY_BASE_UNIT(){
        // given
        String testTarget = "12345";
        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> PurchaseMoneyValidator.validateDivisibleByBaseUnit(testTarget));
    }
}