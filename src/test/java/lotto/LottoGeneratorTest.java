package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();
    @Test
    public void 로또_한개_발행_테스트() {
        //given
        Lotto lotto = lottoGenerator.generate();
        //when
        //then
        Assertions.assertThat(lotto).isNotNull();
    }
}
