package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 두번쨰_자리에서_반올림_첫번째까지_보여주기(){
        LottoResult lottoResult = new LottoResult();
        assertThat(lottoResult.calculateEarnings(14000,8)).isEqualTo(175.0);
    }
}