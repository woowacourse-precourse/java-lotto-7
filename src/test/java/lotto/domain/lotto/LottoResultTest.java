package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.HashMap;
import lotto.domain.Investment;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 수익률은_잘나와야_한다() {
        //given
        LottoResult lottoResult = new LottoResult(new HashMap<>(), BigInteger.valueOf(5000));

        //when
        Double profitRate = lottoResult.calculateReturnRate(new Investment(BigInteger.valueOf(8000)));

        //then
        assertThat(profitRate).isEqualTo(62.5);
    }

    @Test
    void 수익률_계산_반올림() {
        //given
        LottoResult lottoResult = new LottoResult(new HashMap<>(), BigInteger.valueOf(8234));

        //when
        Double profitRate = lottoResult.calculateReturnRate(new Investment(BigInteger.valueOf(10000)));

        //then
        assertThat(profitRate).isEqualTo(82.3);
    }
}
