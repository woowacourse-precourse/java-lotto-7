package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @DisplayName("1000원당 로또 1장을 발행한다.")
    @Test
    void 천원당_로또_한장을_발행한다() {
        Price price = Price.from("1000");
        LottoIssuer issuer = new LottoIssuer(price);
        assertEquals(issuer.getLottoCount(), 1);
    }
}
