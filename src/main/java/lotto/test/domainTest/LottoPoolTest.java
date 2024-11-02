package lotto.test.domainTest;

import lotto.Lotto;
import lotto.domain.IssueRandomLotto;
import lotto.domain.LottoPool;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;

public class LottoPoolTest {
    @Test
    public void testAddToDrawnLotto() {
        LottoPool lottoPool = new LottoPool();
        lottoPool.addToDrawnLottos(new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(lottoPool.getLottosDrawn().size()).isEqualTo(1);
    }

    @Test
    public void run(){
        testAddToDrawnLotto();
    }
}
