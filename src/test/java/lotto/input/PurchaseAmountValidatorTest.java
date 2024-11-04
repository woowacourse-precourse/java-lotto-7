package lotto.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.enums.ErrorMessages.*;

class PurchaseAmountValidatorTest {
    PurchaseAmountValidator purchaseAmountValidator;

    @BeforeEach
    void setUp() {
        purchaseAmountValidator = new PurchaseAmountValidator();
    }

    @Test
    @DisplayName("유효한 로또 구입 금액 입력 시 금액 반환 테스트")
    public void inputIsValid() {
        //given
        String input = "5000";
        int actualPurchaseAmount = Integer.parseInt(input);

        //when
        int expectedPurchaseAmount = purchaseAmountValidator.validateInput(input, null);

        //then
        Assertions.assertThat(actualPurchaseAmount).isEqualTo(expectedPurchaseAmount);
    }

    @Test
    @DisplayName("입력에 숫자 이외의 문자가 입력되었을 경우 예외 발생 테스트")
    void inputIsInvalidFormat() {
        String input = "1000a";

        Assertions.assertThatThrownBy( ()-> purchaseAmountValidator.validateInput(input, null) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원 미만일 경우 예외 발생 테스트")
    void purchaseAmountIsLessThan1000() {
        String input = "100";

        Assertions.assertThatThrownBy( ()-> purchaseAmountValidator.validateInput(input, null) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_BELOW_MINIMUM.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원 이상이며 1000원 으로 나누어 떨어지지 않는 경우 예외 발생 테스트")
    void purchaseAmountIsNotDividedBy1000() {
        String input = "1001";

        Assertions.assertThatThrownBy( ()-> purchaseAmountValidator.validateInput(input, null) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
    }


}