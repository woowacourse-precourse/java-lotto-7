package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("로또가 정상적으로 발행된다.")
    @Test
    void issueLotto() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(lottoNumberGenerator);

        // when
        Lotto lotto = lottoGenerator.issueLotto();

        // then
        Assertions.assertThat(lotto).isNotNull();
    }

}