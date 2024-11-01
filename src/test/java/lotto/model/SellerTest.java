package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {
    private final Seller seller = new Seller();

    @Test
    @DisplayName("Customer로부터 받은 돈이 올바른 금액인지 검사")
    void testValidate() {
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

    @Test
    @DisplayName("Lotto 발행 테스트")
    void testGetLottoTickets() {
        seller.createLottoTickets(8000);

        for (int i = 0; i < seller.getLottoTickets().size(); i++) {
            Lotto lotto = seller.getLottoTickets().get(i);

            assertThat(lotto.getNumbers().size()).isEqualTo(6);
            assertThat(lotto.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45)).isTrue();
        }

    }
}
