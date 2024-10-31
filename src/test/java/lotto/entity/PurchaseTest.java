package lotto.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
    @Test
    void 성공__사용자가_출력할수있는_티켓_수() {
        // given
        int money = 1000;

        // when
        Purchase purchase = new Purchase(money);

        // then
        purchase.calculateTicketCount();
    }

    @Test
    void 성공__사용자가_결제한_금액() {
        // given
        int money = 1000;

        // when
        Purchase purchase = new Purchase(money);

        // then
        purchase.getPaymentAmount();
    }

    @Test
    void 실패__사용자가_결제한_금액이_로또가격보다_작을때() {
        // given
        int money = 500;

        // when
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격보다 적은 금액입니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_1000원_단위가_아닐때_입력_1001() {
        // given
        int money = 1001;

        // when
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격은 1000원 단위로만 가능합니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_1000원_단위가_아닐때_입력_1999() {
        // given
        int money = 1999;

        // when
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격은 1000원 단위로만 가능합니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_1000원_단위가_아닐때_입력_11001() {
        // given
        int money = 11001;

        // when
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격은 1000원 단위로만 가능합니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_10만원이_초과될_경우() {
        // given
        int money = 100_001;

        // when
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또는 한번에 10만원 까지 구입 가능합니다.", exception.getMessage());
    }

}
