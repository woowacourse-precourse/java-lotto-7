package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @DisplayName("1,000원당 로또 한 장을 발행한다.")
    @Test
    void 천원당_로또_한_장을_발행한다() {
        int price = 1000;
        LottoIssuer issuer = new LottoIssuer(price);
        List<Lotto> lottos = issuer.getLottos();
        assertEquals(lottos.size(), 1);
    }
}
