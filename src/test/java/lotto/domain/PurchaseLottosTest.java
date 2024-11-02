package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseLottosTest {
    @Test
    public void 객체_생성_확인() {
        Integer money = 4_000;
        PurchaseLottos purchaseLottos = new PurchaseLottos(money);
        Integer expect = 4;
        assertThat(purchaseLottos.getLottos().size()).isEqualTo(expect);
    }
}