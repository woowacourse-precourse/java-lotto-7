package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 로또_6개를_맞춘_경우() {
        //when
        LottoResult result = LottoResult.valueOf(6,0);

        //then
        assertThat(result.getRank()).isEqualTo(Rank.SIX_MATCHES);
    }

    @Test
    void 로또에_당첨되지_않은_경우() {
        //when
        LottoResult result = LottoResult.valueOf(0,0);

        //then
        assertEquals(Rank.SMALL_MATCHES , result.getRank());
    }
}