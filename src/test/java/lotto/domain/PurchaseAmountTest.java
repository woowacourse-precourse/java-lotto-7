package lotto.domain;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @Test
    @DisplayName("5,000원을 입력 했을 경우")
    public void test1(){
        String money = "5000";
        int result = 5;
        PurchaseAmount purchaseAmount = new PurchaseAmount(money);
        assertThat(purchaseAmount.getLottoTickets()).isEqualTo(result);
    }

    @Test
    @DisplayName("1,000,000원을 입력 했을 경우")
    public void test2(){
        String money = "1000000";
        int result = 1000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(money);
        assertThat(purchaseAmount.getLottoTickets()).isEqualTo(result);
    }

    @Test
    @DisplayName("정확한 숫자를 입력하지 않은 경우")
    public void test3(){
        String test = "test";
        assertThatThrownBy(() -> new PurchaseAmount(test))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("빈 값을 입력한 경우")
    public void test4(){
        String test = "t";
        assertThatThrownBy(() -> new PurchaseAmount(test))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("입력한 숫자가 1,000의 단위가 아닌 경우")
    public void test5(){
        String test = "9999";
        assertThatThrownBy(() -> new PurchaseAmount(test))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_THOUSAND.getMessage());
    }

    @Test
    @DisplayName("입력한 숫자가 1,000의 단위 이지만 음수인 경우")
    public void test6(){
        String test = "-1000";
        assertThatThrownBy(() -> new PurchaseAmount(test))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.NEGATIVE_NUMBER.getMessage());
    }

}