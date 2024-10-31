package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("차감되는 액수가 올바른지 확인한다.")
    void 차감되는_액수가_올바른지_확인한다() {
        int takedMoney = 2000;

        Money money = new Money(5500);
        int originMoney = money.getLeftMoney();
        money.take(takedMoney);
        int leftMoney = money.getLeftMoney();

        int expect = originMoney - leftMoney;

        assertEquals(takedMoney, expect);
    }

    @Test
    @DisplayName("남은 돈의 액수가 올바른지 확인한다")
    void 남은_돈의_액수가_올바른지_확인한다() {
        Money money = new Money(5500);
        money.take(2000);
        int expect = 5500 - 2000;
        assertEquals(money.getLeftMoney(), expect);
    }
}