package lotto;

import lotto.domain.purchase.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseTest {

    @Test
    @DisplayName("숫자가 아닌 값에 대해 예외처리에 성공한다.")
    void validateInputTest() {
        String input = "dongdong";
        assertThatThrownBy(() -> new Purchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000원 단위가 아닌 값에 대해 예외처리에 성공한다.")
    void validateMoneyTest() {
        String input = "1111";
        assertThatThrownBy(() -> new Purchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액에 따른 올바른 갯수의 로또를 생성한다.")
    void numberOfLottoTest() {
        //given
        String input = "15000";
        //when
        Purchase purchase = new Purchase(input);
        //then
        assertThat(purchase.numberOfLotto()).isEqualTo(15);
    }
}
