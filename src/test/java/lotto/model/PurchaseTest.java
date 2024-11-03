package lotto.model;

import lotto.util.CommonIo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {
    private Purchase purchase;

    @BeforeEach
    void setUp() {
        purchase = new Purchase(new CommonIo());
    }

    @Test
    @DisplayName("입력받은 구입 금액에 맞는 구입 숫자를 반환하는지 테스트")
    void purchaseTicket(){
        assertThat(purchase.convertMoneyToTicket(8000)).isEqualTo(8);
        assertThat(purchase.convertMoneyToTicket(100000)).isEqualTo(100);
        assertThat(purchase.convertMoneyToTicket(5000)).isEqualTo(5);
    }
}