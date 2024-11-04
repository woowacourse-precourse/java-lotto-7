package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SellerTest {

    @Test
    void 투입금액_만큼_로또를_발행한다() {
        Seller seller = new Seller();
        assertThat(seller.issueLottoesWith(new Money(14000))).hasSize(14);
    }
}
