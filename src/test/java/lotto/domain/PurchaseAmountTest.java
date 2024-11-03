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
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");
        assertThat(purchaseAmount.getLottoTickets()).isEqualTo(5);
    }

    @Test
    @DisplayName("1,000,000원을 입력 했을 경우")
    public void test2(){
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000000");
        assertThat(purchaseAmount.getLottoTickets()).isEqualTo(1000);
    }

    @Test
    @DisplayName("정확한 숫자를 입력하지 않은 경우")
    public void test3(){
        assertThatThrownBy(() -> new PurchaseAmount("test"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_NUMBER.getMessage());
    }

    @Test
    @DisplayName("빈 값을 입력한 경우")
    public void test4(){
        assertThatThrownBy(() -> new PurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_NUMBER.getMessage());
    }

    @Test
    @DisplayName("입력한 숫자가 1,000의 단위가 아닌 경우")
    public void test5(){
        assertThatThrownBy(() -> new PurchaseAmount("9999"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_THOUSAND.getMessage());
    }

    @Test
    @DisplayName("입력한 숫자가 1,000의 단위 이지만 음수인 경우")
    public void test6(){
        assertThatThrownBy(() -> new PurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.NEGATIVE_NUMBER.getMessage());
    }

}