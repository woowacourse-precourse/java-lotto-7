package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoConstants;
import lotto.model.LottoMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMakerTest {
    @DisplayName("정상적인 로또 구현 경우 테스트")
    @Test
    void 정상적인_로또_구현_경우_테스트() {
        Long count = 5L;
        List<Lotto> lottos = LottoMaker.makeLottos(count);

        assertThat(lottos).hasSize(count.intValue());
        assertThat(lottos).allMatch(lotto -> lotto.getNumbers().size() == LottoConstants.LOTTO_NUMBER_COUNT);
    }
}
