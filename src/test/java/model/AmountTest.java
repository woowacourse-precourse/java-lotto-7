package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class AmountTest {

    @Test
    void amount_생성확인_테스트() {
        Amount amount1 = new Amount(8000);

        int value = amount1.getPurchaseAmount();

        assertThat(value).isEqualTo(8000);
    }

    @Test
    @DisplayName("amount_생성_불가_테스트1 : divide not by Lotto value")
    void amount_생성_불가_테스트1(){
        int amount = 8741;

        assertThatThrownBy(()->new Amount(amount))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("amount_생성_불가_테스트2 : buy lotto over limit")
    void amount_생성_불가_테스트2(){
        int amount = 100001;

        assertThatThrownBy(()->new Amount(amount))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
