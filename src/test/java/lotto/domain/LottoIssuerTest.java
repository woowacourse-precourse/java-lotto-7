package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @DisplayName("로또를 주어진 발행 개수만큼 발급한다.")
    @Test
    void issueLottos() {
        // given
        int lottoCount = 10;
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(lottoNumberGenerator);
        LottoIssuer lottoIssuer = new LottoIssuer(lottoGenerator);

        // when
        List<Lotto> lottos = lottoIssuer.issueLottos(lottoCount);

        // then
        assertThat(lottos).isNotNull();
        assertThat(lottos).hasSize(10);
    }


}