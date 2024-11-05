package lotto;

import java.util.List;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void 로또번호_발행_테스트() {
        //Given
        int count = 10;
        //When
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoTickets = lottoGenerator.generate(count);
        //Then
        Assertions.assertThat(lottoTickets).hasSize(count);
    }
}