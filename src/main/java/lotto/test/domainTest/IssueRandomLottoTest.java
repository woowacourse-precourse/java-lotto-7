package lotto.test.domainTest;

import lotto.domain.IssueRandomLotto;
import lotto.domain.LottoPool;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class IssueRandomLottoTest {
    @Test
    public void testMakeRandomLottoAndGetLotto() {
        IssueRandomLotto issueRandomLotto = new IssueRandomLotto();
        assertThat(issueRandomLotto.makeRandomLotto(BigInteger.TWO,new LottoPool()).getLottosDrawn().size()).isEqualTo(2);
        assertThat(issueRandomLotto.makeRandomLotto(BigInteger.ZERO,new LottoPool()).getLottosDrawn().size()).isEqualTo(0);
    }
}
