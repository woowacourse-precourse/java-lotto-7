package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    void 로또_넘버_저장_테스트() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void 로또_넘버_45_이상_에러_테스트() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);

    }


}
