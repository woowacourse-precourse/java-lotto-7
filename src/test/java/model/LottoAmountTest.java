package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoAmountTest {

    @Test
    void LottoAmount_생성_테스트() {
        LottoAmount lottoAmount = new LottoAmount(8234);
        Assertions.assertThat(lottoAmount.getCount()).isEqualTo(8);
    }
}
