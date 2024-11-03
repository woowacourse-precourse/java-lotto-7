package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.PurchaseAmount;
import lotto.model.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

class LottoTicketGeneratorTest {
    @Test
    void 구매_가능한_개수만큼_로또가_생성되는지_확인() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<Lotto> lottos = lottoGenerator.generateLottos(RandomStrategy.of(), PurchaseAmount.from("10000"));

        assertThat(lottos.size()).isEqualTo(10);
    }
}
