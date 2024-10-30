package lotto.domain;

import lotto.utils.TestNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {

    @Test
    void 구입_금액_만큼_로또를_생성한다(){
        TestNumbersGenerator testNumbersGenerator = new TestNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));
        LottoStore lottoStore = new LottoStore(testNumbersGenerator);

        LottoTicket lottoTicket = lottoStore.buyLottoTicket(3000);

        Assertions.assertThat(lottoTicket.getLottos().size()).isEqualTo(3);
    }
}
