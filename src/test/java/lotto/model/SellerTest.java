package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {
    @Test
    @DisplayName("Customer로부터 받은 돈이 올바른 금액인지 검사")
    void testValidate() {
        Seller seller = new Seller();

        assertThatThrownBy(() -> seller.validate("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> seller.validate("10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> seller.validate("100"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> seller.validate("1001"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> seller.validate("9910"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> seller.validate("9999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
