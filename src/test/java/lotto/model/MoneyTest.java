package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("차감되는 액수가 올바른지 확인한다.")
    @Test
    void 차감되는_액수가_올바른지_확인한다() {
        int takedMoney = 2000;

        Money money = new Money(5500);
        int originMoney = money.getLeftMoney();
        money.take(takedMoney);
        int leftMoney = money.getLeftMoney();

        int expect = originMoney - leftMoney;

        assertEquals(takedMoney, expect);
    }

    @DisplayName("남은 돈의 액수가 올바른지 확인한다")
    @Test
    void 남은_돈의_액수가_올바른지_확인한다() {
        Money money = new Money(5500);
        money.take(2000);
        int expect = 5500 - 2000;
        assertEquals(money.getLeftMoney(), expect);
    }

    @DisplayName("가져간 돈과 사용한 돈이 같은지 확인한다.")
    @Test
    void 가져간_돈과_사용한_돈이_같은지_확인한다() {
        int takedMoney = 2000;
        Money money = new Money(5500);

        money.take(takedMoney);
        int usedMoney = money.getUsedMoney();

        assertEquals(takedMoney, usedMoney);
    }

    @DisplayName("수익률을 반환한다")
    @Test
    void 수익률을_반환한다() {
        Money money = new Money(5000);
        money.take(5000);
        money.receiveWinningAmount(7333);
        assertEquals(money.getRateOfReturn(), 146.7);
    }
}