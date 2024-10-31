package lotto.domain;

import lotto.strategy.IssueStrategy;
import lotto.support.ManualIssueStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoTest {

    @Test
    void 사용자_로또_정보_생성() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(10_000L);
        IssueStrategy issueStrategy = ManualIssueStrategy.of(10, 11, 12, 13, 14, 15);

        //when
        UserLotto userLotto = new UserLotto(lottoPurchase, issueStrategy);

        //then
        assertThat(userLotto.getPurchase().getMoney()).isEqualTo(10_000L);
        assertThat(userLotto.getPurchase().getCount()).isEqualTo(10);
        assertThat(userLotto.getLottos()).hasSize(10);
    }
}
