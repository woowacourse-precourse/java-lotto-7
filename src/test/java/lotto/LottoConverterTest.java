package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoConverterTest {

    @Test
    void 금액에_따른_로또여러개를_구입한다() {
        //given
        LottoConverter lottoConverter = new LottoConverter(1000);

        //when
        List<Lotto> lottos = lottoConverter.convertLotto(2000);

        //then
        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }
}
