package lotto.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductPriceTest {

    @DisplayName("몇 개를 살 수 있는지 확인할 수 있다.")
    @Test
    void test1() {
        ProductPrice price = new ProductPrice(50);
        Money money = new Money(1_000);

        assertThat(price.countPurchasableProduct(money)).isEqualTo(20);
    }

    @DisplayName("잔돈이 남는지 확인할 수 있다.")
    @Test
    void test2() {
        ProductPrice price = new ProductPrice(1_000);
        Money money = new Money(999);

        assertThat(price.hasChange(money)).isTrue();
    }

}