package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoAmountTest {

    @Test
    void 구입_금액에_따라_로또_개수를_출력한다() {
        LottoAmount lottoAmount = new LottoAmount(5000);
        Assertions.assertEquals(5, lottoAmount.get());

        lottoAmount = new LottoAmount(13000);
        Assertions.assertEquals(13, lottoAmount.get());
    }
}
