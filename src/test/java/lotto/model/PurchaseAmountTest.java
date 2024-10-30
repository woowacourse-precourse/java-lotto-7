package lotto.model;

import lotto.model.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @DisplayName("금액이 천원 단위가 아닌 경우")
    @Test
    void 금액이_천원_단위가_아닌_경우(){
        int money=1001;
        Assertions.assertThatThrownBy(()->new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 천원 단위 인 경우")
    @Test
    void 금액이_천원_단위_인_경우(){
        int money=1000;
        PurchaseAmount result= new PurchaseAmount(money);
        assertEquals(money,result.getMoney());
    }

    @DisplayName("금액이 0이하인 경우")
    @Test
    void 금액이_0이하인_경우(){
        int money=0;
        Assertions.assertThatThrownBy(()->new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}